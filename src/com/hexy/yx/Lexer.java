package com.hexy.yx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lexer
{
    private ArrayList<Token> tokens;
    private boolean isString;
    private boolean isMLComment;

    public void printTokens()
    {
        for(Token t : tokens)
        {
            System.out.println(t);
        }
    }

    private void addToken(Tokens token, String data)
    {
        tokens.add(new Token(token, data)); 
    }

    public void tokenize(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner text = new Scanner(file);
        while(text.hasNextLine())
        {
            String line = text.nextLine();
            StringBuilder chars = new StringBuilder();
            for(int i = 0; i < line.length(); i++)
            {
                chars.append(line.charAt(i));
                if(chars.toString().strip().equals("//"))
                {
                    chars = new StringBuilder();
                    break;
                }
                if(chars.toString().strip().equals("/*"))
                {
                    chars = new StringBuilder();
                    isMLComment = true;
                }
                if(chars.toString().strip().substring(chars.length() - 2).equals("*/"))
                {
                    isMLComment = false;
                    chars = new StringBuilder();
                }
                if(isMLComment)
                    continue;
                if(chars.toString().equals("\""))
                {
                    isString = false;
                }
                if(isString)
                {
                    if(chars.substring(chars.length() - 1).equals("\""))
                    {
                        isString = false;
                        addToken(Tokens.STRING, chars.toString());
                        chars = new StringBuilder();
                    }
                    else
                        continue;
                }

                //do the rest of the stuff
            }
        }
    }
}

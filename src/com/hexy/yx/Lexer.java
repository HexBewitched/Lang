package com.hexy.yx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lexer
{
    private ArrayList<Token> tokens;

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
            }
        }
    }
}

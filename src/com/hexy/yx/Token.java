package com.hexy.yx;

public class Token
{
    private Tokens tokenType;
    private String tokenValue;

    public Token(Tokens tokenType, String tokenValue)
    {
        this.tokenType = tokenType;
        this.tokenValue = tokenValue;
    }

    @Override
    public String toString()
    {
        return "" + tokenType;
    }

    public Tokens getTokenType()
    {
        return tokenType;
    }

    public String getTokenValue()
    {
        return tokenValue;
    }
}

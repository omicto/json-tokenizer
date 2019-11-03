package com.cjs.lexer;

public class Text extends Token {
    public final String str;

    public Text(String str) {
        super(Tag.STRING);
        this.str = str;
    }

    @Override
    protected String getTokenValue() {
        return "\"" + str + "\"";
    }
}

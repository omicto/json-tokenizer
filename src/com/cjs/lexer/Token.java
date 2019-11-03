package com.cjs.lexer;

public class Token {
    public final Tag tag;

    public Token(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return tag.name() + ": " + getTokenValue();
    }

    protected String getTokenValue(){
        return String.valueOf((char)tag.tag);
    }
}

package com.cjs.lexer;

public class Text extends Token<String> {

    public Text(String str) {
        super(Tag.STRING, str);
    }

    @Override
    public String toString() {
        return tag.name() + ": \"" + value + "\"";
    }
}

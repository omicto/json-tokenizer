package com.cjs.lexer;

public class Word extends Token<String> {

    private Word(Tag tag, String value) {
        super(tag, value);
    }

    public static final Word TRUE = new Word(Tag.TRUE, "true");
    public static final Word FALSE = new Word(Tag.FALSE, "false");
    public static final Word NULL = new Word(Tag.NULL, "null");

}

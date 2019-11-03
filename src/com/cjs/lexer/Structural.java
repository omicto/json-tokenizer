package com.cjs.lexer;

public class Structural extends Token<Character> {
    private static final Character [] CHARACTERS = {'{', '}', '[', ']', ',', ':'};

    public static final Structural OPEN_ARRAY = new Structural(Tag.OPEN_ARRAY),
                                   CLOSE_ARRAY = new Structural(Tag.CLOSE_ARRAY),
                                   OPEN_OBJECT = new Structural(Tag.OPEN_OBJECT),
                                   CLOSE_OBJECT = new Structural(Tag.CLOSE_OBJECT),
                                   VALUE_SEPARATOR = new Structural(Tag.VALUE_SEPARATOR),
                                   NAME_SEPARATOR = new Structural(Tag.NAME_SEPARATOR);

    private Structural(Tag tag) {
        super(tag, (char) tag.tag);
    }

    public static final Character [] CHARACTERS(){
        return CHARACTERS;
    }

}

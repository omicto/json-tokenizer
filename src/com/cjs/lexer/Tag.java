package com.cjs.lexer;

public enum Tag {
    OPEN_OBJECT('{'),
    CLOSE_OBJECT('}'),
    OPEN_ARRAY('['),
    CLOSE_ARRAY(']'),
    VALUE_SEPARATOR(','),
    NAME_SEPARATOR(':'),
    FALSE(256),
    TRUE(257),
    NULL(258),
    STRING(259),
    NUM(260),
    ERR('e');

    public final int tag;
    Tag(int tag){
        this.tag = tag;
    }

}

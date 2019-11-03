package com.cjs.lexer;

public abstract class Token <T>{
    public final Tag tag;
    public final T value;
    public Token(Tag tag, T value) {
        this.tag = tag;
        this.value = value;
    }

    @Override
    public String toString() {
        return tag.name() + ": " + value;
    }

}

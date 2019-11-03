package com.cjs.lexer;

public class Num extends Token {
    public final double val;
    public Num(double val) {
        super(Tag.NUM);
        this.val = val;
    }

    @Override
    protected String getTokenValue() {
        return String.valueOf(val);
    }
}

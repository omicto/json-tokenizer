package com.cjs.lexer;

public class Num extends Token<Double> {
    public Num(double val) {
        super(Tag.NUM, val);
    }
}

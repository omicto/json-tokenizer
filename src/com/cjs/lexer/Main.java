package com.cjs.lexer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Lexer lex = new Lexer();
        try{
            Token t;
            do {
                t = lex.scan();
                System.out.println(t);
            }while (t != null);

        } catch (IOException e) {

        }
    }
}

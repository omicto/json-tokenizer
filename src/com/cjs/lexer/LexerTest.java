package com.cjs.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;


class LexerTest {

    @Test
    void tokenize() {
        Lexer lex = new Lexer("{\n" +
                "  \"hola\" : \"mundo\",\n" +
                "  \"arreglo\" : [\"tacos\", \"m a l\", \"escr1t0\"],\n" +
                "  \"obj\": \n" +
                "  {\n" +
                "    \"uno\": 1, \"dos\" : -2.002, \"true\" : true\n" +
                "  }\n" +
                "}");
//        Lexer lex = new Lexer("-1");
        List<Token> tokens = lex.tokenize();
        tokens.forEach(System.out::println);
    }
}
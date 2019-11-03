package com.cjs.lexer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    @Test
    void tokenize() {
        Lexer lex = new Lexer("{\"hola\": 1.235,\n" +
                " \"mundo\":[1,2,3, \"hola\", false, true, null]}");
//        Lexer lex = new Lexer("\"Hola]\"");
        List<Token> tokens = lex.tokenize();
        tokens.forEach(System.out::println);
    }
}
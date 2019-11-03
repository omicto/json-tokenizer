package com.cjs.lexer;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while(scan.hasNextLine()){
            sb.append(scan.nextLine());
        }
        Lexer lex = new Lexer(sb.toString());
        List<Token> tokens = lex.tokenize();
        tokens.forEach(System.out::println);
    }

}

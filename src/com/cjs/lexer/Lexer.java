package com.cjs.lexer;

import java.io.IOException;

public class Lexer {
    public static int line = 1;
//    public static int currentChar = 0;
    char peek = ' ';

    void readch() throws IOException {
        peek = (char)System.in.read();
//        currentChar++;
    }

    boolean readch(char c) throws IOException{
        readch();
        if(peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException{
//        System.in.skip(currentChar);
        while (true) {
            if(peek == ' ' || peek == '\t'){
                readch();
                continue;
            }else if(peek == '\n'){
                readch();
                line++;
            }else{
                break;
            }
        }
        switch (peek) {
            case '{':
                peek = ' ';
                return new Token(Tag.OPEN_OBJECT);
            case '}':
                peek = ' ';
                return new Token(Tag.CLOSE_OBJECT);
            case '[':
                peek = ' ';
                return new Token(Tag.OPEN_ARRAY);
            case ']':
                peek = ' ';
                return new Token(Tag.CLOSE_ARRAY);
            case ',':
                peek = ' ';
                return new Token(Tag.VALUE_SEPARATOR);
            case ':':
                peek = ' ';
                return new Token(Tag.NAME_SEPARATOR);
            case '-':
                readch();
                if (Character.isDigit(peek)) {
                    return new Num(-1 * readNumber());
                }
                break;
            case '"':
                StringBuffer b = new StringBuffer();
                readch();
                do{
                    b.append(peek);
                    readch();
                }while (peek == ' ' || (peek != '"') && Character.isLetterOrDigit(peek));
                String s = b.toString();
                return new Text(s);
        }
        if(Character.isDigit(peek)){
            return new Num(readNumber());
        }
        peek = ' ';
        return new Token(Tag.ERR);
    }

    private double readNumber() throws IOException {
        int v = 0;
        do {
            v = 10*v + Character.digit(peek, 10);
            readch();
        }while (Character.isDigit(peek));
        if(peek != '.') return v;
        double x = v;
        float d = 10;
        while (true) {
            readch();
            if(!Character.isDigit(peek)) break;
            x = x + Character.digit(peek, 10) / d;
            d *= 10;
        }
        return x;
    }
}

package com.cjs.lexer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lexer {
    private final String input;
    private final List<Token> tokens;
    private final List<Character> structural = Arrays.asList(Structural.CHARACTERS());
    private int pos = 0;

    public Lexer(String input) {
        this.input = input;
        tokens = new LinkedList<>();
    }

    public List<Token> tokenize() {
        if (!tokens.isEmpty()) return tokens;
        scan();
        return tokens;
    }

    private void scan() {
        char charAt;
        while (pos < input.length()) {
            charAt = input.charAt(pos);
            if (Character.isSpaceChar(charAt)) {
                pos++;
                continue;
            }
            switch (charAt) {
                case '{':
                    tokens.add(Structural.OPEN_OBJECT);
                    pos++;
                    continue;
                case '}':
                    tokens.add(Structural.CLOSE_OBJECT);
                    pos++;
                    continue;
                case '[':
                    tokens.add(Structural.OPEN_ARRAY);
                    pos++;
                    continue;
                case ']':
                    tokens.add(Structural.CLOSE_ARRAY);
                    pos++;
                    continue;
                case ',':
                    tokens.add(Structural.VALUE_SEPARATOR);
                    pos++;
                    continue;
                case ':':
                    tokens.add(Structural.NAME_SEPARATOR);
                    pos++;
                    continue;
            }
            int isNegative = 1;
            if (charAt == '-') {
                isNegative = -1;
                charAt = input.charAt(++pos);
            }
            if (Character.isDigit(charAt)) {
                tryToReadNumber(isNegative);
                continue;
            }
            if (charAt == '"') {
                tryToReadString();
                continue;
            }

            //TODO Try to read value literals

            pos++;
        }
    }

    private void tryToReadString() {
        StringBuffer b = new StringBuffer();
        char charAt = input.charAt(++pos);
        do {
            b.append(charAt);
            charAt = input.charAt(++pos);
        } while (charAt != '"' && (Character.isSpaceChar(charAt) || Character.isLetterOrDigit(charAt)));
        String s = b.toString();
        tokens.add(new Text(s));
        pos++;
    }

    private void tryToReadNumber(int isNegative) {
        int v = 0;
        char charAt = input.charAt(pos);
        do {
            v = 10 * v + Character.digit(charAt, 10);
            charAt = input.charAt(++pos);
        } while (Character.isDigit(charAt));
        if (charAt != '.') {
            tokens.add(new Num(v * isNegative));
            return;
        }
        double x = v;
        float d = 10;
        while (true) {
            pos++;
            charAt = input.charAt(pos);
            if (!Character.isDigit(charAt)) break;
            x = x + Character.digit(charAt, 10) / d;
            d *= 10;
        }
        tokens.add(new Num(x * isNegative));
    }

}


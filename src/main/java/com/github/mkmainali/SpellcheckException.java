package com.github.mkmainali;

public class SpellcheckException extends Exception {

    public SpellcheckException(String msg) {
        super(msg);
    }

    public SpellcheckException(String msg, Exception e) {
        super(msg, e);
    }
}

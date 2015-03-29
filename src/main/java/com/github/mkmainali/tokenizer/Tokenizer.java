package com.github.mkmainali.tokenizer;

import java.util.Iterator;

public interface Tokenizer {

    public Iterator<String> tokenize(String str);
}

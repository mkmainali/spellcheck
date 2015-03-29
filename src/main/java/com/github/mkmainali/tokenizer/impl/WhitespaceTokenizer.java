package com.github.mkmainali.tokenizer.impl;

import com.github.mkmainali.tokenizer.Tokenizer;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.Iterator;

public class WhitespaceTokenizer implements Tokenizer {

    @Override
    public Iterator<String> tokenize(String str) {
        return Splitter.on(CharMatcher.WHITESPACE).omitEmptyStrings().trimResults().split(str).iterator();
    }
}

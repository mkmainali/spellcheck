package com.github.mkmainali.reader;

import com.github.mkmainali.SpellcheckException;

import java.util.Iterator;

public interface Reader {

    public Iterator<String> getTrainingData() throws SpellcheckException;
}

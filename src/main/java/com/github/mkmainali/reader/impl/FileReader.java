package com.github.mkmainali.reader.impl;

import com.github.mkmainali.SpellcheckException;
import com.github.mkmainali.reader.Reader;
import com.google.common.base.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class FileReader implements Reader {

    private final File trainingFile;

    public FileReader(String file) {
        this.trainingFile = new File(file);
    }

    @Override
    public Iterator<String> getTrainingData() throws SpellcheckException {
        try {
            return FileUtils.lineIterator(trainingFile, Charsets.UTF_8.name());
        } catch (IOException e) {
            throw new SpellcheckException("Failed to read the training data", e);
        }
    }
}

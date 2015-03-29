package com.github.mkmainali.filters.impl;

import com.github.mkmainali.filters.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StopwordFilter implements Filter {

    private final Set<String> stopWords;

    public StopwordFilter() {
        this(null);
    }

    public StopwordFilter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public List<String> apply(List<String> tokens) {
        if (stopWords != null && tokens != null) {
            List<String> result = new ArrayList<String>(tokens.size());
            for (String entry : tokens) {
                if (!stopWords.contains(entry)) {
                    result.add(entry);
                }
            }
            return result;
        }
        return tokens;
    }
}

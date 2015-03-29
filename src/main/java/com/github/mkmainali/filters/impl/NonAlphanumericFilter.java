package com.github.mkmainali.filters.impl;

import com.github.mkmainali.filters.Filter;

import java.util.ArrayList;
import java.util.List;

public class NonAlphanumericFilter implements Filter {

    @Override
    public List<String> apply(List<String> tokens) {
        if (tokens != null) {
            List<String> result = new ArrayList<String>(tokens.size());
            for (String entry : tokens) {
                for (String tmp : entry.split("[^a-zA-Z0-9]")) {
                    result.add(tmp);
                }
            }
            return result;
        }
        return tokens;
    }
}

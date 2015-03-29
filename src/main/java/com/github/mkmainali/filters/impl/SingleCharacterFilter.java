package com.github.mkmainali.filters.impl;

import com.github.mkmainali.filters.Filter;

import java.util.ArrayList;
import java.util.List;

public class SingleCharacterFilter implements Filter {

    @Override
    public List<String> apply(List<String> tokens) {
        if(tokens != null){
            List<String> result = new ArrayList<String>(tokens.size());
            for(String entry : tokens){
                if(entry.length() > 1) {
                    result.add(entry);
                }
            }
            return result;
        }
        return tokens;
    }
}

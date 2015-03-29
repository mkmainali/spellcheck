package com.github.mkmainali.filters.impl;

import com.github.mkmainali.filters.Filter;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.List;

public class LowercaseFilter implements Filter {

    @Override
    public List<String> apply(List<String> tokens) {
        if(tokens != null){
            List<String> result = Lists.transform(tokens, new Function<String, String>() {
                @Nullable
                @Override
                public String apply(String input) {
                    if(input != null){
                        return input.toLowerCase();
                    }
                    return null;
                }
            });
            return result;
        }
        return tokens;
    }
}

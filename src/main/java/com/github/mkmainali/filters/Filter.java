package com.github.mkmainali.filters;

import java.util.List;

public interface Filter {

    public List<String> apply(List<String> tokens);
}

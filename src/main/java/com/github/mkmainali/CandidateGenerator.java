package com.github.mkmainali;

import java.util.Set;

public interface CandidateGenerator {

    public Set<String> generateCandidates(String word, int edit);
}

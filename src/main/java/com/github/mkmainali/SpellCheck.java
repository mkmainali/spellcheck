package com.github.mkmainali;

import com.github.mkmainali.filters.Filter;
import com.github.mkmainali.reader.Reader;
import com.github.mkmainali.tokenizer.Tokenizer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Set;

public class SpellCheck {

    private final Tokenizer tokenizer;
    private final List<Filter> filters;
    private final Reader reader;
    private final Map<String, Integer> model = new HashMap<String, Integer>();
    private final CandidateGenerator candidateGenerator;

    public SpellCheck(Reader reader, Tokenizer tokenizer, List<Filter> filters) throws SpellcheckException {
        this(reader, tokenizer, filters, new DefaultCandidateGenerator());
    }

    public SpellCheck(Reader reader, Tokenizer tokenizer, List<Filter> filters, CandidateGenerator candidateGenerator) throws SpellcheckException {
        this.reader = reader;
        this.tokenizer = tokenizer;
        this.filters = filters;
        this.candidateGenerator = candidateGenerator;
        train();
    }

    public void train() throws SpellcheckException {
        Iterator<String> it = reader.getTrainingData();

        int totalCount = 0;

        while (it.hasNext()) {
            String str = it.next();
            Iterator<String> tokens = tokenizer.tokenize(str);

            while (tokens.hasNext()) {
                String token = tokens.next();
                List<String> filteredToken = Collections.singletonList(token);
                for (Filter f : filters) {
                    filteredToken = f.apply(filteredToken);
                    if (filteredToken == null) break;
                }

                if (filteredToken != null) {
                    for (String finalToken : filteredToken) {
                        totalCount = totalCount + 1;
                        if (model.containsKey(finalToken)) {
                            model.put(finalToken, model.get(finalToken) + 1);
                        } else {
                            model.put(finalToken, 1);
                        }
                    }
                }
            }
        }
    }

    public String correct(String word) {
        if (model.containsKey(word)) return word;

        //get candidates
        Set<String> edit1Candidates = candidateGenerator.generateCandidates(word, 1);
        String result = bestMatch(edit1Candidates);
        if (result != null) {
            return result;
        } else {
            result = bestMatch(candidateGenerator.generateCandidates(word, 2));
            return result == null ? word : result;
        }
    }

    private String bestMatch(Set<String> candidates) {
        String bestMatch = null;
        for (String candidate : candidates) {
            if (model.containsKey(candidate)) {
                if (bestMatch == null) {
                    bestMatch = candidate;
                } else {
                    if (model.get(candidate) > model.get(bestMatch)) {
                        bestMatch = candidate;
                    }
                }
            }
        }
        return bestMatch;
    }
}

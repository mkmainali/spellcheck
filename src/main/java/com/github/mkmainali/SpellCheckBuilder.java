package com.github.mkmainali;

import com.github.mkmainali.filters.Filter;
import com.github.mkmainali.reader.Reader;
import com.github.mkmainali.tokenizer.Tokenizer;
import com.github.mkmainali.tokenizer.impl.WhitespaceTokenizer;

import java.util.Collections;
import java.util.List;

public final class SpellCheckBuilder {

    private Reader reader = null;

    private Tokenizer tokenizer = new WhitespaceTokenizer();

    private List<Filter> filters = Collections.EMPTY_LIST;

    private CandidateGenerator candidateGenerator = new DefaultCandidateGenerator();

    public SpellCheckBuilder withReader(Reader reader) {
        this.reader = reader;
        return this;
    }

    public SpellCheckBuilder withTokenizer(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        return this;
    }

    public SpellCheckBuilder addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public SpellCheckBuilder addFilter(List<Filter> filters) {
        filters.addAll(filters);
        return this;
    }

    public SpellCheckBuilder withCandidateGenerator(CandidateGenerator candidateGenerator) {
        this.candidateGenerator = candidateGenerator;
        return this;
    }

    public SpellCheck build() throws SpellcheckException {
        if (reader == null) {
            throw new SpellcheckException("Reader is required");
        }

        return new SpellCheck(reader, tokenizer, filters, candidateGenerator);
    }
}

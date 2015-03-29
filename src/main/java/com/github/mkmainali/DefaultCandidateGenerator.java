package com.github.mkmainali;

import java.util.HashSet;
import java.util.Set;

public class DefaultCandidateGenerator implements CandidateGenerator {

    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public Set<String> generateCandidates(String word, int edit) {
        if (edit == 1) {
            return oneEdit(word);
        } else if (edit == 2) {
            return twoEdit(word);
        } else {
            throw new IllegalArgumentException("More than 2 edits is not supported");
        }
    }

    private Set<String> oneEdit(String word) {
        Set<String> result = new HashSet<String>();

        result.addAll(candidatesByDeletion(word));
        result.addAll(candidatesByAlteration(word));
        result.addAll(candidatesByInsertion(word));
        result.addAll(candidatesByTransposition(word));
        return result;
    }

    private Set<String> twoEdit(String word) {
        Set<String> result = new HashSet<String>();

        Set<String> tmp = oneEdit(word);
        for (String str : tmp) {
            result.addAll(oneEdit(str));
        }

        return result;
    }

    private Set<String> candidatesByDeletion(String word) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < word.length(); i++) {
            result.add(new StringBuilder(word).deleteCharAt(i).toString());
        }
        return result;
    }

    private Set<String> candidatesByInsertion(String word) {
        Set<String> result = new HashSet<String>();
        for (char c : CHARACTERS) {
            for (int i = 0; i <= word.length(); i++) {
                result.add(new StringBuilder(word).insert(i, c).toString());
            }
        }
        return result;
    }

    private Set<String> candidatesByTransposition(String word) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < (word.length() - 1); i++) {
            result.add(new StringBuilder(word).insert(i, word.charAt(i + 1)).deleteCharAt(i + 1).toString());
        }
        return result;
    }

    private Set<String> candidatesByAlteration(String word) {
        Set<String> result = new HashSet<String>();
        for (char c : CHARACTERS) {
            for (int i = 0; i < word.length(); i++) {
                result.add(new StringBuilder(word).insert(i, c).deleteCharAt(i + 1).toString());
            }
        }
        return result;
    }
}

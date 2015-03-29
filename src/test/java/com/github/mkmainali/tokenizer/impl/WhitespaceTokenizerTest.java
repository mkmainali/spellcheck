package com.github.mkmainali.tokenizer.impl;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class WhitespaceTokenizerTest {

    private WhitespaceTokenizer tokenizer = new WhitespaceTokenizer();

    @Test
    public void testWhitespaceTokenizer() throws Exception {
        String str = "this is    a   test";
        Iterator<String> it = tokenizer.tokenize(str);
        Assert.assertNotNull(it);
        List<String> result = Lists.newArrayList(it);
        Assert.assertEquals(4, result.size());
    }
}

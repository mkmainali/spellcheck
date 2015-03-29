package com.github.mkmainali.filter.impl;

import com.github.mkmainali.filters.impl.NonAlphanumericFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class NonAlphabetFilterTest {

    private NonAlphanumericFilter filter = new NonAlphanumericFilter();

    @Test
    public void testNonAlphabetFilter() throws Exception {
        Assert.assertNull(filter.apply(null));

        List<String> tokens = Collections.singletonList("test");
        List<String> result = filter.apply(tokens);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("test", result.get(0));

        tokens = Collections.singletonList("test't");
        result = filter.apply(tokens);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("test", result.get(0));
        Assert.assertEquals("t", result.get(1));
    }
}

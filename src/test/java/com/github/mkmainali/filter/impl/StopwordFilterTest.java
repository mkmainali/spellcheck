package com.github.mkmainali.filter.impl;

import com.github.mkmainali.filters.impl.StopwordFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StopwordFilterTest {

    @Test
    public void testNoStopWords() throws Exception {
        StopwordFilter filter = new StopwordFilter();
        Assert.assertNull(filter.apply(null));

        List<String> input = Collections.singletonList("test");
        List<String> result = filter.apply(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("test", result.get(0));
    }

    @Test
    public void testWithStopWords() throws Exception {
        Set<String> stopWords = Collections.singleton("the");
        StopwordFilter filter = new StopwordFilter(stopWords);
        Assert.assertNull(filter.apply(null));

        List<String> input = Collections.singletonList("test");
        List<String> result = filter.apply(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("test", result.get(0));

        input = Arrays.asList("test", "the", "and");
        result = filter.apply(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("test", result.get(0));
        Assert.assertEquals("and", result.get(1));
    }
}

package com.rps;

import org.junit.Assert;
import org.junit.Test;

public class ItemsTestSuite {
    @Test
    public void shouldReturnListOfItems() {
        Items items = new Items();
        int size = items.listOfItems().size();

        Assert.assertEquals(3, size);
    }
}

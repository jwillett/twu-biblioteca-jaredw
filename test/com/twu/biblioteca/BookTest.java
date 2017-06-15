package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testGetBookTitle() {
        Book moby_dick = new Book("Moby Dick");
        assertEquals(moby_dick.getTitle(), "Moby Dick");
    }

}

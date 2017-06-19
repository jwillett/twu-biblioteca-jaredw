package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testCreateMovieAndGetMovieInfo() {
        Movie godfatherMovie = new Movie("The Godfather", 1972, "Francis Ford Coppola", 10);
        Movie jurassicMovie = new Movie("Jurassic Park", 1993, "Steven Spielberg");
        String expectedString = "The Godfather\t1972\tFrancis Ford Coppola\t10";
        assertEquals(expectedString, godfatherMovie.getMovieInfo());
        expectedString = "Jurassic Park\t1993\tSteven Spielberg\tUnrated";
        assertEquals(expectedString, jurassicMovie.getMovieInfo());
    }

    @Test
    public void testMovieCheckOut() {
        Movie jurassicMovie = new Movie("Jurassic Park", 1993, "Steven Spielberg");
        assertFalse(jurassicMovie.isCheckedOut());
        try {
            jurassicMovie.checkout();
        } catch (AlreadyCheckedOutException notExpected) {
            fail();
        }
        assertTrue(jurassicMovie.isCheckedOut());

    }
}

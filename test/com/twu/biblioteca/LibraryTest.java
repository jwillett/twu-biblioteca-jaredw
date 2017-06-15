package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LibraryTest {

    @Test
    public void testWelcomeMessage() {
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        BibliotecaApp testApp = new BibliotecaApp();
        testApp.printWelcomeMessage();
        assertEquals(outStream.toString(), "Welcome to Biblioteca!\n");
    }

    @Test
    public void testGetBookTitle() {
        Book moby_dick = new Book("Moby Dick");
        assertEquals(moby_dick.getTitle(), "Moby Dick");
    }

}
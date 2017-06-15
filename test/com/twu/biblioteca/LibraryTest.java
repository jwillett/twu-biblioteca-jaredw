package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class LibraryTest {

    final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    BibliotecaApp testApp = new BibliotecaApp();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testWelcomeMessage() {
        testApp.printWelcomeMessage();
        assertEquals(outStream.toString(), "Welcome to Biblioteca!\n");
    }

    @Test
    public void testListBooks() {
        testApp.listBooks();
        assertEquals(outStream.toString(), "Moby Dick\nHarry Potter\n");
    }

}
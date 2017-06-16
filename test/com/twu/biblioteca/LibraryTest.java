package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class LibraryTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private BibliotecaApp testApp = new BibliotecaApp();

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
        String expectedString1 = "Moby Dick\tHerman Melville\t1851\n";
        String expectedString2 = "Harry Potter\tJ.K. Rowling\t1997\n";
        assertEquals(outStream.toString(), expectedString1 + expectedString2);
    }

    @Test
    public void testRenewingOutputStream () {
        System.out.print("a string");
        assertEquals(outStream.toString(), "a string");
        outStream.reset();
        System.out.print("something else");
        assertEquals(outStream.toString(), "something else");
    }

}
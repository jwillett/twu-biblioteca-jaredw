package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuOptionTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testMenuOptionHasName() {
        MenuOption quit = new MenuOption("Quit");
        assertEquals(quit.getName(), "Quit");
    }

    @Test
    public void testMenuOptionForListBooksListsBooks() {
        BibliotecaApp testApp = new BibliotecaApp();
        MenuOption list_books = new MenuOption("List Books", testApp.getBooks());
        list_books.execute();
        String expectedString1 = "Moby Dick\tHerman Melville\t1851\n";
        String expectedString2 = "Harry Potter\tJ.K. Rowling\t1997\n";
        assertEquals(outStream.toString(), expectedString1 + expectedString2);
    }

}

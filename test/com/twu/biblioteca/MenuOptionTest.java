package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayInputStream;
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
        MenuOption quit = new MenuOptionQuit();
        assertEquals(quit.getName(), "Quit");
    }

    @Test
    public void testMenuOptionForListBooksListsBooks() {
        BibliotecaApp testApp = new BibliotecaApp();
        MenuOption list_books = new MenuOptionListBooks(testApp.getBooks());
        list_books.execute();
        String expectedString1 = "Moby Dick\tHerman Melville\t1851\n";
        String expectedString2 = "Harry Potter\tJ.K. Rowling\t1997\n";
        assertEquals(outStream.toString(), expectedString1 + expectedString2);
    }

    @Test
    public void testQuitMenuOptionPrintsNothing() {
        MenuOption quit = new MenuOptionQuit();
        quit.execute();
        assertEquals(outStream.toString(), "");
    }

    @Test
    public void testCheckoutBookOptionRemovesBookFromListing() {
        BibliotecaApp testApp = new BibliotecaApp();
        Book book_to_checkout = testApp.getBooks().get(0);
        String expectedString = "Harry Potter\tJ.K. Rowling\t1997\n";
        MenuOption checkout_book = new MenuOptionCheckoutBook(testApp.getBooks());
        MenuOption list_books = new MenuOptionListBooks(testApp.getBooks());
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        checkout_book.execute();
        outStream.reset();
        list_books.execute();
        assertEquals(outStream.toString(), expectedString);
    }

}

package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
        MenuOption list_books = new MenuOptionListItems(testApp.getBooks(), "List Books");
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
        String expectedString = "Harry Potter\tJ.K. Rowling\t1997\n";
        User testUser = new User("123-4567", "password123");
        MenuOption checkout_book = new MenuOptionCheckoutItem(testApp.getBooks(), "book", testUser);
        MenuOption list_books = new MenuOptionListItems(testApp.getBooks(), "List Books");
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        checkout_book.execute();
        outStream.reset();
        list_books.execute();
        assertEquals(outStream.toString(), expectedString);
    }

    @Test
    public void testReturnBookOptionReturnsBookToListing() {
        BibliotecaApp testApp = new BibliotecaApp();
        Book book_to_return = testApp.getBooks().get(0);
        User testUser = new User("123-4567", "password123");
        try {
            book_to_return.checkout(testUser);
        } catch (Exception shouldNotHappen) {
            fail();
        }
        String expectedString = "Moby Dick\tHerman Melville\t1851\n";
        expectedString += "Harry Potter\tJ.K. Rowling\t1997\n";
        MenuOption list_books = new MenuOptionListItems(testApp.getBooks(), "List Books");
        MenuOption return_book = new MenuOptionReturnItem(testApp.getBooks(), "book", testUser);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        return_book.execute();
        outStream.reset();
        list_books.execute();
        assertEquals(outStream.toString(), expectedString);
    }

    @Test
    public void testCanNotCheckOutAlreadyCheckedOutBook() {
        BibliotecaApp testApp = new BibliotecaApp();
        Book book = testApp.getBooks().get(0);
        User testUser = new User("123-4567", "password123");
        try {
            book.checkout(testUser);
        } catch (Exception shouldNotHappen) {
            fail();
        }
        try {
            book.checkout(testUser);
            fail();
        } catch (AlreadyCheckedOutException shouldHappen) {
        }
    }

    @Test
    public void testCanNotReturnBookWhichIsNotCheckedOut() {
        BibliotecaApp testApp = new BibliotecaApp();
        Book book = testApp.getBooks().get(0);
        try {
            book.returnItem();
            fail();
        } catch (NotCheckedOutException shouldHappen) {
        }
    }

    @Test
    public void testMenuOptionShowUserInfoRetrievesUserInfo() {
        User testUser = new User("123-4567", "password123");
        testUser.setName("James");
        testUser.setEmail("james@website.com");
        testUser.setPhone("0412341234");
        MenuOption showInfo = new MenuOptionShowUserInfo(testUser);
        showInfo.execute();
        assertEquals(testUser.getUserInfo() + '\n', outStream.toString());
    }
}

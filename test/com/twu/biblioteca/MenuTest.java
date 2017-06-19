package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private BibliotecaApp testApp = new BibliotecaApp();
    private Menu mainMenu = new Menu(testApp.getBooks(), testApp.getMovies());

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testSelectingInvalidMenuOption() {
        String expectedString = "Select a valid option!\n";
        String userInputSim = "xyz\n5\n";
        System.setIn(new ByteArrayInputStream(userInputSim.getBytes()));
        mainMenu.processUserInput();
        assertEquals(outStream.toString(), expectedString);
    }

    @Test
    public void testMainMenuChoosingListBooksOptionThenQuitting() {
        String expectedString1 = "Moby Dick\tHerman Melville\t1851\n";
        String expectedString2 = "Harry Potter\tJ.K. Rowling\t1997\n";
        System.setIn(new ByteArrayInputStream("1\n5\n".getBytes()));
        mainMenu.processUserInput();
        assertEquals(outStream.toString(), expectedString1 + expectedString2);
    }

    @Test
    public void testUserChoosingQuit() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        mainMenu.processUserInput();
        assertEquals(outStream.toString(), "");
    }
}

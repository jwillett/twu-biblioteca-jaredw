package com.twu.biblioteca;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private Menu mainMenu = new Menu();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testSelectingInvalidMenuOption() {
        BibliotecaApp testApp = new BibliotecaApp();
        String expectedString = "Select a valid option!\n";
        expectedString += "Moby Dick\tHerman Melville\t1851\n";
        expectedString += "Harry Potter\tJ.K. Rowling\t1997\n";
        String userInputSim = "xyz\n1";
        System.setIn(new ByteArrayInputStream(userInputSim.getBytes()));
        mainMenu.processUserInput(testApp);
        assertEquals(outStream.toString(), expectedString);
    }

    @Test
    public void testPrintMenuOptions() {
        String expectedString = "Select an option by entering the appropriate number:\nList Books - 1\n";
        mainMenu.printMenuOptions();
        assertEquals(outStream.toString(), expectedString);
    }

    @Test
    public void testMainMenuChoosingOnlyOption() {
        BibliotecaApp testApp = new BibliotecaApp();
        String expectedString1 = "Moby Dick\tHerman Melville\t1851\n";
        String expectedString2 = "Harry Potter\tJ.K. Rowling\t1997\n";
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        mainMenu.processUserInput(testApp);
        assertEquals(outStream.toString(), expectedString1 + expectedString2);
    }
}

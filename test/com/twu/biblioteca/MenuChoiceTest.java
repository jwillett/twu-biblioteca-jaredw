package com.twu.biblioteca;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MenuChoiceTest {

    @Test
    public void testMenuOptionHasName() {
        MenuChoice quit = new MenuChoice("Quit");
        assertEquals(quit.getName(), "Quit");
    }

}

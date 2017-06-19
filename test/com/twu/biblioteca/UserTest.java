package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class UserTest {

    @Test
    public void testUserCredentials() {
        User testUser = new User("123-4567", "password123");
        assert(testUser.testCredentials("123-4567", "password123"));
        assertFalse(testUser.testCredentials("000-1020", "whatever"));
    }

    @Test
    public void testCheckedOutItemsHaveAttachedUser() {
        Book testBook = new Book("Cool Book", "Cool Author", 1992);
        User testUser = new User("123-4567", "password123");
        try{
            testBook.checkout(testUser);
        } catch (AlreadyCheckedOutException shouldNotHappen) {
            fail();
        }
        assertEquals(testBook.getHoldingCustomer(), testUser);
    }

    @Test
    public void testReturnedItemsHaveNoAttachedUser() {
        Book testBook = new Book("Cool Book", "Cool Author", 1992);
        User testUser = new User("123-4567", "password123");
        try{
            testBook.checkout(testUser);
            testBook.returnItem();
        } catch (Exception shouldNotHappen) {
            fail();
        }
        assertEquals(testBook.getHoldingCustomer(), null);
    }

    @Test
    public void testGetUserInformation() {
        User testUser = new User("123-4567", "password123");
        testUser.setName("James");
        testUser.setEmail("james@website.com");
        testUser.setPhone("0412341234");
        assertEquals(testUser.getUserInfo(), "James\tjames@website.com\t0412341234");
    }



}

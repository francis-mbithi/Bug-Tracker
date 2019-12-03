package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;

public class UserTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
    public User setupUser(){
        return new User("Mike", "mike@mike.com" );
    }
    @Test
    public void getUsernameReturnsCorrectly(){
        User user = setupUser();
        assertEquals("Mike", user.getUsername());
    }
    @Test
    public void setUsernameReturnsCorrectly(){
        User user = setupUser();
        user.setUsername("Mike");
        assertEquals("Mike", user.getUsername());
    }
    @Test
    public void getEmailReturnsCorrectly(){
        User user = setupUser();
        assertEquals("mike@mike.com", user.getEmail());
    }
    @Test
    public void setEmailReturnsCorrectly(){
        User user =setupUser();
        user.setEmail("mike@mike.com");
        assertEquals("mike@mike.com", user.getEmail());
    }
}
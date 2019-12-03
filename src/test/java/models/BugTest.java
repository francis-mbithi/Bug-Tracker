package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BugTest {

    //Helper Method
    public Bug setupBug(){
        return new Bug("content","True","category",1);
    }
    @Test
    public void BugInstantiatesCorrectly(){
        Bug bug = setupBug();
        assertTrue(bug instanceof Bug);
    }
    @Test
    public void getId(){
        Bug bug = setupBug();
        assertEquals(1,bug.getId());
    }
    @Test
    public void getContent(){
        Bug bug = setupBug();
        assertEquals("Deploying",bug.getContent());
    }
    @Test
    public void getCategory(){
        Bug bug = setupBug();
        assertEquals("Java",bug.getCategory());
    }
}

package iviewj.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestVerifier;
import iviewj.basic.LinkListRemoveDup3;

import static org.junit.Assert.*;

public class LinkListRemoveDupTest {
  LinkListRemoveDup3 removeDup;
  
  public LinkListRemoveDupTest() {
  }
  
  @Before
  public void setUp() {
    removeDup = new LinkListRemoveDup3(new TestVerifier());
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void consecutiveDup() {
    System.out.println(getMethodName(2));
    removeDup.TestInput(new Integer[]{2, 3, 2, 2, 4, 4},
            new Integer[]{2, 3, 4});
  }

  @Test
  public void splittedDups() {
    System.out.println(getMethodName(2));
    removeDup.TestInput(new Integer[]{1, 2, 3, 1, 2, 3},
            new Integer[]{1, 2, 3});
  }
  
  @Test
  public void twoELement() {
    System.out.println(getMethodName(2));
    removeDup.TestInput(new Integer[]{1,2},
            new Integer[]{1, 2});
  }
  
  @Test
  public void threeELement() {
    System.out.println(getMethodName(2));
    removeDup.TestInput(new Integer[]{1,2,1},
            new Integer[]{1, 2});
  }  
  
  @Test
  public void threeELement2() {
    System.out.println(getMethodName(2));
    removeDup.TestInput(new Integer[]{1,2,2},
            new Integer[]{1, 2});
  }   
  
  public static String getMethodName(final int depth)
  {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
   return ste[depth].getMethodName(); //Thank you Tom Tresansky
  }    
  
}

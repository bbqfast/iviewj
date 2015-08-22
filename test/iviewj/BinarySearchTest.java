package iviewj;

import static iviewj.PermutationTest.getMethodName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {
  BinarySearch3 search;
  
  public BinarySearchTest() {
  }
  
  @Before
  public void setUp() {
    search = new BinarySearch3(new TestVerifier());
  }

  @Test
  public void onRight() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 8, 7);
  }
  
  @Test
  public void leftMost() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 1, 0);
  }
  
  @Test
  public void rightMost() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 10, 9);
  }
  
  @Test
  public void onLeft() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 3, 2);
  }   
  
  @Test
  public void oneToLeft() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 2, 1);
  }
  
  @Test
  public void leftOneToMid() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 4, 3);
  }
  
  @Test
  public void fourElement() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    search.TestInput(a, 4, 3);
  }    
  
  public static String getMethodName(final int depth)
  {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
   return ste[depth].getMethodName(); //Thank you Tom Tresansky
  }    
}

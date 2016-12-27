package iviewj.others;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestVerifier;
import iviewj.others.FindShiftedArray2;

import static org.junit.Assert.*;

public class FindShiftedArrayTest {
   FindShiftedArray2 findShifted;
  
  public FindShiftedArrayTest() {
  }
  
  @Before
  public void setUp() {
    findShifted = new FindShiftedArray2(new TestVerifier());
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void onLeft() {
    System.out.println(getMethodName(2));
    findShifted.TestInput(new Integer[] { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 }, 2);
  }

  @Test
  public void onRIght() {
    System.out.println(getMethodName(2));
    findShifted.TestInput(new Integer[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 6);
  }
  
  @Test
  public void noShift() {
    System.out.println(getMethodName(2));
    findShifted.TestInput(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, -1);
  }  
  
  @Test
  public void twoElement() {
    System.out.println(getMethodName(2));
    findShifted.TestInput(new Integer[] { 2, 1 }, 0);
  }    

  @Test
  public void twoElementNoShift() {
    System.out.println(getMethodName(2));
    findShifted.TestInput(new Integer[] { 1, 2 }, -1);
  }  
  
  public static String getMethodName(final int depth)
  {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
   return ste[depth].getMethodName(); //Thank you Tom Tresansky
  }    
  
}

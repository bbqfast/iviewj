package iviewj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxSumTest {
  MaxSum maxsum;
  
  public MaxSumTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    maxsum = new MaxSum(new TestVerifier());
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void neg_in_btw() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[] { 1,2,3,-10,4,1};
    int expResult = 6;
    int result = maxsum.FindMaxSum(a);
    assertEquals(expResult, result);
  }

  @Test
  public void all_neg() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[] { -1, -2, -3, -10, -4, -9 };
    int expResult = 0;
    int result = maxsum.FindMaxSum(a);
    assertEquals(expResult, result);
  }  
  
  @Test
  public void neg_at_beg() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[] { -999, 1,2,3,-10,4,1};
    int expResult = 6;
    int result = maxsum.FindMaxSum(a);
    assertEquals(expResult, result);
  }    
  
  @Test
  public void neg_at_end() {
    System.out.println(getMethodName(2));
    Integer[] a = new Integer[] { 1,2,3,-10,4,1, -999};
    int expResult = 6;
    int result = maxsum.FindMaxSum(a);
    assertEquals(expResult, result);
  }      
  
  public static String getMethodName(final int depth)
  {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
   return ste[depth].getMethodName(); //Thank you Tom Tresansky
  }  
}

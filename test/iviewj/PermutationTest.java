/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iviewj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dev
 */
public class PermutationTest {
  Permutation permute;
          
  public PermutationTest() {
  }
  
  @Before
  public void setUp() {
    permute = new Permutation(new TestVerifier());
  }
  
  @After
  public void tearDown() {
  }

   /**
   * Test of Permute method, of class Permutation.
   */
  @Test
  public void testPermute() {
    System.out.println(getMethodName(2));
    String _str = "abc";
    permute.TestInput(_str, Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"));
  }

  private void Verify(List<String> expected, List<String> actual)
  {
    HashSet<String> actualSet = new HashSet<String>(actual);
    for (String x : expected)
    {
      if (! actualSet.contains(x))
      {
        System.out.println("failed");
      }
    }
  }
  
  /**
   * Test of Test1 method, of class Permutation.
   */
  @Test
  public void testTest1() {
    System.out.println("Test1");
    Permutation instance = null;
    instance.Test1();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
 
  public static String getMethodName(final int depth)
  {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
   return ste[depth].getMethodName(); //Thank you Tom Tresansky
  }   
}

package iviewj.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestVerifier;
import iviewj.basic.Permutation2;

import static org.junit.Assert.*;

public class PermutationTest {
  Permutation2 permute;
          
  public PermutationTest() {
  }
  
  @Before
  public void setUp() {
    permute = new Permutation2(new TestVerifier());
  }
  
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
 
  public static String getMethodName(final int depth)
  {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
   return ste[depth].getMethodName(); //Thank you Tom Tresansky
  }   
}

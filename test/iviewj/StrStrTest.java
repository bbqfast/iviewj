package iviewj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StrStrTest {
  StrStr strstr;
  
  public StrStrTest() {
  }
 
  @Before
  public void setUp() {
    strstr = new StrStr(new TestVerifier());
  }

  @Test
  public void nextToLast() {
    System.out.println(TestHelper.getMethodName(2));
    strstr.TestInput("abcdefg", "def", 3);
  }
  
  @Test
  public void lastLetter() {
    System.out.println(TestHelper.getMethodName(2));
    strstr.TestInput("abcdefg", "g", 6);
  }  

  @Test
  public void exactMatch() {
    System.out.println(TestHelper.getMethodName(2));
    strstr.TestInput("abc", "abc", 0);
  }  

  @Test
  public void noMatch() {
    System.out.println(TestHelper.getMethodName(2));
    strstr.TestInput("abc", "zz", -1);
  }  

  @Test
  public void patternIsLonger() {
    System.out.println(TestHelper.getMethodName(2));
    strstr.TestInput("abc", "zzzzzzz", -1);
  }  
}

package iviewj;

import javax.print.DocFlavor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompressStrTest {
  CompressStr2 instance;
  
  public CompressStrTest() {
  }
  
  @Before
  public void setUp() {
    instance = new CompressStr2(new TestVerifier());
  }

  @Test
  public void testWriteInt() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestWriteInt("happ   ", 4, 15, "happ15 ", 6);
  }

  @Test
  public void testWriteIntBigNum() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestWriteInt("happ       ", 4, 150000, "happ150000 ", 10);
  }
  
  @Test
  public void testWriteExactRoom() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestWriteInt("happ  ", 4, 15, "happ15", 6);
  }   
  
  @Test
  public void testWriteIntOverflow() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestWriteInt("happ ", 4, 15, "happ1", 999999);
  }  
  
  @Test
  public void basic() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("aaabbbccc", "a3b3c3");
  }  

  @Test
  public void oneAndMany() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("abbbbbc", "a1b5c1");
  }    
  
  @Test
  public void noDup() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("abc", "abc");
  }  
  
  @Test
  public void oneAtTheEnd() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("abccccccccccccc", "a1b1c13");
  }
  
  @Test
  public void oneLetter() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("a", "a");
  }

  @Test
  public void twoLetter() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("aa", "a2");
  }  
  
  @Test
  public void emptyStr() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("", "");
  }    
  
  
}

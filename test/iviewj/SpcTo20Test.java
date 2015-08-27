package iviewj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpcTo20Test {

  SpcTo20_2 instance;

  public SpcTo20Test() {
  }

  @Before
  public void setUp() {
    instance = new SpcTo20_2(new TestVerifier());
  }

  @Test
  public void oneSpace() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("this apple", "this%20apple\0");
  }

  @Test
  public void twoSpace() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("I eat apple", "I%20eat%20apple\0");
  }
  
  @Test
  public void noSpace() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("apple", "apple\0");
  }  

  @Test
  public void space_at_end() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("apple ", "apple%20\0");
  }
  
  @Test
  public void all_space() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("   ", "%20%20%20\0");
  }
  
  @Test
  public void space_at_beg() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(" apple", "%20apple\0");
  }    
  
  @Test
  public void syntax_plus() {
    System.out.println(TestHelper.getMethodName(2));
    int a=5, b=5;
    System.out.println("a=" + a++);
    System.out.println("b=" + ++b);
  }     
}

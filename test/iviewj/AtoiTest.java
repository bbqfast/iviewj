package iviewj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtoiTest {
  Atoi2 atoi; 
  
  public AtoiTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    atoi = new Atoi2(new TestVerifier());
  }
  
  @After
  public void tearDown() {
  }
  
  public void test_testInput() {
    System.out.println("test_testInput");
    atoi.Test1();
  }
  
  @Test
  public void test_1531() {
    System.out.println("1531");
    int out = atoi.atoi("1531");
    assertEquals(1531, out);
  }

  @Test
  public void test_neg_15() {
    System.out.println("-15");
    int out = atoi.atoi("-15");
    assertEquals(-15, out);
  }
  
  @Test
  public void test_abcd() {
    System.out.println("abcd");
    int out = atoi.atoi("abcd");
    assertEquals(0, out);
  }
  
  @Test
  public void test_space() {
    System.out.println("    -150  ");
    int out = atoi.atoi("    -150  ");
    assertEquals(-150, out);
  }
  
  @Test
  public void zero() {
    System.out.println("0");
    int out = atoi.atoi("0");
    assertEquals(0, out);
  }  
  
  @Test
  public void positive_sign() {
    System.out.println("   +1990");
    int out = atoi.atoi("   +1990");
    assertEquals(1990, out);
  }    
  
  @Test
  public void space_at_end() {
    System.out.println("23 ");
    int out = atoi.atoi("23 ");
    assertEquals(23, out);
  }    
  
}

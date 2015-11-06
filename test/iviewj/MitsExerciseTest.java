package iviewj;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MitsExerciseTest {
  MitsExercise instance; 
  
  public MitsExerciseTest() {
  }
  
  @Before
  public void setUp() {
    instance = new MitsExercise();
  }

  @Test
  public void testHash() {
    System.out.println("testHash");
    String str = "reports";
    
    long r = instance.hash(str);
    System.out.println("" + r);
    assertEquals(690336378753L, r);
  }
  
  @Test
  public void reverseHash_solution() {
    System.out.println("reverseHash_solution");
    String result = instance.unHash(932246728227799L, ""); // from exerice question
    System.out.println("result=" + result);
    assertEquals("mymitsapp", result);
  }    
  
  @Test
  public void reverseHash_reports() {
    System.out.println("reverseHash_reports");
    String result = instance.unHash(690336378753L, ""); // from exerice question
    System.out.println("result=" + result);
    assertEquals("reports", result);
  }    
}

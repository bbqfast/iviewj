package iviewj.exericse;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import iviewj.exercise.Football;

import static org.junit.Assert.*;

public class footballTest {
  
  public footballTest() {
  }
  
  @Before
  public void setUp() {
  }

  @Test
  public void testFsi() {
    System.out.println("fsi");
    Football instance = new Football();
    String expResult = "";
    ArrayList<String> results = instance.fsia(7, "");
    for (String s : results)
    {
      System.out.println(s);
    }
  }
}

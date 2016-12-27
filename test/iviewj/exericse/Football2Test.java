package iviewj.exericse;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import iviewj.exercise.Football2;

import static org.junit.Assert.*;

public class Football2Test {

  public Football2Test() {
  }

  @Before
  public void setUp() {
  }

  @Test
  public void testFsi() {
    System.out.println("fsi");
    Football2 instance = new Football2();
    String expResult = "";
    ShowScore(instance.possibleScore(7));
    ShowScore(instance.possibleScore(3));
  }

  public void ShowScore(ArrayList<String> results) {
    for (String s : results) {
      System.out.println(s);
    }
    System.out.println();
  }
}

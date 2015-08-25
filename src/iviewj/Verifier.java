package iviewj;

import GDC.TNode;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;

public class Verifier implements IVerifier {

  public void Verify(String desc, String expect, String actual) {
    w(desc + "\nExpected=" + expect + "\nActual  =" + actual);
    if (expect.equals(actual)) {
      Pass();
    } else {
      Fail();
    }
  }

  public void Verify(String desc, Integer[] expect, Integer[] actual) {
    //w(desc + "Expected=" + expect + " Actual=" + actual);
    if (Utils.MatchArray(expect, actual)) {
      Pass();
    } else {
      Fail();
    }
  }

  public void Verify(String desc, int expect, int actual) {
    w(desc + "Expected=" + expect + " Actual=" + actual);
    if (expect == actual) {
      Pass();
    } else {
      Fail();
    }
  }

  public void Verify(String desc, List<String> expected, List<String> actual) {
    w(desc);

    HashSet<String> actualSet = new HashSet<String>(actual);
    for (String x : expected) {
      if (!actualSet.contains(x)) {
        Fail();
      }
    }
    Pass();
  }

  public void Verify(String desc, Point[] expected, List<Point> actual)
  {
    w(desc);
    boolean isFail = false;

    HashSet<Point> actualSet = new HashSet<Point>(actual);
    for (Point p : expected) {
      if (!actualSet.contains(p)) 
        isFail = true;
    }         

    if (isFail)
    {
        w(Utils.PrintArray("actual", actualSet.toArray(new Point[actualSet.size()])));
        w(Utils.PrintArray("expected", expected));
        Fail();
    }
    else
      Pass();
  }  
    
  public void Verify(String desc, TNode expected, TNode actual) {
    w(desc);
    if (expected.compare(expected, actual)) {
      Pass();
    } else {
      Fail();
    }
  }

  public void Pass() {
    w("----------------- PASS ------------------------");
  }

  public void Fail() {
    w("***************** FAIL *****************");
  }

  public void w(String s) {
    System.out.println(s);
  }

}

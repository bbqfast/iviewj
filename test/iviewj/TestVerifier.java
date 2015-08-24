package iviewj;

import java.util.HashSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import GDC.*;
import GDC.TNode;
import static org.junit.Assert.*;

public class TestVerifier implements IVerifier {
    public void Verify(String desc, String  expect, String actual)
    {
        w(desc + "\nExpected=" + expect + "\nActual  =" + actual);
        if (expect.equals(actual))
        {
                Pass();
        }
        else
        {
                Fail();
        }
    }

  public void Verify(String desc, Integer[] expect, Integer[] actual)
    {
        //w(desc + "Expected=" + expect + " Actual=" + actual);
        if (Utils.MatchArray(expect, actual))
        {
            Pass();
        }
        else
        {
            Fail();
        }
    }
    
    public void Verify(String desc, int expect, int actual)
    {
        w(desc + "Expected=" + expect + " Actual=" + actual);
        if (expect == actual)
        {
            Pass();
        }
        else
        {
            Fail();
        }
    }

    public void Verify(String desc, List<String> expected, List<String> actual)
    {
      w(desc);
      
      HashSet<String> actualSet = new HashSet<String>(actual);
      for (String x : expected)
      {
        if (! actualSet.contains(x))
        {
          Fail();
        }
      }
      Pass();
    }
    
    public void Verify(String desc, TNode expected, TNode actual)
    {
      w(desc);
      if (expected.compare(expected, actual))
        Pass();
      else
        Fail();
    }      

    public void Pass()
    {
        w("----------------- PASS ------------------------");
        assertTrue(true);
    } 

    public void Fail()
    {
        w("***************** FAIL *****************");
        assertTrue(false);
    }

    public void w(String s)
    {
        System.out.println(s);
    }
  
  
}

package iviewj;

public class Verifier implements IVerifier {
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


    public void Pass()
    {
        w("----------------- PASS ------------------------");
    }

    public void Fail()
    {
        w("***************** FAIL *****************");
    }

    public void w(String s)
    {
        System.out.println(s);
    }
    
}

package iviewj;

import javax.management.OperationsException;

/**
 *
 * @author alan.chung
 */
public class TestBase {
    protected boolean debug = false;
    public void w(String s)
    {
        System.out.println(s);
    }

    public void d(String s)
    {
        if (debug)
            System.out.println(s);
    }

    public boolean RunTest() throws OperationsException
    {
        throw new OperationsException("No implementation");
    }

    public void Test1(){

    }

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



}

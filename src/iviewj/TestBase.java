package iviewj;

import javax.management.OperationsException;

public class TestBase {
    protected boolean debug = false;
    protected IVerifier verifier;

    public TestBase(IVerifier verify)
    {
      this.verifier = verify;
    }

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
}

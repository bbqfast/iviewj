package iviewj;
import GDC.*;

public class StrStr extends TestBase
{
    public int strstr(char[] a, char[] b)
    {
        for (int j=0;j < a.length; j++)
        {
            // mistake
            // i + j + b.lenght is wrong
            for (int i=0; i < b.length && i + j < a.length && a[j+i] == b[i]; i ++)
            {
                if ( i == b.length - 1)
                    return j;
            }
        }
        return -1;
    }

    protected void TestInput(String a, String b, int expectedPos)
    {
        int pos = strstr(a.toCharArray(), b.toCharArray());
        Verify("position found", expectedPos, pos);
    }

    @Override
    public void Test1()
    {
        TestInput("abcdefg", "def", 3);
        TestInput("abcdefg", "g", 6);
        TestInput("abc", "abc", 0);
        TestInput("abc", "zz", -1);
        TestInput("abc", "zzzzzzz", -1);
    }

}

package iviewj;
import java.util.Arrays;

import javax.management.OperationsException;
import GDC.*;

class StrRemoveDups extends TestBase
{
    public void TestInput(String a, String expected)
    {
            w("Input: a=" + a);
            char[] abuff = a.toCharArray();
            removeDups(abuff);
            Verify("removeDups: ", expected, new String(abuff));
    }

    public void removeDups(char[] str)
    {
        int c=0;
        int n=0;
        char p='\0';

        Arrays.sort(str);
        for (c=0;c < str.length; c++)
        {
            if (str[c] != p)
            {
                    str[n] = str[c];
                    n++;
            }
            p = str[c];
        }
        for (int i=n; i < str.length ; i++)
            str[i]=' ';
    }

    @Override
    public void Test1()
    {
            TestInput("","");
            TestInput("a","a");
            TestInput("ab","ab");
            TestInput("aaabb","ab   ");
            TestInput("abcabc","abc   ");
    }
}
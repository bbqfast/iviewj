package iviewj;
public class StrReplaceInPlace extends TestBase
{
    public StrReplaceInPlace(IVerifier v)
    {
      super(v);
    }
    
    public void RevStr(char[] a, int s, int e)
    {
        while (s < e)
        {
            char t = a[s];
            a[s] = a[e];
            a[e] = t;
            s ++;
            e --;
        }
    }

    protected int Strstr(char[] a, char[] pat, int i)
    {
        for (int j=0; j < pat.length && a[i+j] == pat[j]; j++)
        {
            if (j == pat.length - 1)
                return i;
        }
        return -1;
    }

    protected int Occur(char[] a, char[] find, int len)
    {
        int c = 0;
        for (int i=0; i <= len - find.length; i++)
        {
            if  ( Strstr(a, find, i) != -1)
                c++;
        }
        return c;
    }

    protected void Replace2(char[] input, char[] find, char[] repl, int start, int end)
    {
        int n=0;
        int i=start;

        while (i <= end)
        {
            int pos = Strstr(input, find, i);
            if (pos == -1)
            {
                input[n] = input[i];
                n++;
                i++;
                continue;
            }
            for (int k=0; k < repl.length; k++)
            {
                input[n + k] = repl[k];
            }
            n = n + repl.length;
            i = i + find.length;
        }

        for (int j=n; j < input.length;j++)
            input[j] = ' ';
    }

    protected void Replace(char[] input, char[] find, char[] repl, int len)
    {
        int needspc = repl.length - find.length;
        int occur = Occur(input, find, len);
        int newEnd = len - 1 + needspc * occur;
        int n=0;
        int i=needspc * occur;

        RevStr(input, 0, newEnd);
        RevStr(find, 0, find.length - 1);
        RevStr(repl, 0, repl.length - 1);
        w(new String(input));

        while (i <= newEnd)
        {
            int pos = Strstr(input, find, i);
            if (pos == -1)
            {
                input[n] = input[i];
                n++;
                i++;
                continue;
            }
            for (int k=0; k < repl.length; k++)
            {
                input[n + k] = repl[k];
            }
            n = n + repl.length;
            i = i + find.length;
        }

        RevStr(input, 0, newEnd);
    }

    protected void TestInput(String inputStr, String find, String repl, int len, String expected)
    {
        char []input = inputStr.toCharArray();
        // Replace(input, find.toCharArray(), repl.toCharArray(), len);
        w("input=   " + inputStr);
        Replace2(input, find.toCharArray(), repl.toCharArray(), 0, inputStr.length() - 1 );
        verifier.Verify("position found", expected, new String(input) );
    }

    public void Test1()
    {
        // TestInput("12ab12ab12  ", "ab", "abc", 10, "12abc12abc12");
        TestInput("12abc12abc12", "abc", "ab", 10, "12ab12ab12  ");
    }
}

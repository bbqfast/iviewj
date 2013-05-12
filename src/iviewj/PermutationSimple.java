package iviewj;


public class PermutationSimple extends TestBase
{
    protected void swap(char []a, char []b)
    {
            char t = a[0];
            a[0] = b[0];
            b[0] = t;
    }

    protected void swap(char []a, int i, int j)
    {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public void print(int level, char[] v)
    {
            w(makeSpace(level) + new String(v));
    }

    // debug use:  make space indentation for easier visualization
    public String makeSpace (int len)
    {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++)
            {
                    sb.append(" ");
            }
            return sb.toString();
    }

    // ------------------------------------------------------------------
    // This permutation is the simplest one to understand
    // bca cab bac
    // cba acb abc
    //
    // The idea is isolate one letter by swapping it to last position
    // the do the same recursively to the rest of the string to permute it
    // the most base case is swapping 2 create a proper permutation

    // entry point
    public void Permute(String _str)  // best
    {
            char[] str = _str.toCharArray();
            doPermute(str, _str.length(), 0); // depth starts with 0
    }

    public void doPermute(char[] str, int n, int depth)  // best
    {
        // when n = 1, loop skips which is base case
        for (int i = 0; i <= n - 1; i++) // <= n - 1 is last idx (aka. < n or < len)
        {
            // Notice that i is from 0 -> n-1, when i reach n - 1, the swap actually is an no op,
            // however we still need to be in the loop because we don't print at this level, thus we still need to hit the print statement

            swap(str, i, n - 1); // swap first last
            print(depth, str);
            doPermute(str, n - 1, depth + 1); // recursively, shorten input str by 1
            swap(str, i, n - 1);
        }

        // invoked when base case is reached.
        if (1 == n)
        {
                String x = new String(str);
                w("[" + x + "]");
        }
    }

    public void Test1()
    {
            this.Permute("abc");
    }
}


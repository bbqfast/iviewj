package iviewj;

public class MaxSum extends TestBase
{
    public void TestInput(Integer []a, int expected)
    {
        w("FindMaxSum:" + Utils.PrintArray("", a));
        int max = FindMaxSum(a);
        Verify("FindMaxSum: ", expected, max);
    }

    public int FindMaxSum(Integer[] a)
    {
        int ms = -999;
        int s = 0;

        for (int i = 0; i < a.length; i++)
        {
            s = s + a[i];
            if (s < 0)
                s = 0;
            if (s > ms)
                ms = s;
        }
        return ms;
    }

    @Override
    public void Test1()
    {
        int[] a1 = { 1,2,3,-10,4,1};
                    TestInput(new Integer[] { 1,2,3,-10,4,1}, 6);
                    TestInput(new Integer[] { 1, 2, 3, -10, 4, 9 }, 13 );
                    TestInput(new Integer[] { -1, -2, -3, -10, -4, -9 }, 13 );
    }
}


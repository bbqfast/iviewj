package iviewj;

public class BinarySearch extends TestBase
{
    protected void TestInput(Integer[] input, int find, int expected)
    {
        w(Utils.PrintArray("Input:",input));
        w(" Search for " + find);
        BinarySearch search = new BinarySearch();
        int pos;
        pos = search.Search(input, find);

        Verify("Found position", expected, pos);
    }

    public void Test1()
    {
        Integer[]a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        TestInput(a, 8, 7);
        TestInput(a, 1, 0);
        TestInput(a, 10, 9);
        TestInput(a, 3, 2);
    }

    public int Search(Integer[] a, Integer p)
    {
        Integer s = 0;
        Integer e = a[a.length - 1];
        Integer m = s;
        while (s <= e)
        {
            m = s + ((e - s) / 2);
            if (a[m] == p)
                return m;
            if (p < a[m])
                e = m;
            else
                s = m;
        }
        return -1;
    }
}

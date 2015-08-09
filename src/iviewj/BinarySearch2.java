package iviewj;

public class BinarySearch2 extends BinarySearch
{
    public BinarySearch2(IVerifier v)
    {
      super(v);
    }  
  
    protected void TestInput2222(Integer[] input, int find, int expected)
    {
        w(Utils.PrintArray("Input:",input));
        w(" Search for " + find);
        // BinarySearch search = new BinarySearch();
        int pos;
        pos = Search(input, find);

        Verify("Found position", expected, pos);
    }

    public void Test1111()
    {
        Integer[]a = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        TestInput(a, 8, 7);
        TestInput(a, 1, 0);
        TestInput(a, 10, 9);
        TestInput(a, 3, 2);
        TestInput(a, 2, 1);
        TestInput(a, 4, 3);

        Integer[]b = new Integer[] { 1, 2, 3, 4 };
        TestInput(b, 4, 3);
    }

    public int Search(Integer[] a, Integer d)
    {
        Integer s=0, e = a.length -1 , m = 0;
        // make sure test with edge cases such as element found at the edge, borders
        // should be s <= e because it failed at looking for 4 in 4 array
        while (s < e)
        {
            m = (s + e ) / 2;
            if (a[m] == d)
                return m;
            if ( d < a[m])
                e = m - 1;
            else if (d > a[m])
                s = m + 1;
        }
        return -1;
    }
}

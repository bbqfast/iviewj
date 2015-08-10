package iviewj;

import javax.management.OperationsException;
import GDC.*;
// tvining@gmail.com

    public class Sorting extends TestBase
    {
    public Sorting(IVerifier v)
    {
      super(v);
    }
    
        public void Sort(Integer []a)
        {
            int min;
            int minidx = 0;
            int tmp;
            for (int i = 0; i < a.length; i++)
            {
                min = a[i];
                minidx = i;
                for (int j = i; j < a.length; j++)
                {
                    if (a[j] < min)
                    {
                        min = a[j];
                        minidx = j;
                    }
                }
                // swap
                tmp = a[i];
                d("midx = " + min);
                a[i] = a[minidx];
                a[minidx] = tmp;
            }
        }

        protected void TestInput(Integer[] input, Integer[] expected)
        {
            w(Utils.PrintArray("Input", input));
            // Sorting sorter = new Sorting();
            Sort(input);

            verifier.Verify("Match", input, expected);
        }

        @Override
        public void Test1()
        {
            TestInput(new Integer[] { 101, 1, 17, 14, 10, 99, 8, 6, 9, 2, 21 },
                new Integer[] { 1, 2, 6, 8, 9, 10, 14, 17, 21, 99, 101 });

            TestInput(new Integer[] { 9, 8, 7, 6, 4, 3 },
                new Integer[] { 3, 4, 6, 7, 8, 9 });
        }
    }

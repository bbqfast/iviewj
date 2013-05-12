package iviewj;

import javax.management.OperationsException;
import GDC.*;
// tvining@gmail.com

    public class Sorting2 extends Sorting
    {
        public void Sort(Integer []a)
        {
            for (Integer i=0; i < a.length; i++)
            {
                for (Integer j = i + 1; j < a.length; j++)
                {
                    if (a[j] < a[i])
                        Utils.Swap(a, i, j);
                }
            }

        }
    }

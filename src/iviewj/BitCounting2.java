package iviewj;

import javax.management.OperationsException;
import GDC.*;

class BitCounting2 extends BitCounting
{
    public int countBits(int v)
    {
        int c=0;
        int b=0;
        while (v > 0)
        {
            b = v & 1;
            v = v >> 1;
            c = c + b;
        }
        return c;
    }
}

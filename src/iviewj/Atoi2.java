package iviewj;

public class Atoi2 extends Atoi
{
    public Atoi2(IVerifier v)
    {
      super(v);
    }
    
    public int atoi(String ar)
    {
        int i=0;
        int sign = 1;
        int t = 0;
        char []s = ar.toCharArray();
        // w( new Integer(s.length).toString());
        while ( i < s.length)
        {
            if (s[i] == '-')
            {
                i++;
                sign = -1;
                break;
            }
            if (s[i] >= '0' && s[i] <= '9')
            {
                break;
            }
            i++;
        }

        if (i > s.length)
            return 0;

        // mistake:  ascii code should have quotation
        while (i < s.length && s[i] >= '0' && s[i] <= '9')
        {
            t = t * 10;
            t = t + s[i] - '0';
            i ++;
        }
        t = t * sign;
        return t;
    }
}
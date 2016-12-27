package iviewj.others;

import iviewj.IVerifier;
import iviewj.TestBase;

public class CompressStr extends TestBase {
  public CompressStr(IVerifier v)
  {
    super(v);
  }
  
  public char[] Compress(char a[])
  {
    char b[] = new char[a.length];
    char cc = '\0';
    int cn = 0, i=0, j=0;

    while ( i < a.length)
    {
      if (a[i] != cc)
      {
        if (cc != '\0')
        {
          j = WriteInt(b, j, cn);
          cn = 0;
        }
        
        if (j > a.length)
          return a;

        b[j] = a[i];
        j++; 

        cc = a[i];
        cn ++;
      } else
      {
        cn ++;
      }
      i++;
    }
    
    if (cn != 0)
      WriteInt(b, j, cn);
    
    return b;
  }
  
  public int WriteInt(char[] b, int j, int cn)
  {
    char[] scn = Integer.toString(cn).toCharArray();
    
    for (int i=0; i < scn.length;i++)
    {
      if (j > b.length - 1)
        return 999999;

      b[j] = scn[i];
      j++;
    }
    
    return j;
  }
  
  public void TestWriteInt(String b, int j, int cn, String expectedStr, int expectedIdx)
  {
    char[] a = b.toCharArray();
    int out = WriteInt(a, j, cn);
    verifier.Verify("New String", expectedStr, new String(a));
    verifier.Verify("New Idx", expectedIdx, out);
  }
  
  public void TestInput(String s, String expected)
  {
    w("input " + s);
    char[] a = s.toCharArray();
    char[] o = Compress(a);
    String out = new String(o);
    out = out.trim();
    verifier.Verify("", expected, out);
  }
}

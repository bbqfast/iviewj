package iviewj.others;

import iviewj.IVerifier;

public class CompressStr2 extends CompressStr {
  public CompressStr2(IVerifier v)
  {
    super(v);
  }  
  
  // this is a cleaner implementation
  public char[] Compress2(char a[])
  {
    if (a.length <= 0)
      return a;
    char b[] = new char[a.length];
    int i=0, j=1, cnt = 1;
    b[0] = a[0];
    
    while (i + 1 < a.length)
    {
      if (a[i+1] == a[i]) 
        cnt ++;
      else
      {
        if (j + Integer.toString(cnt).length() >= a.length)
          return a;
        j = WriteInt(b, j, cnt);
        cnt = 1;
        b[j] = a[i+1];
        j++;
      }
      i++;
    }
    WriteInt(b, j, cnt);
    
    return b;
  }  
  
  // this is a cleaner implementation
  public char[] Compress(char a[])
  {
    if (a.length <= 0)
      return a;
//    char b[] = new char[a.length];
    char lc=a[0];
    Integer cnt=0;
    String b = "";
    
    for (int i=0;i<=a.length;i++)
    {
      if (i != a.length && a[i] == lc) {
        cnt++;
        lc = a[i];
      } else {
        b = b + lc;
        b = b + cnt.toString();
        lc = a[i];
        cnt = 1;
      }
    }
     
    return b.toCharArray();
  }  
}

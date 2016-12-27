package iviewj.others;

import iviewj.IVerifier;

public class SpcTo20_2 extends SpcTo20 {
  
  public SpcTo20_2(IVerifier v)
  {
    super(v);
  }
  
  public void ReplaceWith20(char[] str, int length, int newLength) {
    int s = length - 1, d = newLength - 1;
    str[newLength] = '\0';
    
    // gotcha: s > 0 will exclude begining of string
    while (s >= 0)
    {
      if (str[s]!=' ')
      {
        str[d] = str[s];
        d--; s--;
      }
      else
      {
        str[d] = '0';
        str[d-1] = '2';
        str[d-2] = '%';
        d=d-3;
        s--;
      }
    }
  }  
}

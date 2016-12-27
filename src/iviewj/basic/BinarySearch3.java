package iviewj.basic;

import iviewj.IVerifier;

public class BinarySearch3 extends BinarySearch {
  public BinarySearch3(IVerifier v) {
    super(v);
  }
  
  public int Search(Integer[] a, Integer p) {
    Integer l=0, h=a.length, m;
    while (h >= l)
    {
      m = (l + h) / 2;
      if (a[m] == p)
        return m;
      if (p < a[m])
        h = m-1;
      if (p > a[m])
        l = m+1;
    }
    return -1;
  }  
}

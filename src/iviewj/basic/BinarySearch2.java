package iviewj.basic;

import iviewj.IVerifier;
import iviewj.Utils;

public class BinarySearch2 extends BinarySearch {

  public BinarySearch2(IVerifier v) {
    super(v);
  }

  public int Search0(Integer[] a, Integer d) {
    Integer s = 0, e = a.length - 1, m = 0;
    // make sure test with edge cases such as element found at the edge, borders
    // should be s <= e because it failed at looking for 4 in 4 array
    while (s < e) {
      m = (s + e) / 2;
      if (a[m] == d) {
        return m;
      }
      if (d < a[m]) {
        e = m - 1;
      } else if (d > a[m]) {
        s = m + 1;
      }
    }
    return -1;
  }

  // mistake:  r >= l
  public int Search(Integer[] a, Integer d) {
    Integer l = 0, r = a.length -1, m = 0;

    while (r >= l) {
      m = (l + r) / 2;
      if (a[m] == d)
        return m;
      else if (d < a[m])
        r = m - 1;
      else
        l = m + 1;
    }

    return -1;
  }
}

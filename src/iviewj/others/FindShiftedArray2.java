package iviewj.others;

import javax.management.OperationsException;
import GDC.*;
import iviewj.IVerifier;

public class FindShiftedArray2 extends FindShiftedArray {

  public FindShiftedArray2(IVerifier v) {
    super(v);
  }

  // bug with input int[] input = { 7, 1, 2, 3, 4, 5, 6 };
  public int FindShifted_0(Integer[] a) {
    int mf = -1, l = 0, h = a.length - 1, m = 0;

    while (h > l) {
      m = (l + h) / 2;
      w("" + m);
      if (a[m] > a[h]) // right
      {
        mf = m;
        l = m + 1;
        continue;
      }
      if (a[m] < a[l]) { // left
        mf = m - 1;
        h = m - 1;
        continue;
      }

      break;
    }

    return mf;
  }

  // mistake, return m instead of b
  public int FindShifted(Integer[] a) {
    int l = 0, r = a.length - 1, m = 0, b = -1;
    while (r >= l) {
      m = (l + r) / 2;
      if (a[l] > a[m]) {
        r = m - 1;
        b = m - 1;
      } else if (a[r] < a[m]) {
        l = m + 1;
        b = m;
      } else {
        break;
      }

    }
    return b;
  }
}

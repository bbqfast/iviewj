package iviewj;

import javax.management.OperationsException;
import GDC.*;

public class FindShiftedArray2 extends FindShiftedArray {

  public FindShiftedArray2(IVerifier v) {
    super(v);
  }

  // bug with input int[] input = { 7, 1, 2, 3, 4, 5, 6 };
  public int FindShifted(Integer[] a) {
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
      if (a[m] < a[l]) {
        mf = m - 1;
        h = m - 1;
        continue;
      }

      break;
    }

    return mf;
  }
}

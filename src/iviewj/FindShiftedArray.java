package iviewj;

import javax.management.OperationsException;
import GDC.*;

public class FindShiftedArray extends TestBase {

  public FindShiftedArray(IVerifier v) {
    super(v);
  }

  protected void TestInput(Integer[] input, Integer expected) {
    w(Utils.PrintArray("Input:", input));

    int pos;
    pos = FindShifted(input);

    verifier.Verify("FindShifted", expected, pos);
  }

  // bug with input int[] input = { 7, 1, 2, 3, 4, 5, 6 };
  public int FindShifted(Integer[] arr) {
    int s = 0;
    int e = arr.length - 1;
    int m = (s + e) / 2;
    int bidx = -1;

    while (e > (s + 1)) // fix off by one error
    {
      if (arr[s] > arr[m]) //  abnormal idx on left  side
      {
        e = m;
        m = (s + m) / 2;
        bidx = s;
      } else if (arr[e] < arr[m]) {
        s = m;
        m = (e + m) / 2;
        bidx = e - 1;  // to be consistant with defining abnormal index
      } else {
        break;
      }
    }
    return bidx;
  }

  public void Test1() {
    TestInput(new Integer[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 2);
    TestInput(new Integer[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 6);
    TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1);
    TestInput(new Integer[]{2, 1}, 0);
    TestInput(new Integer[]{1, 2}, -1);
  }
}

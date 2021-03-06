package iviewj.basic;

import iviewj.IVerifier;

public class MaxSum2 extends MaxSum {

  public MaxSum2(IVerifier v) {
    super(v);
  }

  public int FindMaxSum(int[] a) {
    int t = 0;
    int max = 0;

    for (int i = 0; i < a.length; i++) {
      t += a[i];
      max = Math.max(t, max);
      if (t < 0) {
        t = 0;
      }
    }
    return max;
  }
}

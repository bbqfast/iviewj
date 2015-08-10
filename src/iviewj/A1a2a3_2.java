package iviewj;

import javax.management.OperationsException;
import GDC.*;

/// <summary>
/// Summary description for A1a2a3.
/// </summary>
public class A1a2a3_2 extends A1a2a3 {

  public A1a2a3_2(IVerifier v) {
    super(v);
  }

  public void Arrange(String[] a) {
    int half = a.length / 2;
    for (int i = 1; i < half; i++) {
      int s = half - i;
      for (int j = 0; j < i * 2; j = j + 2) {
        Utils.Swap(a, s + j, s + j + 1);
      }
    }
  }
}

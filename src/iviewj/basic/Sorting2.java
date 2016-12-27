package iviewj.basic;

import javax.management.OperationsException;
import GDC.*;
import iviewj.IVerifier;
import iviewj.Utils;

public class Sorting2 extends Sorting {

  public Sorting2(IVerifier v) {
    super(v);
  }

  public void Sort(Integer[] a) {
    for (Integer i = 0; i < a.length; i++) {
      for (Integer j = i + 1; j < a.length; j++) {
        if (a[j] < a[i]) {
          Utils.Swap(a, i, j);
        }
      }
    }

  }
}

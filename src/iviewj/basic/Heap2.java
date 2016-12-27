package iviewj.basic;

import iviewj.IVerifier;
import iviewj.Utils;

public class Heap2 extends Heap {

  public Heap2(IVerifier v) {
    super(v);
  }

  public void Insert2(Integer x) {
    last++;
    int n = last;
    // mistake:  need to assign latest value
    tr[n] = x;
    while (tr[n / 2] > 0 && tr[n / 2] > tr[n]) // mistake:  < should be > 
    {
      Utils.Swap(tr, n / 2, n);
      n = n / 2;
    }
  }

  public boolean Delete(int[] d) {
    d[0] = -1;
    if (last == 0) {
      return false;
    }

    d[0] = tr[1];

    // mistake:  set min before altering 
    tr[1] = tr[last];
    last--;
    int n = 1;
    int l;
    int r;
    while (n * 2 <= last) {
      l = n * 2;
      r = (n * 2) + 1;
      if (r <= last && tr[r] < tr[l] && tr[n] > tr[r]) {
        Utils.Swap(tr, n, r);
        n = r;
      } else if (tr[n] > tr[l]) {
        Utils.Swap(tr, n, l);
        n = l;
      } else {
        break;
      }
    }

    return true;
  }

}

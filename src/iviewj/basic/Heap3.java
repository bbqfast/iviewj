package iviewj.basic;

import iviewj.IVerifier;
import iviewj.Utils;

public class Heap3 extends Heap {

  public Heap3(IVerifier v) {
    super(v);
  }
  
  public void Insert(Integer x) {
    last++;
    int c = last;
    tr[last] = x;
    while (c > 1 && tr[c/2] > tr[c])
    {
      Utils.Swap(tr, c / 2, c);
      c = c / 2;
    }
  }

  public boolean Delete(int[] d) {
    if (last == 0)
      return false;
    
    int ret = tr[1];
    tr[1] = tr[last];
    
    // gotcha:  make sure calculate last at end of the loop otherwise the loop would terminate at wrong spot
    int c = 1;
    while (c * 2 <= last)
    {
      int nc = c * 2;
      int swapIdx;
      if (nc + 1 > last)
        swapIdx = nc;
      else
        swapIdx = tr[nc] < tr[nc+1] ? nc : nc + 1;
      Utils.Swap(tr, c, swapIdx);
      // gotcha:  make sure increment c with the actual swapped element instead of blindly using c * 2
      c = swapIdx;
    }
    last --;
    
    d[0] = ret;
    return true;
  }
  
}

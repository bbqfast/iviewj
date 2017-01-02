package iviewj.basic;

import javax.management.OperationsException;
import GDC.*;
import iviewj.IVerifier;

class BitCounting2 extends BitCounting {

  public BitCounting2(IVerifier v) {
    super(v);
  }

//  public int countBits(int v) {
//    int c = 0;
//    int b = 0;
//    while (v > 0) {
//      b = v & 1;
//      v = v >> 1;
//      c = c + b;
//    }
//    return c;
//  }
  
  public int countBits(int v) {
    int c = 0;
    while (v > 0) {
      c = c + (int)(v & 1);
      v = v >> 1;
    }
    return c;
  }

}

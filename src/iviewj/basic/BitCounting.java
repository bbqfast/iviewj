package iviewj.basic;

import javax.management.OperationsException;
import GDC.*;
import iviewj.IVerifier;
import iviewj.TestBase;

class BitCounting extends TestBase {

  public BitCounting(IVerifier v) {
    super(v);
  }

  public void TestInput(int n, int expected) {
    int cnt = countBits(n);
    verifier.Verify("countBits", expected, cnt);

  }

  public int countBits(int n) {
    w("Count bits for: " + n);
    int c = 0;
    for (; n > 0; n = n >> 1) {
      c = c + (n & 1);
    }
    return c;
  }

  @Override
  public void Test1() {
    TestInput(0, 0);
    TestInput(3, 2);
    TestInput(1, 1);
    TestInput(65535, 16);
  }
}

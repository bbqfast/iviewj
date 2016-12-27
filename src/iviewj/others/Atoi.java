package iviewj.others;

import iviewj.IVerifier;
import iviewj.TestBase;

public class Atoi extends TestBase {

  public Atoi(IVerifier v) {
    super(v);
  }

  public void TestInput(String a, int expected) {
    w("Atoi: a=" + a);
    int num = atoi(a);
    verifier.Verify("Atoi: ", expected, num);
  }

  public int atoi(String ar) {
    int i = 0;
    int sign = 1;
    int t = 0;
    // Complex condition, watch out!
    char[] a = ar.toCharArray();
    for (i = 0; i < a.length && (a[i] < '0' || a[i] > '9') && a[i] != '-'; i++) {
      if (i < a.length && a[i] == '-') {
        sign = -1;
        i++;
      }
    }
    while (i < a.length && a[i] >= '0' && a[i] <= '9') {
      t = t * 10;
      t += a[i] - '0';
      i++;
    }
    return t * sign;
  }

  public void Test1() {
    TestInput("1531", 1531);
    TestInput("-15", -15);
    TestInput("abcd", 0);
    TestInput("    -150  ", -150);
    TestInput("0", 0);
    TestInput("   +1990", 1990);
    TestInput("23 ", 23);
  }
}

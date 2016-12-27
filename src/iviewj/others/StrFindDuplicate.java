package iviewj.others;

import iviewj.IVerifier;
import iviewj.TestBase;

// use a bitmap to represent character set
// first locate the slot, then mod 8 to determine the bit slot
// if bit already set, means a duplicate is found
class StrFindDuplicate extends TestBase {

  public StrFindDuplicate(IVerifier v) {
    super(v);
  }

  public void TestInput(String s, int expected) {
    w("Input = " + s);
    int pos = findDup(s);
    verifier.Verify("StrFindDuplicate", expected, pos);

  }

  public int findDup(String str) {
    char[] s = str.toCharArray();
    byte[] field = new byte[32];
    for (int i = 0; i < s.length; i++) {

      // becaure with AND operation,
      // the result of AND is not neccesary 1 or 0, thus we take the inversion
      if ((field[s[i] / 8] & (1 << (s[i] % 8))) != 0) {
        return i;
      } else {
        field[s[i] / 8] = (byte) ((int) field[s[i] / 8] | (1 << (s[i] % 8)));
      }

    }
    return -1;
  }

  public void Test1() {
    TestInput("abba", 2);
    TestInput("hapy", -1);
    TestInput("z123456789z", 10);
    TestInput("xx", 1);
    TestInput("abdsafioewroiwfsafd", 4);
  }
}

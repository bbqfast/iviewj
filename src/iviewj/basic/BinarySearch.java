package iviewj.basic;

import iviewj.IVerifier;
import iviewj.TestBase;
import iviewj.Utils;

public class BinarySearch extends TestBase {

  public BinarySearch(IVerifier v) {
    super(v);
  }

  public void printm(int m, int s) {
    StringBuffer sb = new StringBuffer();
    for (int i=0;i<s;i++) {
     sb.append(i); 
    }
    StringBuffer sb2 = new StringBuffer();
    for (int i=0;i<m;i++) {
      sb2.append(" "); 
     }
    sb2.append("m");
    System.out.println(sb.toString());
    System.out.println(sb2.toString());
  }
  
  protected void TestInput(Integer[] input, int find, int expected) {
    w(Utils.PrintArray("Input:", input));
    w(" Search for " + find);
    // BinarySearch search = new BinarySearch();
    int pos;
    pos = Search(input, find);

    verifier.Verify("Found position", expected, pos);
  }

  public void Test1() {
    Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TestInput(a, 8, 7);
    TestInput(a, 1, 0);
    TestInput(a, 10, 9);
    TestInput(a, 3, 2);
    TestInput(a, 2, 1);
    TestInput(a, 4, 3);

    Integer[] b = new Integer[]{1, 2, 3, 4};
    TestInput(b, 4, 3);
  }

  public int Search(Integer[] a, Integer p) {
    Integer s = 0;
    Integer e = a[a.length - 1];
    Integer m = s;
    while (s <= e) {
      m = s + ((e - s) / 2);
      if (a[m] == p) {
        return m;
      }
      if (p < a[m]) {
        e = m;
      } else {
        s = m;
      }
    }
    return -1;
  }
}

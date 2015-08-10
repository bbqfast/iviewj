package iviewj;

import javax.management.OperationsException;
import GDC.*;

/// <summary>
/// Summary description for A1a2a3.
/// </summary>
public class A1a2a3 extends TestBase {

  public A1a2a3(IVerifier v) {
    super(v);
  }

  public static void SwapByIndex(String[] a, int i, int j) {
    String tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public void swapMiddle(String[] a) {
    int half = a.length / 2;
    int quar = half - half / 2;
    int chalf = a.length / 2;

    // w( string.Format("half={0}, quar={1}", half, quar));
    while (quar < chalf) {
      SwapByIndex(a, quar, half);
      quar++;
      half++;
    }
  }

  public void swapMiddle(String[] a, int s, int e) {
    int len = e - s + 1;
    int half = len / 2;
    int quar
            = half / 2;
    int chalf = len / 2;

//			w( string.Format("half={0}, quar={1}", half, quar));
    while (quar < chalf) {
      SwapWithOffset(a, quar, half, s);
      quar++;
      half++;
    }
  }

  public void SwapWithOffset(String[] a, int i, int j, int s) {
    SwapByIndex(a, s + i, s + j);
  }

  public void ArrangeRecur(String[] a, int s, int e, boolean left) {
    int len = e - s + 1;

    if (len < 3) {
      return;
    }

    if (len == 4) {
      SwapWithOffset(a, 1, 2, s);
      return;
    }
    if (len == 3 && left) {
      SwapWithOffset(a, 1, 2, s);
      return;
    } else if (len == 3) {
      SwapWithOffset(a, 0, 1, s);
      return;
    }

    swapMiddle(a, s, e);
    int mid = (s + e) / 2;

    w(Utils.PrintArray("interm  =", a));
    if ((len / 2) % 2 != 0)// odd half
    {
      SwapByIndex(a, mid, mid + 1);
      ArrangeRecur(a, s, mid - 1, true);
      ArrangeRecur(a, mid + 2, e, false);
    } else {
      ArrangeRecur(a, s, mid, true);
      ArrangeRecur(a, mid + 1, e, false);
    }
  }

  void sortSe(String[] a, int low, int high) {
    int mid = (low + high) >> 1;
    int j = mid + 1, i = mid;
    if (high - low <= 1) {
      return;
    }
//			swap(a[mid],a[mid+1]);
    SwapByIndex(a, mid, mid + 1);
    while (i > low + 1) {
//                swap(a[i],a[i-1]);
      SwapByIndex(a, i, i - 1);
//				swap(a[j],a[j+1]);
      SwapByIndex(a, j, j + 1);
      j++;
      i--;
    }
    w(Utils.PrintArray("interm  =", a));

    sortSe(a, low + 2, high - 2);
  }

  public String[] SwapPairs0(String[] array) {
    for (int i = (array.length - 1) / 2, increment = 1; i > 0; i--, increment++) {
      for (int j = i, k = 0; k < increment; j += 2, k++) {
        SwapByIndex(array, j, j + 1);
      }
      w(Utils.PrintArray("interm  =", array));
    }
    return array;
  }

  public String[] SwapPairs(String[] a) {
    for (int i = a.length / 2 - 1, inc = 1; i > 0; i--, inc++) {
      for (int j = i, k = 0; k < inc; j += 2, k++) {
        SwapByIndex(a, j, j + 1);
      }
    }

    return a;
  }

  public void Arrange(String[] a) {
    //			ArrangeRecur(a, 0, a.Length - 1, false);
    //			 sortSe(a, 0, a.Length - 1);
    SwapPairs(a);

  }

  public void TestSwap(String[] a, String[] b) {
    w(Utils.PrintArray("Input   =", a));
    Arrange(a);
    Utils.MatchArray(a, b);
    w(Utils.PrintArray("Swapped =", a));
  }

  @Override
  public void Test1() {
    TestSwap(new String[]{"a1", "a2", "a3", "b1", "b2", "b3"},
            new String[]{"a1", "b1", "a2", "b2", "a3", "b3"});
    TestSwap(new String[]{"a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4"},
            new String[]{"a1", "b1", "a2", "b2", "a3", "b3", "a4", "b4"});
    TestSwap(new String[]{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8"},
            new String[]{"a1", "b1", "a2", "b2", "a3", "b3", "a4", "b4", "a5", "b5", "a6", "b6", "a7", "b7", "a8", "b8"});
    TestSwap(new String[]{"a1", "a2", "a3", "a4", "a5", "a6", "b1", "b2", "b3", "b4", "b5", "b6"},
            new String[]{"a1", "b1", "a2", "b2", "a3", "b3", "a4", "b4", "a5", "b5", "a6", "b6"});
    TestSwap(new String[]{"a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b5"},
            new String[]{"a1", "b1", "a2", "b2", "a3", "b3", "a4", "b4", "a5", "b5"});
  }
}

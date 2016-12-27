package iviewj.others;

public class ReverseSentence {

  private void RevStr(char[] a, int s, int e) {
    while (s < e) {
      char t = a[s];
      a[s] = a[e];
      a[e] = t;
      s++;
      e--;
    }
  }

  public void RevSentence(char[] a) {
    if (a.length == 0) {
      return;
    }

    RevStr(a, 0, a.length - 1);
    int i = 0;
    int begin = 0;
    while (i < a.length) {
      while (i < a.length && a[i] == ' ') // skip space
      {
        i++;
      }
      begin = i;
      while (i + 1 < a.length && Character.isLetter(a[i + 1])) {
        i++;
      }
      RevStr(a, begin, i);
      i++;
    }
  }

  private void Verify(String desc, String expect, String actual) {
    System.out.println(desc + "\nExpected=" + expect + "\nActual  =" + actual);
    if (expect.equals(actual)) {
      System.out.println("----------------- PASS ------------------------");
    } else {
      System.out.println("----------------- FAIL ------------------------");
    }
  }

  private void TestInput(String input, String expected) {
    char a[] = input.toCharArray();
    RevSentence(a);
    Verify("After reverse", expected, new String(a));
  }

  public void Test() {
    TestInput("", "");
    TestInput("x", "x");
    TestInput("ab", "ab");
    TestInput("I am a dog", "dog a am I");
    TestInput("I  am  a  dog", "dog  a  am  I");
    TestInput("a b c d e ", " e d c b a");
  }
}

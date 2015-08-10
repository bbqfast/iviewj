package iviewj;

public class PermutationSimple2 extends PermutationSimple {

  public PermutationSimple2(IVerifier v) {
    super(v);
  }

  @Override
  public void Permute(String _str) {
    char[] str = _str.toCharArray();
    doPermute(str, 0);
  }

  public void doPermute(char[] a, int s) {
    if (a.length == s) {
      w("[" + new String(a) + "]");
    }

    for (int i = s; i < a.length; i++) {
      swap(a, s, i);
      doPermute(a, s + 1);
      swap(a, s, i);
    }
  }
}
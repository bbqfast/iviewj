package iviewj;

import java.util.List;

public class Permutation2 extends Permutation{

  public Permutation2(IVerifier v) {
    super(v);
  }
  
  public List<String> Permute(String _str) // best
  {
    char[] str = _str.toCharArray();
//    List<String> outputs = new ArrayList<String>();
    doPermute(str, 0, 0); // depth starts with 0
    return outputs;
  }

  protected void doPermute(char[] str, int n, int depth) // best
  {
    for (int i=n; i < str.length; i++)
    {
      swap(str, n, i);
      print(depth, str); // DEBUG
      doPermute(str, n+1, depth + 1);
      swap(str, n, i);
    }
    
    if (n==str.length - 1)
    {
      print(str);
    }
  }  
}

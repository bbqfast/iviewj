package iviewj;

public class StrStr2 extends StrStr {

  public StrStr2(IVerifier v) {
    super(v);
  }
  
    public int strstr(char[] a, char[] b) {
      int j=0;
      for (int i=0; i<= (a.length - b.length);i++)
      {
        for (j=0; j < b.length && a[i+j]==b[j];j++){}
        if (j == b.length)
          return i;
      }
    return -1;
  }

}

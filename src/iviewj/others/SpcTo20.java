package iviewj.others;

import GDC.*;
import iviewj.IVerifier;
import iviewj.TestBase;

public class SpcTo20 extends TestBase {
  
  public SpcTo20(IVerifier v)
  {
    super(v);
  }

  protected void TestInput(String str, String expect) {
    String withSpc = fluffInput(str);
    char[] strArray = withSpc.toCharArray();
    ReplaceWith20(strArray, str.length(), withSpc.length() - 1);
    verifier.Verify("insert %20", new String(expect), new String(strArray));
  }  
  
  protected String fluffInput(String s)
  {
    int spc=0;
    char[] str = s.toCharArray();
    
    for (int i = 0; i < s.length(); i++) {
      if (str[i] == ' ') {
        spc++;
      }
    }
    // get addition space
    int add = spc * 2;
    StringBuffer sb = new StringBuffer(s);
    for(int i=0;i<add;i++)
    {
      sb.append(" ");
    }

    sb.append(" ");  // eof character
    return sb.toString();
  }
  
  public void ReplaceWith20(char[] str, int length, int newLength) {
    int spaceCount = 0, i = 0;

    str[newLength] = '\0';
    for (i = length - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[newLength - 1] = '0';
        str[newLength - 2] = '2';
        str[newLength - 3] = '%';
        newLength = newLength - 3;
      } else {
        str[newLength - 1] = str[i];
        newLength = newLength - 1;
      }
    }
  }
  
}

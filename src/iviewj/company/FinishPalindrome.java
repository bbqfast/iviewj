package iviewj.company;

import java.io.CharArrayReader;

import iviewj.IVerifier;
import iviewj.TestBase;

public class FinishPalindrome extends TestBase {
  public FinishPalindrome(IVerifier v) {
    super(v);
  }
  
  public Boolean isPalindrome(String s) {
    return isPalindrome(s.toCharArray());
  }
  
  public Boolean isPalindrome(char[] s) {
    w("isPalindrome " + s);
    
//    if (s.length == 0)
//      return false;
    int i=0,j=s.length-1;
    while (j> i) {
      if (s[i] != s[j])
        return false;
      i++;
      j--;
    }
    return true;
  }
  
  public String revs(String s) {
    StringBuilder input1 = new StringBuilder();
    input1.append(s);
    input1 = input1.reverse();
    return input1.toString();
  }
  
  public String findPalindrome(String s) {
    String rs = revs(s);
    int e = rs.length();
    int i = e - 1;
    
    String ps = "";
    
    // mistake: i < 0, revered condition
    // mistake: start with just last char
    while (i >= 0 && !isPalindrome(s + rs.substring(i) )) {
      i --;
    }
    
    return s + rs.substring(i);
  }
}

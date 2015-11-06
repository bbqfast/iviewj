package iviewj;

public class MitsExercise {
  String letters = "acegikmnoprstuvy";

  // given 
  public long hash(String str) {
    char []s = str.toCharArray();
    long h = 7;
    for (int i = 0; i < s.length; i++) {
      h = (h * 37 + letters.indexOf(s[i]));
    }
    return h;
  }
  
  // solution
  public String unHash(long hash, String nums) {
    for (int i=0; i<16; i++)
    {
      String res = unHashInternal(hash - i, nums + letters.charAt(i));
      if (res != null)
        return new StringBuffer(res).reverse().toString();
    }
    return null;
  }
  
  private String unHashInternal(long hash, String nums) {
    long remainder = hash % 37;
    hash = hash / 37;
    
    if (hash < 7 || remainder != 0) // eliminate unneccessary branches
      return null;
    
    if (hash == 7)
      return nums;
    
    for (int i=0; i<16; i++)
    {
      String res = unHashInternal(hash - i, nums + letters.charAt(i));
      if (res != null)
        return res;
    }
    return null;
  }
}

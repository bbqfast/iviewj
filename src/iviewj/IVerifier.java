package iviewj;

public interface IVerifier {
  void Verify(String desc, String  expect, String actual);
  void Verify(String desc, Integer[] expect, Integer[] actual);
  void Verify(String desc, int expect, int actual);
}

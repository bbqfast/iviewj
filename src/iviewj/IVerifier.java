package iviewj;

import GDC.TNode;
import java.awt.Point;
import java.util.List;

public interface IVerifier {

  void Verify(String desc, String expect, String actual);

  void Verify(String desc, Integer[] expect, Integer[] actual);

  void Verify(String desc, int expect, int actual);

  void Verify(String desc, List<String> expected, List<String> actual);

  void Verify(String desc, TNode expected, TNode actual);
  
  void Verify(String desc, Point[] expected, List<Point> actual);

  void Pass();

  void Fail();
}

package iviewj.others;

import GDC.Node;
import iviewj.IVerifier;
import iviewj.TestBase;
import iviewj.Utils;

public class CircularLinkedListLoopHead extends TestBase {

  public CircularLinkedListLoopHead(IVerifier v) {
    super(v);
  }

  public void TestInput(Integer[] input, int loopNode) {
    Node[] inputList = new Node[1];
    inputList[0] = Utils.ArrayToLinkList(input);

    // findEnd
    Node e = inputList[0];
    while (e.next != null) {
      e = e.next;
    }

    Node l = inputList[0];
    while (l.data != loopNode) {
      l = l.next;
    }

    e.next = l;
    Node expected = l;

    Node actual = findLoopHead(inputList[0]);
    if (actual != expected) {
      verifier.Fail();
      w("expected:" + expected.data);
      w("actual:" + actual.data);
    }
  }

  public Node findLoopHead(Node h) {
    Node s = h, f = h, m = null;
    while (f != null && f.next != null) {
      s = s.next;
      f = f.next.next;

      // gotcha, break out of loop!
      if (f == s) {
        m = f;
        break;
      }
    }

    if (m == null) {
      return null;
    }
    s = h;
    while (s != m) {
      s = s.next;
      m = m.next;
    }
    return s;
  }

}

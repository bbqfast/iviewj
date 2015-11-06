package iviewj;

import GDC.*;

public class RevLinkList extends TestBase {

  public RevLinkList(IVerifier v) {
    super(v);
  }

  // use of 3 variable
  // cursor
  // last - remember last node when cursor advance
  // next - remember next node when cur.next is twisted to point to last
  // mistake:  tmp should assign to .next because .next will be modified
  public Node Reverse(Node head) {
    Node last = null;
    Node cur = head;
    while (cur != null) {
      Node tmp = cur.next;
      cur.next = last;
      last = cur;
      cur = tmp;
    }
    return last;
  }

  protected void TestInput(Integer[] input, Integer[] expected) {
    w(Utils.PrintArray("Reverse Link list", input));
    Node head = Utils.ArrayToLinkList(input);
    Node Reversed = this.Reverse(head);
    Integer[] reversed = Utils.LinkListToArray(Reversed);
    verifier.Verify("Reversed List", expected, reversed);
  }

  public void Test1() {
    TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, new Integer[]{8, 7, 6, 5, 4, 3, 2, 1});
    TestInput(new Integer[]{5}, new Integer[]{5});
    TestInput(new Integer[]{5, 1}, new Integer[]{1, 5});
  }
}

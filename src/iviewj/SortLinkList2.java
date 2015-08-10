package iviewj;

import GDC.*;
// Sort a linked list using merge sort
// keep halving the list until reaches base case
// then merge back

public class SortLinkList2 extends SortLinkList {

  public SortLinkList2(IVerifier v) {
    super(v);
  }

  public void Sort(Node[] head) {
    Node sorted = SortInt(head[0]);
    head[0] = sorted;
  }

  public Node SortInt(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node[] r = new Node[1];
    Node left = Slice(head, r);
    Node right = r[0];
    Node leftSorted = SortInt(left);
    Node rightSorted = SortInt(right);
    Node sorted = Merge(leftSorted, rightSorted);
    return sorted;
  }

  public Node Slice(Node head, Node[] right) {
    Node fast = head;
    Node slow = head;
    Node prev = head;
    while (fast != null) {
      prev = slow;
      fast = fast.next;
      slow = slow.next;
      if (fast != null) {
        fast = fast.next;
      }
    }

    prev.next = null;
    right[0] = slow;
    return head;
  }

  public Node RMerge(Node left, Node right) {
    return null;
  }

    // NOTE:  Make sure your while condition is not conflicting with the if's
  // because we're checking one side is null, if we use &&, then
  // we will exit out of the loop before having a chance to check it
  public Node Merge(Node left, Node right) {
//        return super.Merge(left, right);
    w("left=");
    Utils.PrintLinkList(left);
    Utils.PrintLinkList(right);
    Node emptyhead = new Node();
    Node cur = emptyhead;
    while (left != null || right != null) {
      if (right == null) {
        cur.next = left;
        left = left.next;
        break;
      } else if (left == null) {
        cur.next = right;
        right = right.next;
        break;
      }
      if (left.data <= right.data) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
      cur.next = null;
    }
    return emptyhead.next;
  }
}

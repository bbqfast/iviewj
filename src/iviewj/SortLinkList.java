package iviewj;

import GDC.*;
// Sort a linked list using merge sort
// keep halving the list until reaches base case
// then merge back

public class SortLinkList extends TestBase {

  public SortLinkList(IVerifier v) {
    super(v);
  }

  public void Sort(Node[] head) {
    Node sorted = SortInt(head[0]);
    head[0] = sorted;
  }

  public Node SortInt(Node head) {
    if (null == head || null == head.next) {
      return head;
    }
    Node[] right = new Node[1];
    Node left = null;
    left = Slice(head, right);
    left = SortInt(left);
    right[0] = SortInt(right[0]);
    Node merge = Merge(left, right[0]);
    return merge;
  }

  public Node Slice(Node head, Node[] right) {
    // splice
    Node slow = head;
    Node fast = head;
    Node last = null;
    while (fast != null) {
      fast = fast.next;
      last = slow;
      slow = slow.next;
      if (fast == null) {
        break;
      }
      fast = fast.next;
    }
    last.next = null;
    d("Left=" + head);
    d("Right=" + slow);
    right[0] = slow;
    return head;

  }

  public Node RMerge(Node left, Node right) {
    // one side depleted, return the other
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }

    if (left.data < right.data) {
      // return the min, and recursively build the next node
      left.next = RMerge(left.next, right);
      return left;
    } else {
      right.next = RMerge(left, right.next);
      return right;
    }

  }

    // NOTE:  Make sure your while condition is not conflicting with the if's
  // because we're checking one side is null, if we use &&, then
  // we will exit out of the loop before having a chance to check it
  public Node Merge(Node left, Node right) {
    Node head = new Node();
    Node prev = head;
    while (left != null || right != null) {
      if (null == right) {
        prev.next = left;
        left = left.next;
      } else if (null == left) {
        prev.next = right;
        right = right.next;
      } else if (left.data <= right.data) {
        prev.next = left;
        left = left.next;
      } else {
        prev.next = right;
        right = right.next;
      }
      prev = prev.next;
      prev.next = null;
            //				if (left!=null)
      //					Console.WriteLine("L="+left.ToString());
      //				if (right!=null)
      //					Console.WriteLine("R="+right.ToString());
      //				Console.WriteLine(head.next.ToString());
    }

    // mistake:  returning head instead of head.next
    return head.next;
  }

  protected void TestInput(Integer[] input, Integer[] expected) {
    w(Utils.PrintArray("Input", input));
    Node[] inputList = new Node[1];
    inputList[0] = Utils.ArrayToLinkList(input);
    Sort(inputList);
    Integer[] result = Utils.LinkListToArray(inputList[0]);
    w(Utils.PrintArray("result", result));

    verifier.Verify("Match", result, expected);
  }

  @Override
  public void Test1() {
    TestInput(new Integer[]{101, 1, 17, 14, 10, 99, 8, 6, 9, 2, 21},
            new Integer[]{1, 2, 6, 8, 9, 10, 14, 17, 21, 99, 101});

    TestInput(new Integer[]{9, 8, 7, 6, 4, 3},
            new Integer[]{3, 4, 6, 7, 8, 9});

    TestInput(new Integer[]{1, 3, 2},
            new Integer[]{1, 2, 3});
  }
}

//		public override Node Merge(Node left, Node right)
//		{
//			if (left == null)
//				return right;
//			if (right == null)
//				return left;
//			if (right.data < left.data)
//			{
//				right.next = Merge(left, right.next);
//				return right;
//			}
//			else
//			{
//				left.next = Merge(left.next, right);
//				return left;
//			}
//		}


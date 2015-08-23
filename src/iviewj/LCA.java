package iviewj;

import GDC.*;
/// <summary>
/// Q: In a unsorted binary tree, find lowest common parent btw p & q
///
/// A:
/// For every node traversal, there are few case we consider:
/// - the Node is one of them which we looking for, p or q
/// - if we already found both p & q, bubble the current node, this IS the LCA
/// - if we only find one side, bubble up the number we found on that side
/// </summary>

public class LCA extends TestBase {

  public LCA(IVerifier v) {
    super(v);
  }

  // propogate null if root never match p nor q

  public TNode LowestCommonAncestor(TNode root, int p, int q) {
    TNode l;
    TNode r;
    TNode tmp;
    if (root == null) {
      return null;
    }

        //if (root.left.Data == p || root.left.Data == q || root.right.Data == p || root.right.Data == q)
    //{
    //    return root;
    //}
    if (root.Data == p || root.Data == q) {
      return root;
    } else {
      l = LowestCommonAncestor(root.left, p, q);
      r = LowestCommonAncestor(root.right, p, q);

      if (l != null && r != null) // both left & right non-null, so This is the LCA, propagate up
      {
        return root;
      } else {
        tmp = (l != null) ? l : r; // if left not null return L else reutrn R
        return tmp; // both not found will return null here
      }
    }
  }
  
  protected void TestInput(int[] inArr, int[] preArr, int left, int right, int expected) {
    RebuildTree rt = new RebuildTree(verifier);
    TNode root = rt.Rebuild(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1);
    rt.Inorder(root, "");

    TNode actual = LowestCommonAncestor(root, left, right);
    int data = actual == null ? -1: actual.Data;
    verifier.Verify("", expected, data);
  }  

  public void Test1() {
    int[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    TestInput(inArr, preArr, 1, 3, 2);
    TestInput(inArr, preArr, 1, 9, 4);
    TestInput(inArr, preArr, 5, 9, 8);
    TestInput(inArr, preArr, 2, 8, 4);
  }
}

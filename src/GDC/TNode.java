package GDC;

public class TNode {

  public Integer Data;
  public TNode left;
  public TNode right;

  public TNode() {
  }

  public TNode(int _d) {
    this.Data = _d;
  }

  public boolean compare(TNode root1, TNode root2) {
    // Shortcut for reference equality; also handles equals(null, null)
    if (root1 == root2) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return root1.Data.equals(root2.Data)
            && compare(root1.left, root2.left)
            && compare(root1.right, root2.right);
  }
}

package iviewj;

import javax.management.OperationsException;
import java.util.*;
import GDC.*;

public class TreeTraverseNoRecursion extends TestBase {

  public TreeTraverseNoRecursion(IVerifier v) {
    super(v);
  }

  public void InorderStack(TNode[] r) {
    NodeStack stk = new NodeStack();
    TNode c = r[0]; // current
    boolean done = false;
    while (!done) {
      if (c != null) {
        stk.push(c);
        c = c.left;
      } else {
        if (stk.size() != 0) {
          c = stk.Pop();
          w(c.Data.toString());
          c = c.right;
        } else {
          done = true;
        }
      }
    }
  }

  public void InorderStackMy(TNode[] r) {
    NodeStack stk = new NodeStack();
    TNode c = r[0]; // current
    boolean done = false;
    boolean skip = false;
    while (!done) {
      if (c.left != null && !skip) {
        stk.push(c);
        c = c.left;
      } else if (c.right != null) {
        w(c.Data.toString());
        c = c.right;
        continue;
      } else {
        w(c.Data.toString());
        if (stk.size() != 0) {
          c = stk.Pop();
          w(c.Data.toString());
          // skip = false;
          if (c.right != null) {
            c = c.right;
          } else {
            c = stk.Pop();
            skip = true;
          }
        } else {
          done = true;
        }
      }
    }
  }

  public void MorrisTraversal(TNode[] root) {
    TNode current;
    TNode pre;

    if (root[0] == null) {
      return;
    }

    current = root[0];
    while (current != null) {
      if (current.left == null) {
        w(current.Data.toString());
        current = current.right;
      } else {
        /* Find the inorder predecessor of current */
        pre = current.left;
        while (pre.right != null && pre.right != current) {
          pre = pre.right;
        }

        /* Make current as right child of its inorder predecessor */
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        } /* Revert the changes made in if part to restore the original
         tree i.e., fix the right child of predecssor */ else {
          pre.right = null;
          w(current.Data.toString());
          current = current.right;
        } /* End of if condition pre.right == NULL */

      } /* End of if condition current.left == NULL*/

    } /* End of while */

  }

  public void PostorderStack(TNode[] r) {
    NodeStack stk = new NodeStack();
    TNode c = r[0]; // current
    boolean done = false;
    while (!done) {
      if (c != null) {
        stk.push(c);
        c = c.left;
      } else {
        if (stk.size() != 0) {
          c = stk.Pop();
          if (c.right != null) {
            c = c.right;
          } else {
            w(c.Data.toString());
          }

        } else {
          done = true;
        }
      }
    }
  }

  @Override
  public void Test1() {
    TNode[] root = new TNode[1];
    root[0] = new TNode();
    Utils.Insert(root, new Integer[]{40, 20, 60, 10, 30, 35, 32, 50, 70});
    Utils.PrintTree(root[0], "");

    TreeTraverseNoRecursion ts = new TreeTraverseNoRecursion(verifier);
        // ts.InorderStack(ref root);
    // ts.PostorderStack(ref root);
    // ts.MorrisTraversal(ref root);
    ts.InorderStack(root);
    w("----------");
    ts.InorderStackMy(root);
    w("----------");
    Utils.PrintTree(root[0], "");
    w("----------");
    Utils.PrintTreePost(root[0], "");

  }
}

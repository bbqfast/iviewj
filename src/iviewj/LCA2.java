/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iviewj;

import GDC.TNode;

public class LCA2 extends LCA {
  public LCA2(IVerifier v)
  {
    super(v);
  }

  public TNode LowestCommonAncestor(TNode root, int p, int q) {
    if (root == null) return null;
    
    if (root.Data == p || root.Data == q) return root;
    
    TNode left = LowestCommonAncestor(root.left, p, q);
    TNode right = LowestCommonAncestor(root.right, p, q);
    
    if (left != null && right != null) return root;
    
    return left != null ? left : right;
  }  
}

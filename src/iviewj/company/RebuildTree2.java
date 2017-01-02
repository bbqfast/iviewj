package iviewj.company;

import iviewj.IVerifier;
import iviewj.TestBase;
import iviewj.TestVerifier;
import iviewj.others.BSTFromPreOrder;

import java.util.ArrayList;
import java.util.Arrays;

import GDC.TNode;


public class RebuildTree2 extends TestBase {

  public RebuildTree2(IVerifier v) {
    super(v);
  }
  
  TNode Rebuild(Integer iA[], Integer pA[]) {
    int []pi = new int[1];
    pi[0] = 0;
    return bt(iA, pA, pi);
  }
  
  TNode bt(Integer iA[], Integer pA[], int[] pi) {
//    System.out.println(pi[0]);
    int r = pA[pi[0]];
    pi[0] = pi[0] + 1;
    
    if (iA.length == 1) {
      return new TNode(iA[0]);
    }
    
    Integer []left = left(iA, r);
    Integer []right= right(iA, r);
    TNode ln = bt(left, pA, pi);
    TNode rn = bt(right, pA, pi);
    
    TNode root = new TNode(r);
    root.left = ln;
    root.right = rn;
    return root;
  }
  
  
  Integer[] left(Integer[] iA, int r) {
    ArrayList<Integer> out = new ArrayList<>();
    int i=0;
    for (i=0;i< iA.length && r != iA[i];i++)
      out.add(iA[i]);
    Integer[] outi = (Integer[]) out.toArray(new Integer[0]);
    return outi;
  }
  
  Integer[] right(Integer[] iA, int r) {
    ArrayList<Integer> out = new ArrayList<>();
    int i=0;
    for (i=0;i< iA.length && r != iA[i];i++)
      ;
    for (i=i+1;i < iA.length;i++)
      out.add(iA[i]);
    Integer[] outi = (Integer[]) out.toArray(new Integer[0]);
    return outi;
  }
  
  public void TestInput(Integer[] preArr, TNode expected) {
    BSTFromPreOrder treeMaker = new BSTFromPreOrder(new TestVerifier());
    TNode nt = treeMaker.ConstructTree(preArr, preArr.length);

    verifier.Verify("Tree identical:", expected, nt);
  } 
  
}
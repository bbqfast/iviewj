package iviewj.company;

import GDC.TNode;
import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.company.RebuildTree;
import iviewj.others.BSTFromPreOrder;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BSTFromPreOrderTest {
  BSTFromPreOrder instance = null;
  
  public BSTFromPreOrderTest() {
  }

  @Before
  public void setUp() {
    instance = new BSTFromPreOrder(new TestVerifier());
  }
  
  @Test
  public void testTestInput() {
    System.out.println(TestHelper.getMethodName(2));
    int[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    int[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    RebuildTree rt = new RebuildTree(new TestVerifier());
    TNode root = rt.Rebuild(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1);
    rt.Inorder(root, "");
    
    instance.TestInput(preArr, root);
  }
}

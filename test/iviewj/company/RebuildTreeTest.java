package iviewj.company;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import GDC.TNode;

import static org.junit.Assert.*;

import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.Utils;
import iviewj.others.BSTFromPreOrder;

//@RunWith(SpringJUnit4ClassRunner.class)
public class RebuildTreeTest {
  RebuildTree2 rebuild;

  @Before
  public void setup() {
    rebuild = new RebuildTree2(new TestVerifier());
  }

  @Test
  public void lefttest() {
    rebuild = new RebuildTree2(new TestVerifier());
    Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6 };

    Integer[] o = rebuild.left(a, 4);

    for (Integer x : o)
      System.out.println(x);
  }

  @Test
  public void righttest() {
    rebuild = new RebuildTree2(new TestVerifier());
    Integer[] a = new Integer[] { 1, 2, 3, 4, 5, 6 };

    Integer[] o = rebuild.right(a, 4);

    for (Integer x : o)
      System.out.println(x);
  }
  
  @Test
  public void testTestInput() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    Integer[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    RebuildTree2 rt = new RebuildTree2(new TestVerifier());
    TNode root = rt.Rebuild(inArr, preArr);
    Utils.Inorder(root, "");
    
    rt.TestInput(preArr, root);
    
//    rebuild.TestInput(preArr, root);
  }

}

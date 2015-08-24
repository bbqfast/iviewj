package iviewj;

import GDC.TNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LCATest {

  LCA2 instance;

  public LCATest() {
  }

  @Before
  public void setUp() {
    instance = new LCA2(new TestVerifier());
  }

  @Test
  public void directChildren() {
    System.out.println(TestHelper.getMethodName(2));
    int[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    instance.TestInput(inArr, preArr, 1, 3, 2);
  }
  
  @Test
  public void wholeTreeSpan() {
    System.out.println(TestHelper.getMethodName(2));
    int[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    instance.TestInput(inArr, preArr, 1, 9, 4);
  }
  
  @Test
  public void rightTree() {
    System.out.println(TestHelper.getMethodName(2));
    int[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    instance.TestInput(inArr, preArr, 5, 9, 8);
  }
  
  @Test
  public void atRoot() {
    System.out.println(TestHelper.getMethodName(2));
    int[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    instance.TestInput(inArr, preArr, 2, 8, 4);
  }  
}

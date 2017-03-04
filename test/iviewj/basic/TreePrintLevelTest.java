package iviewj.basic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GDC.TNode;
import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.Utils;
import iviewj.company.RebuildTree;

public class TreePrintLevelTest {
  TreePrintLevel instance;
  
  @Before
  public void setUp() {
    instance = new TreePrintLevel(new TestVerifier());
  }

  @Test
  public void basic() {
    System.out.println(TestHelper.getMethodName(2));
    System.out.println(TestHelper.getMethodName(2));

    Integer[] inArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] preArr = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    RebuildTree rt = new RebuildTree(new TestVerifier());
    
    TNode root = rt.Rebuild(preArr, inArr);
    Utils.Inorder(root, "");
    
    List<String> lines = instance.printLevels(root);
    
    for (String x : lines) {
      System.out.println(x);
    }
    
    assertEquals("4,",lines.get(0));
    assertEquals("2,8,",lines.get(1));
    assertEquals("1,3,6,9,",lines.get(2));
    assertEquals("5,7,",lines.get(3));
    
    
  }
}

package iviewj.basic;

import GDC.Node;
import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.basic.RevLinkList;
import iviewj.basic.RevLinkList2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RevLinkListTest {
  RevLinkList instance = null;
  
  public RevLinkListTest() {
  }
  
  @Before
  public void setUp() {
    instance = new RevLinkList2(new TestVerifier());
  }

  @Test
  public void basic() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, new Integer[]{8, 7, 6, 5, 4, 3, 2, 1});
  }
  
  @Test
  public void one() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{5}, new Integer[]{5});
  }  
  
  @Test
  public void two() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{5, 1}, new Integer[]{1, 5});
  }   
}

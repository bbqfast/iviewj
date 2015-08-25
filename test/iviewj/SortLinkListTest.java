package iviewj;

import GDC.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SortLinkListTest {
  SortLinkList instance;
  
  public SortLinkListTest() {
  }
  
  @Before
  public void setUp() {
    instance = new SortLinkList(new TestVerifier());
  }

  @Test
  public void randomOrder() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{101, 1, 17, 14, 10, 99, 8, 6, 9, 2, 21},
            new Integer[]{1, 2, 6, 8, 9, 10, 14, 17, 21, 99, 101});
  }
  
  @Test
  public void reversedOrder() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{9, 8, 7, 6, 4, 3},
            new Integer[]{3, 4, 6, 7, 8, 9});
  }
  
  @Test
  public void has3elem() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{1, 3, 2},
            new Integer[]{1, 2, 3});
  }  
}

package iviewj.others;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.others.StrFindDuplicate;

import static org.junit.Assert.*;

public class StrFindDuplicateTest {
  StrFindDuplicate instance;
          
  public StrFindDuplicateTest() {
  }

  @Before
  public void setUp() {
    instance = new StrFindDuplicate(new TestVerifier());
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void abba() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("abba", 2);
  }

  @Test
  public void noDup() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("hapy", -1);
  }
  
  @Test
  public void testTestInput() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("abba", 2);
  }
  
  @Test
  public void z123456789z() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("z123456789z", 10);
  }
  
  @Test
  public void xx() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("xx", 1);
  }
  
  @Test
  public void abdsafioewroiwfsafd() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput("abdsafioewroiwfsafd", 4);
  }
}

package iviewj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import iviewj.basic.BinarySearchTest;
import iviewj.basic.BitCountingTest;
import iviewj.basic.HeapTest;
import iviewj.basic.LinkListRemoveDupTest;
import iviewj.basic.StrStrTest;
import iviewj.company.BSTFromPreOrderTest;
import iviewj.company.FindIslandTest;
import iviewj.others.AtoiTest;
import iviewj.others.CompressStrTest;
import iviewj.others.FindShiftedArrayTest;
import iviewj.others.LCATest;
import iviewj.others.MatrixRotateTest;
import iviewj.others.MaxSumTest;
import iviewj.others.PermutationTest;
import iviewj.others.QueueWith2StacksTest;
import iviewj.others.SpcTo20Test;
import iviewj.others.StrFindDuplicateTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {AtoiTest.class, BinarySearchTest.class, BitCountingTest.class, FindShiftedArrayTest.class, LCATest.class, LinkListRemoveDupTest.class, MaxSumTest.class,
  PermutationTest.class, StrFindDuplicateTest.class, StrStrTest.class, BSTFromPreOrderTest.class, HeapTest.class, FindIslandTest.class, SpcTo20Test.class, CompressStrTest.class, 
  MatrixRotateTest.class, QueueWith2StacksTest.class})
public class AllTests {

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

}

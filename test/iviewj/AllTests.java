package iviewj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author dev
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value={AtoiTest.class, BinarySearchTest.class, BitCountingTest.class, FindShiftedArrayTest.class, LCATest.class, LinkListRemoveDupTest.class, MaxSumTest.class,
PermutationTest.class, StrFindDuplicateTest.class, StrStrTest.class})
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

package iviewj.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.basic.Heap3;

import static org.junit.Assert.*;

public class HeapTest {
  Heap3 instance;
  
  public HeapTest() {
  }
  
  @Before
  public void setUp() {
    instance = new Heap3(new TestVerifier());
  }

  @Test
  public void insert1() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInsert(new Integer[]{1}, new Integer[]{-1, 1});
  }

  @Test
  public void insert123() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInsert(new Integer[]{1, 2, 3}, new Integer[]{-1, 1, 2, 3});
  }
  
  @Test
  public void insert432() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInsert(new Integer[]{4, 3, 2}, new Integer[]{-1, 2, 4, 3});
  }  
  
  @Test
  public void insert4321() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInsert(new Integer[]{4, 3, 2, 1 }, new Integer[]{-1, 1, 2, 3, 4});
  }    
  
  @Test
  public void insert243() { // no swap
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInsert(new Integer[]{2, 4, 3}, new Integer[]{-1, 2, 4, 3});
  }   

  @Test
  public void delete1() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestDelete(new Integer[]{1 }, 1, new Integer[]{-1});
  }  
  
  @Test
  public void delete2() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestDelete(new Integer[]{1, 2 }, 1, new Integer[]{-1, 2});
  }   
  
  @Test
  public void delete4() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestDelete(new Integer[]{4, 3, 2, 1 }, 1, new Integer[]{-1, 2, 4, 3});
  }
  
  @Test
  public void deletePromoteLeft() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestDelete(new Integer[]{2, 3, 4 }, 1, new Integer[]{-1, 3, 4});
  }    
  
  @Test
  public void deletePromoteRight() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestDelete(new Integer[]{2, 4, 3 }, 1, new Integer[]{-1, 3, 4});
  }    

  @Test
  public void insertDelete() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{1, 3, 2}, new Integer[]{1, 2, 3});
  }     

  @Test
  public void insertDelete6() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{3, 2, 4, 7, 9, 1}, new Integer[]{1, 2, 3, 4, 7, 9});
  }     
  
  @Test
  public void insertDelete9() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(new Integer[]{6, 3, 2, 4, 7, 5, 9, 1, 8}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
  }   
}

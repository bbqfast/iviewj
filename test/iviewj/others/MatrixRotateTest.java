package iviewj.others;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestVerifier;
import iviewj.others.MatrixRotate;

import static org.junit.Assert.*;

public class MatrixRotateTest {
  MatrixRotate instance;
  
  public MatrixRotateTest() {
  }
  
  
  @Before
  public void setUp() {
    instance = new MatrixRotate(new TestVerifier());
  }
  
  @Test
  public void rotateOne() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("a.b");
    lineList.add("...");
    lineList.add("d.c");
    
    List<String> expected = new ArrayList<String>();
    expected.add("b.c");
    expected.add("...");
    expected.add("a.d");    
    
    instance.TestRotateOne(lineList, 0, 0, 2, 0, expected);
  }
  
  @Test
  public void rotateOne_4by4() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("a..b");
    lineList.add("....");
    lineList.add("....");
    lineList.add("d..c");
    
    List<String> expected = new ArrayList<String>();
    expected.add("b..c");
    expected.add("....");
    expected.add("....");
    expected.add("a..d");    
    
    instance.TestRotateOne(lineList, 0, 0, 3, 0, expected);
  }
  
  @Test
  public void rotateOne_4by4_withIndex_2() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add(".a..");
    lineList.add("...b");
    lineList.add("d...");
    lineList.add("..c.");
    
    List<String> expected = new ArrayList<String>();
    expected.add(".b..");
    expected.add("...c");
    expected.add("a...");
    expected.add("..d.");    
    
    instance.TestRotateOne(lineList, 0, 0, 3, 2, expected);
  }  

  
  @Test
  public void rotateOne_4by4_withIndex_1() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("..a.");
    lineList.add("d...");
    lineList.add("...b");
    lineList.add(".c..");
    
    List<String> expected = new ArrayList<String>();
    expected.add("..b.");
    expected.add("a...");
    expected.add("...c");
    expected.add(".d..");
    
    instance.TestRotateOne(lineList, 0, 0, 3, 1, expected);
  }    
  
  @Test
  public void rotateOne_4by4_inner() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("....");
    lineList.add(".ab.");
    lineList.add(".dc.");
    lineList.add("....");
    
    List<String> expected = new ArrayList<String>();
    expected.add("....");
    expected.add(".bc.");
    expected.add(".ad.");
    expected.add("....");    
    
    instance.TestRotateOne(lineList, 1, 1, 3 - 2, 0, expected);
  }   
  
  @Test
  public void rotate_3by3() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("abc");
    lineList.add("hod");
    lineList.add("gfe");
    
    List<String> expected = new ArrayList<String>();
    expected.add("cde");
    expected.add("bof");
    expected.add("ahg");
    
    instance.TestRotate(lineList, expected);
  }    
  
  @Test
  public void rotate_4by4() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("abcd");
    lineList.add("lmne");
    lineList.add("kpof");
    lineList.add("jihg");
    
    List<String> expected = new ArrayList<String>();
    expected.add("defg");
    expected.add("cnoh");
    expected.add("bmpi");
    expected.add("alkj");
    
    instance.TestRotate(lineList, expected);
  }    
  
  @Test
  public void rotate_2by2() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("ab");
    lineList.add("dc");
    
    List<String> expected = new ArrayList<String>();
    expected.add("bc");
    expected.add("ad");
    
    instance.TestRotate(lineList, expected);
  }  
  
  @Test
  public void rotate_1by1() {
    System.out.println("TestRotateOne");
    List<String> lineList = new ArrayList<String>();
    lineList.add("a");
    
    List<String> expected = new ArrayList<String>();
    expected.add("a");
    
    instance.TestRotate(lineList, expected);
  }   
  
}

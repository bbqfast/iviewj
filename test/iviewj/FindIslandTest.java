package iviewj;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FindIslandTest {

  FindIsland instance;
  static final int EMPTY = 0;
  static final int LAND = 1;
  static final int MARK = 2;

  public FindIslandTest() {
  }

  @Before
  public void setUp() {
    instance = new FindIsland(new TestVerifier());
  }

  private Integer[][] findAdjTestGrid() {
    List<String> sg = new ArrayList<String>();
    sg.add("....o..........o..............");
    sg.add("...ooooo.....................o");
    sg.add("....oooo......................");
    sg.add("o.............................");
    sg.add("oo.............o..............");
    sg.add("o..............o..............");
    Integer[][] g = new FindIsland(new TestVerifier()).ConvertToGrid(sg);
    return g;
  }
  
  private Integer[][] sampleGrid2() {
    List<String> sg = new ArrayList<String>();
    sg.add("....o.........................");
    sg.add("...ooooooooooooooo...........o");
    sg.add("....ooo...ooooooooo...........");
    sg.add("o.......o....................o");
    sg.add("oo.....ooo.....o.............o");
    sg.add("o.......o......o...........ooo");
    Integer[][] g = new FindIsland(new TestVerifier()).ConvertToGrid(sg);
    return g;
  }  

  @Test
  public void testFindAdjMiddle() {
    System.out.println(TestHelper.getMethodName(2));

    Integer[][] g = findAdjTestGrid();
    instance.TestFindAdj(g, 4, 1, new Point[]{new Point(4, 0), new Point(4, 2), new Point(3, 1), new Point(5, 1)});
    instance.printGrid(g);
  }

  @Test
  public void testFindAdjTop() {
    System.out.println(TestHelper.getMethodName(2));

    Integer[][] g = findAdjTestGrid();
    instance.TestFindAdj(g, 4, 0, new Point[]{new Point(4, 1)});
    instance.printGrid(g);
  }

  @Test
  public void testFindAdjBottom() {
    System.out.println(TestHelper.getMethodName(2));

    Integer[][] g = findAdjTestGrid();
    instance.TestFindAdj(g, 15, 5, new Point[]{new Point(15, 4)});
    instance.printGrid(g);
  }

  @Test
  public void testFindAdjLeft() {
    System.out.println(TestHelper.getMethodName(2));

    Integer[][] g = findAdjTestGrid();
    instance.TestFindAdj(g, 0, 4, new Point[]{new Point(0, 3), new Point(0, 5), new Point(1, 4)});
    instance.printGrid(g);
  }

  @Test
  public void testDfs() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[][] g = findAdjTestGrid();
    List<String> sg = new ArrayList<String>();
    sg.add(".x...");
    sg.add("xxxxx");
    sg.add(".xxxx");
    Integer[][] subg = instance.ConvertToGrid(sg);

    instance.TestDfs(g, 4, 1, subg, 3, 0);
    System.out.println("\n");
    instance.printGrid(g);
  }
  
  @Test
  public void testDfsSide() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[][] g = findAdjTestGrid();
    List<String> sg = new ArrayList<String>();
    sg.add("x.");
    sg.add("xx");
    sg.add("x.");
    Integer[][] subg = instance.ConvertToGrid(sg);

    instance.TestDfs(g, 0, 4, subg, 0, 3);
    System.out.println("\n");
    instance.printGrid(g);
  } 
  
  @Test
  public void testDfsOne() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[][] g = findAdjTestGrid();
    List<String> sg = new ArrayList<String>();
    sg.add("x");
    Integer[][] subg = instance.ConvertToGrid(sg);

    instance.TestDfs(g, 15, 0, subg, 15, 0);
    System.out.println("\n");
    instance.printGrid(g);
  }
  
  @Test
  public void testDfsTwo() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[][] g = findAdjTestGrid();
    List<String> sg = new ArrayList<String>();
    sg.add("x");
    sg.add("x");
    Integer[][] subg = instance.ConvertToGrid(sg);

    instance.TestDfs(g, 15, 5, subg, 15, 4);
    System.out.println("\n");
    instance.printGrid(g);
  }   
  
  @Test
  public void testNumIslands() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[][] g = findAdjTestGrid();
    instance.TestNumIslands(g, 5);
  }    
  
  @Test
  public void testNumIslands2() {
    System.out.println(TestHelper.getMethodName(2));
    Integer[][] g = sampleGrid2();
    instance.TestNumIslands(g, 6);
  }      

  public void markGrid(Integer[][] g, List<Point> pts) {
    for (Point x : pts) {
      g[x.x][x.y] = FindIsland.MARK;
    }
  }

}

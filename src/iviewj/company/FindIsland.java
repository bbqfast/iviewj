package iviewj.company;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import iviewj.IVerifier;
import iviewj.TestBase;

public class FindIsland extends TestBase {

  static final int EMPTY = 0;
  static final int LAND = 1;
  static final int MARK = 2;

  public FindIsland(IVerifier v) {
    super(v);
  }

  public List<Point> FindAdj(Integer[][] g, int x, int y) {
    List<Point> adjs = new ArrayList<Point>();
    if (g[x][y] == EMPTY) {
      return adjs;
    }

    if (x > 0 && g[x - 1][y] == LAND) {
      adjs.add(new Point(x - 1, y));
    }
    if (x < g.length - 1 && g[x + 1][y] == LAND) {
      adjs.add(new Point(x + 1, y));
    }
    if (y > 0 && g[x][y - 1] == LAND) {
      adjs.add(new Point(x, y - 1));
    }
    if (y < g[0].length - 1 && g[x][y + 1] == LAND) {
      adjs.add(new Point(x, y + 1));
    }

    return adjs;
  }

  public boolean Dfs(Integer[][] g, int x, int y) {
    if (g[x][y] != LAND) {
      return false;
    }

    Queue<Point> q = new LinkedList<Point>();
    q.add(new Point(x, y));
    // main loop
      while (q.size() != 0) {
        Point r = q.remove();
        g[r.x][r.y] = MARK;
        List<Point> adjs = FindAdj(g, r.x, r.y);
        for (Point e : adjs) {
        q.add(e);
      }
    }

    return true;
  }

  public int NumIslands(Integer[][] g) {
    int count = 0;
    for (int iy = 0; iy < g[0].length; iy++) {
      for (int ix = 0; ix < g.length; ix++) {
        boolean isIsland = Dfs(g, ix, iy);
        if (isIsland) count ++;
      }
    }
    return count;
  }

  public Integer[][] ConvertToGrid(List<String> lineList) {
    String[] lines = lineList.toArray(new String[lineList.size()]);
    int xlen = lines[0].length();
    int ylen = lines.length;
    Integer[][] g = new Integer[xlen][ylen];

    for (int iy = 0; iy < ylen; iy++) {
      char[] s = lines[iy].toCharArray();
      for (int ix = 0; ix < xlen; ix++) {
        g[ix][iy] = s[ix] == 'o' ? LAND : 
                s[ix] == 'x' ? MARK :EMPTY;
      }
    }
    return g;
  }

  public void matchSubGrid(Integer[][] g, Integer[][] sg, int x, int y) {
    boolean fail = false;
    for (int iy = 0; iy < sg[0].length; iy++) {
      for (int ix = 0; ix < sg.length; ix++) {
        if (sg[ix][iy] != g[ix + x][iy + y]) {
          fail = true;
        }
      }
    }

    if (fail) {
      printGrid(g);
      printGrid(sg);
      verifier.Fail();
    }
  }

  public void printGrid(Integer[][] g) {
    for (int iy = 0; iy < g[0].length; iy++) {
      StringBuffer sb = new StringBuffer();
      for (int ix = 0; ix < g.length; ix++) {
        sb.append(g[ix][iy] == EMPTY ? "."
                : g[ix][iy] == MARK ? "x" : "o");
      }

      System.out.println(sb.toString());
    }
  }

  public void TestFindAdj(Integer[][] g, int x, int y, Point[] expectedPts) {
    List<Point> pts = FindAdj(g, x, y);
    verifier.Verify("FindAdj", expectedPts, pts);
  }

  public void TestDfs(Integer[][] g, int x, int y, Integer[][] sg, int xoff, int yoff) {
    Dfs(g, x, y);
    matchSubGrid(g, sg, xoff, yoff);
//    verifier.Verify("FindAdj", expectedPts, pts);
  }
  
  public void TestNumIslands(Integer[][] g, int expected) {
    int num = NumIslands(g);
    printGrid(g);
    verifier.Verify("islands:", expected, num);
  }  

  @Override
  public void Test1() {
  }
}

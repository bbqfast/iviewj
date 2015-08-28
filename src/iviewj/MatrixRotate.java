package iviewj;

import static iviewj.FindIsland.EMPTY;
import static iviewj.FindIsland.LAND;
import java.util.List;

public class MatrixRotate extends TestBase {
  public MatrixRotate(IVerifier v)
  {
    super(v);
  }

  public void rotate(char [][]a)
  {
    int L = a.length / 2;
    int w = a.length - 1;
    int x=0, y=0;
    while (x < L && y < L )
    {
      for (int i=0; i < w; i++)
      {
        rotateOne(a, x, y, w, i);
      }
      
      w = w - 2;
      x++; y++;
    }
  }  
  
  public void rotateOne(char [][]a, int x, int y, int w, int i)
  {
    char t=a[x][y+i];
    a[x][y+i] = a[x+w-i][y];
    a[x+w-i][y] = a[x+w][y+w-i];
    a[x+w][y+w-i] = a[x+i][y+w];
    a[x+i][y+w] = t;
  }
  
  public char[][] ConvertToGrid(List<String> lineList) {
    String[] lines = lineList.toArray(new String[lineList.size()]);
    int xlen = lines[0].length();
    int ylen = lines.length;
    char[][] g = new char[xlen][ylen];

    for (int iy = 0; iy < ylen; iy++) {
      char[] s = lines[iy].toCharArray();
      for (int ix = 0; ix < xlen; ix++) {
        g[ix][iy] = s[ix];
      }
    }
    return g;
  }
  
  public void PrintGrid(String m, char [][]g) {
    w(m);
    for (int iy = 0; iy < g[0].length; iy++) {
      StringBuffer sb = new StringBuffer();
      for (int ix = 0; ix < g.length; ix++) {
        sb.append(g[ix][iy]);
      }

      System.out.println(sb.toString());
    }
  }
  
  public void matchGrid(char[][] g, char[][] sg) {
    boolean fail = false;
    for (int iy = 0; iy < sg[0].length; iy++) {
      for (int ix = 0; ix < sg.length; ix++) {
        if (sg[ix][iy] != g[ix][iy]) {
          fail = true;
        }
      }
    }

    if (fail) {
      PrintGrid("actual", g);
      PrintGrid("expect", sg);
      verifier.Fail();
    }
  }  
  
  public void TestRotateOne(List<String> lineList, int x, int y, int w, int i, List<String> expectedLines)
  {
    char [][]a = ConvertToGrid(lineList);
    char [][]expect = ConvertToGrid(expectedLines);
    
    rotateOne(a, x, y, w, i);
    
    matchGrid(a, expect);
  }
  
  public void TestRotate(List<String> lineList, List<String> expectedLines)
  {
    char [][]a = ConvertToGrid(lineList);
    char [][]expect = ConvertToGrid(expectedLines);
    
    rotate(a);
    
    matchGrid(a, expect);
    
    PrintGrid("final", a);
  }  
}

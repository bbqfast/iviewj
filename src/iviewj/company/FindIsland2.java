package iviewj.company;

import iviewj.IVerifier;

public class FindIsland2 extends FindIsland {

  public FindIsland2(IVerifier v) {
    super(v);
  }

  @Override
  public int NumIslands(Integer[][] g) {
    int[][] v = new int[g.length][g[0].length];
    int c = 0;
    for (int iy = 0; iy < g[0].length; iy++) {
      for (int ix = 0; ix < g.length; ix++) {
        if (g[ix][iy] == 1 && v[ix][iy] != 1) {
          c++;
          df(g, ix, iy, v);
        }
        v[ix][iy] = 1;

      }
    }
    return c;
  }

  public void df(Integer[][] g, int x, int y, int[][] v) {
    if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || v[x][y] == 1 || g[x][y] != 1) {
      return;
    }
    v[x][y] = 1;   // mistake:  don't mark grid at the end will cause stack overflow
    df(g, x - 1, y, v);
    df(g, x + 1, y, v);
    df(g, x, y - 1, v);
    df(g, x, y + 1, v);
  }
}

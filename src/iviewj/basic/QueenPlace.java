package iviewj.basic;

import iviewj.IVerifier;
import iviewj.TestBase;

public class QueenPlace extends TestBase {

  private int[][] grid;

  public QueenPlace(IVerifier v) {
    super(v);
    grid = new int[8][8];
  }

  public int check(int ir, int ic, int qr, int qc) {
    int r = qr + ir;
    int c = qc + ic;

    if (r < 0 || r > 7 || c < 0 || c > 7)
      return -1;
    w("cord:" + r + " " + c);

    if (grid[r][c] == 2)
      return 2;
    else
      return 1;
  }

  public void walkDir(int qr, int qc, int ir, int ic) {
    int i = 0;
    int r = 0, c = 0;
    int v;
    while ((v = check(r, c, qr, qc)) != -1) {
      if (v == 2)
        break;

      i++;
      r = r + ir;
      c = c + ic;
    }
    w("steps=" + i);
  }

  public void addObstacle(int r, int c) {
    grid[r][c] = 2;
  }
}

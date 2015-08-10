package iviewj;

public class TicTacToe extends TestBase {

  public TicTacToe(IVerifier v) {
    super(v);
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        tttboard[r][c] = -99;
      }
    }
  }

  public Integer[][] tttboard = new Integer[3][3];
  // pick a number such that we can tell by just summing up

  public int Move(int r, int c, int piece) {
    if (tttboard[r][c] != -99) {
      return -1;
    }
    tttboard[r][c] = piece;
    Eval();
    return 1;
  }

    // 0 = draw
  // 1 = circle won
  // 2 = cross won
  // caveat:  looping 2 dimensional array always simulate with a pen first
  public int Eval() {
    int i = 0;
    int[] rowsum = new int[3];
    int colSum;
    int winner = 0; // no winner
    for (int c = 0; c < 3; c++) {
      colSum = 0;
      for (int r = 0; r < 3; r++) // notices inner loop is row, but the sum we get is actually col sum
      {
        colSum = colSum + tttboard[r][c];

        rowsum[r] = rowsum[r] + tttboard[r][c]; // avoid looping twice if we cache the row sum
      }
      winner = CheckWinner(colSum);  // pitfall:  only check winner when col sum is calculated
      if (winner != 0) {
        return winner;
      }
    }

    for (i = 0; i < rowsum.length; i++) {
      winner = CheckWinner(rowsum[i]);
      if (winner != 0) {
        return winner;
      }
    }
    return 0;

  }

    // check for see who is winnder
  // 1 = circle
  // 2 = cross
  // 0 = none
  public int CheckWinner(int sum) {
    if (sum == 3) {
      w("Circle wins");
      return 1;
    } else if (sum == 0) {
      w("Cross wins");
      return 2;
    } else {
      w("nobody wins");
      return 0;
    }

  }

  public void PrintBoard() {
    for (int c = 0; c < 3; c++) {
      for (int r = 0; r < 3; r++) {
        w(tttboard[r][c] + "   ");
      }
      w("");
    }
  }

  public void Test1() {
    TicTacToe ttt = new TicTacToe(verifier);
    ttt.Move(0, 0, 1);
    ttt.Move(1, 0, 1);
    ttt.Move(2, 0, 1);
    ttt.PrintBoard();

    ttt = new TicTacToe(verifier);
    ttt.Move(0, 0, 0);
    ttt.Move(1, 0, 0);
    ttt.Move(2, 0, 0);
    ttt.PrintBoard();
  }
}

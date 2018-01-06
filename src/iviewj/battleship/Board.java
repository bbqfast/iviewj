package iviewj.battleship;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
  public static final String SHIPDISPLAY = "s";
  public static final String ATTACKEDDISPLAY = "x";
  public static final String EMPTYDISPLAY = ".";

  public static final int SHIP = 1;
  public static final int ATTACKED = 2;
  public static final int EMPTY = 0;
  
  public enum State {
    HIT,
    MISS,
    NONE
  }
  
  private int[][] board;
  private int shipSquareCount = 0;
  private int width;
  private int height;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    board = new int[height][width];
  }

  public State set(int row, int col, int val) {
    State result = State.NONE;
    if (val == ATTACKED && board[row][col] == EMPTY) 
      return State.MISS;
    if (val == ATTACKED && board[row][col] == SHIP)
      result = State.HIT;
    if (board[row][col] == EMPTY && val == SHIP)
      shipSquareCount++;
    if (board[row][col] == SHIP && val != SHIP)
      shipSquareCount--;

    board[row][col] = val;
    return result;
  }
  
  protected Boolean withinBoard(int r, int c) {
    return r >= 0 && r < this.height && c >= 0 && c < this.width;
  }
  
  protected boolean placeShip(Point start, Point vector, int shipLength) {
    int r = start.row;
    int c = start.col;
    
    ArrayList<Point> ship = new ArrayList<>();
    for (int i = 0; i < shipLength; i++) {
      if (!withinBoard(r,c) || this.get(r, c) != Board.EMPTY)
        return false;

      ship.add(new Point(r, c));
      r = r + vector.row;
      c = c + vector.col;
    }
    
    for (Point p:ship) // actually place it if no blockage
      this.set(p.row, p.col, Board.SHIP);
    return true;
  }  

  public int count() {
    return shipSquareCount;
  }

  public int get(int row, int col) {
    return board[row][col];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void print() {
    for (int r = 0; r < this.height; r++) {
      StringBuffer line = new StringBuffer();
      for (int c = 0; c < this.width; c++) {
        if (board[r][c] == SHIP)
          line.append(SHIPDISPLAY);
        else if (board[r][c] == ATTACKED)
          line.append(ATTACKEDDISPLAY);
        else
          line.append(EMPTYDISPLAY);
      }
      System.out.println(line.toString());
    }
  }
  
  public void printForOpponent() {
    for (int r = 0; r < this.height; r++) {
      StringBuffer line = new StringBuffer();
      for (int c = 0; c < this.width; c++) {
        if (board[r][c] == ATTACKED)
          line.append(ATTACKEDDISPLAY);
        else
          line.append(EMPTYDISPLAY);
      }
      System.out.println(line.toString());
    }
  }
}

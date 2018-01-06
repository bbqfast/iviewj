package iviewj.battleship;

import java.util.Random;

public abstract class Player {
  public enum Orientation {
  HORIZONTAL, VERTICAL
  }

  protected String name;
  protected Board board;
  private Random rand = new Random();

  public Player(String name, Board board) {
    this.name = name;
    this.board = board;
  }

  protected Point pickRandomPoint() {
    int r, c;
    r = rand.nextInt(board.getHeight());
    c = rand.nextInt(board.getWidth());
    return new Point(r, c);
  }

  protected void place(Board b, Point start, Point vector, int shipLength) {
    int r = start.row;
    int c = start.col;
    for (int i = 0; i < shipLength; i++) {
      if (b.get(r, c) != Board.EMPTY)
        throw new RuntimeException("Ship cannot be overlap");

      b.set(r, c, Board.SHIP);
      r = r + vector.row;
      c = c + vector.col;
    }
  }

  public boolean placeShip(Board b, Point start, int shipLength, Orientation orient) {
    if (orient == Orientation.HORIZONTAL)
      return board.placeShip(start, new Point(0, 1), shipLength);
    else
      return board.placeShip(start, new Point(1, 0), shipLength);
  }

  public void layoutShipsFixed() {
    placeShip(board, new Point(7, 9), 2, Orientation.VERTICAL);
    placeShip(board, new Point(1, 1), 3, Orientation.HORIZONTAL);
    placeShip(board, new Point(4, 0), 4, Orientation.HORIZONTAL);
    placeShip(board, new Point(1, 9), 5, Orientation.VERTICAL);
  }

  public void placeRandomShip(int shipLength) {
    boolean placed = false;
    do {
      Point p = pickRandomPoint();
      Orientation orient = rand.nextInt(2)==1 ? Orientation.HORIZONTAL : Orientation.VERTICAL; 
      placed = placeShip(board, p, shipLength, orient);
    } while (!placed);
  }
  
  public void layoutShips() {
    placeRandomShip(2);
    placeRandomShip(3);
    placeRandomShip(4);
    placeRandomShip(5);
  }

  public String getName() {
    return name;
  }

  public Board.State AttackedAt(Point p) {
    return board.set(p.row, p.col, Board.ATTACKED);
  }

  public Boolean isLost() {
    return board.count() == 0;
  }

  public void showBoard() {
    System.out.println(name + "'s board:");
    board.print();
  }

  public void showForOpponent() {
    System.out.println("Hit statistics");
    board.printForOpponent();
  }

  public Board.State attack(Player other, Point at) {
    return other.AttackedAt(at);
  }

  public Point move() {
    throw new UnsupportedOperationException("not implemented");
  }
}

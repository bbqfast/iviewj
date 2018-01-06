package iviewj.battleship;

import java.util.HashSet;
import java.util.Random;

public class Computer extends Player {
  private HashSet<String> played = new HashSet<>();
  private Random rand = new Random();
  
  public Computer(String name, Board board) {
    super(name, board);
  }
  
  protected String toKey(int row, int col) {
    return row + "." + col;
  }
  
  protected Point pickRandom() {
    int r, c;
    Point p;
    do {
      p = pickRandomPoint();
    } while (played.contains(toKey(p.row, p.col)));
    return p;
  }
  
  public Point move() {
    // simple optimization 
    // this cuts down # of turns by 3x vs a pure random without repeat check
    Point p = pickRandom();
    played.add(toKey(p.row, p.col));
    System.out.println("played=" + played.size());
    return p;
  }
}

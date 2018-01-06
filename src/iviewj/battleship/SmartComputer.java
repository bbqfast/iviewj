package iviewj.battleship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

// Experimental
// 
// A simple optimization based on the fact that if a ship is found
// its more likely to find the rest of the ship parts on nearby squares
// 
// I tweaked the random pick to biased toward radius around past successful attacks
// This algorithm has a win ratio of 9:1 against regular Computer player
public class SmartComputer extends Computer {
  HashSet<String> played = new HashSet<>();
  ArrayList<Point> pastSuccess = new ArrayList<>();
  Random rand = new Random();

  public SmartComputer(String name, Board board) {
    super(name, board);
  }

  protected int safeRandom(int p, int radius, int max) {
    int sign = rand.nextInt(2)==1 ? 1 : -1;
    int r;
    do {
      r = p + (rand.nextInt(radius) * sign);
    } while (r < 0 || r >= max);
    return r;
  }

  protected Point pickAroundPastSuccess() {
    Point p;
    int radius = 1;

    do {
      p = pickRandom();
      for (Point x : pastSuccess) {
        int r, c;
        r = safeRandom(x.row, radius, board.getHeight());
        c = safeRandom(x.col, radius, board.getWidth());
        p = new Point(r, c);
        radius++;
      }
      if (radius>10)
        radius=10;
    } while (played.contains(toKey(p.row, p.col)));
    return p;
  }

  public Point move() {
    Point p = pickAroundPastSuccess();
    played.add(toKey(p.row, p.col));
    System.out.println("played=" + played.size());
    return p;
  }

  public Board.State attack(Player other, Point at) {
    Board.State result = other.AttackedAt(at);
    if (result == Board.State.HIT) {
      pastSuccess.add(at);
    }
    return result;
  }
}

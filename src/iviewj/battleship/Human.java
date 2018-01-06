package iviewj.battleship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Human extends Player {
  private Pattern movePattern = Pattern.compile("([a-z]+)([0-9]+)");
  private Input input;
  public static String PROMPT = "Enter move with chess notation (ex: b1):";
  

  public Human(String name, Board board) {
    super(name, board);
    input = new Input();
  }

  private Point parseInput(String s) {
    Matcher m = movePattern.matcher(s.toLowerCase());
    int row = -1;
    int col = -1;
    if (m.matches()) {
      row = Integer.parseInt(m.group(2)) - 1;
      col = m.group(1).charAt(0) - 'a';
    }
    return new Point(row, col);
  }

  private boolean withinBoard(Point p) {
    if (p.row < 0 || p.row > board.getHeight() -1 || p.col < 0 || p.col > board.getWidth() - 1)
      return false;
    else
      return true;
  }
  
  public Point move() {
    Point move;
    do {
      String moveStr = input.getinput(PROMPT);
      move = parseInput(moveStr);
    } while (!withinBoard(move));
    return move;
  }
}

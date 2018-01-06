package iviewj.battleship;

import java.util.Scanner;

public class Input {
  @SuppressWarnings("resource") // should not close console.in
  public String getinput(String prompt) {
    String s;
    System.out.println(prompt);
    Scanner in = null;
    in = new Scanner(System.in);
    s = in.next();
    return s;
  }
}

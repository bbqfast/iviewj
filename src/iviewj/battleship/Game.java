package iviewj.battleship;

import iviewj.battleship.Board.State;

public class Game {
  public void showMove(Player player, Point m) {
    System.out.println(player.getName() + "'s move row:" + m.row + " col:" + m.col);
  }

  public void showTurn(Player p) {
    System.out.println("***************" + p.name + "'s turn *****************");
  }

  public void showResult(Board.State result) {
    if (result == State.HIT)
      System.out.println("Its a HIT !!!");
    else
      System.out.println("Its a MISS");
  }

  public void attackOther(Player attacker, Player defender) {
    showTurn(attacker);
    attacker.showBoard();
    Point p1Move = attacker.move();
    showMove(attacker, p1Move);
    Board.State result = attacker.attack(defender, p1Move);
    showResult(result);
    defender.showForOpponent();
    System.out.println("");
  }

  public void loopPlayers(Player player1, Player player2) {
    player1.layoutShips();
    player2.layoutShips();

    int totalTurns = 0;
    while (!player1.isLost() && !player2.isLost()) {
      attackOther(player1, player2);
      if (player2.isLost())
        break;
      attackOther(player2, player1);
      totalTurns++;
    }

    Player winner = !player1.isLost() ? player1 : player2;

    System.out.println("Winner is " + winner.getName());
    System.out.println("Total turns " + totalTurns);
  }

  public void ComputerVsComputer() {
    Player player1 = new Computer("Computer", new Board(10, 10));
    Player player2 = new SmartComputer("Smart computer", new Board(10, 10));
    loopPlayers(player1, player2);
  }

  public void HumanVsComputer() {
    Player player1 = new Human("Human", new Board(10, 10));
    Player player2 = new Computer("Computer", new Board(10, 10));
    loopPlayers(player1, player2);
  }

  public static void main(String[] args) {
    System.out.println("Welcome to battle ship!");
    Input input = new Input();
    Game game = new Game();

    String in = input.getinput("[h]uman vs computer, [s]mart computer vs computer.  Default [h]");

    if (in.equals("s"))
      game.ComputerVsComputer();
    else
      game.HumanVsComputer();
    System.out.println("Thanks for playing!");
  }
}

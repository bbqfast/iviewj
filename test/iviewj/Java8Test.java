/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iviewj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Java8Test {

  @Before
  public void setUp() {
  }

  @Test
  public void testFsi() {
    String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
    List<String> players = Arrays.asList(atp);

// Old looping
//    for (String player : players) {
//      System.out.print(player + "; ");
//    }

// Using lambda expression and functional operations
    players.forEach((player) -> System.out.print(player + ";;;; "));
  }
  
  @Test
  public void sort() {
    String[] players = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner"};
//    Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
//
//    Arrays.sort(players, sortByName);
    // or this
    Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
    
    for (String p : players)
      System.out.println(p);
  }
}

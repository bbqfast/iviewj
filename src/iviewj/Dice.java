package iviewj;

import GDC.*;
import java.util.Random;

/// <summary>
/// Question:
/// Implements a function that simulate a dice toss
/// You need to guarantee that you get equal chances for each number we thrown
///
/// </summary>
public class Dice extends TestBase {

  public Dice(IVerifier v) {
    super(v);
  }
  int fullflag = 0;

  int[] count = new int[7];
  Random rand = new Random();

  // helper
  public void ClearCount() {
    for (int i = 0; i < map.length; i++) {
      count[i] = 0;
    }
  }

    // helper
  // print count for # of times each number rolled
  public void PrintCount() {
    for (int i = 0; i < map.length; i++) {
      w("count[" + i + "] = " + count[i]);;
    }
  }

  public void Init() {
    w("Reset");
    max = 6;
    for (int i = 0; i < map.length; i++) {
      map[i] = i;
      dist[i] = 0;
    }
  }

  public int RandFunc(int max) {
    int r = (rand.nextInt() % max) + 1;
    return r;
  }

  int cap = 10; // max occurrance of a rolled num
  int max = 6; // dice max is 6
  int[] dist = new int[7]; // distribution table
  int[] map = new int[7];  // map random number into dice number

    // Improve efficiency by mapping random result
  // everytime when r hit the distribution capacity, we shrink the random set by one
  // and adjust the map so we still produce the disired dice number
  public int Roll() {
    int r;
    while (dist[r = map[RandFunc(max)]] >= cap) {
      if (r != max) {
        map[r] = map[max];
      }
      max--; // dec max after swapping with map[max]
      if (max == 0) {
        Init();
      }
    }
    dist[r]++;
    return r;
  }

    // using a flag to check if distribution is full, such that we reset the distribution table
  // 111111 = 63
  public int Roll0() {
    int r;
    while (dist[r = RandFunc(6)] >= cap) {
      fullflag = fullflag | (1 << (r - 1));
      w("ff=" + fullflag);
      if (fullflag == 63) {
        fullflag = 0;
        this.Init();
      }
    }
    dist[r]++;
    return r;
  }

  public void Test1() {
    this.ClearCount();
    this.Init();
    for (int i = 0; i <= ((cap) * 6); i++) {
      int r = this.Roll();
      count[r]++;
      w("roll=" + r);
    }
    this.PrintCount();

  }
}

package iviewj;

import GDC.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CircularLinkedListLoopHeadTest {

  CircularLinkedListLoopHead instance;

  public CircularLinkedListLoopHeadTest() {
  }

  @Before
  public void setUp() {
    instance = new CircularLinkedListLoopHead(new TestVerifier());
  }

  @Test
  public void has7node() {
    System.out.println("findLoopHead");
    instance.TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 4);
  }

  @Test
  public void has8nodeLoop4() {
    System.out.println("findLoopHead");
    instance.TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 5);
  }

  @Test
  public void has8nodeLoop5() {
    System.out.println("findLoopHead");
    instance.TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 4);
  }

  @Test
  public void wholeLoop() {
    System.out.println("findLoopHead");
    instance.TestInput(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 1);
  }

}

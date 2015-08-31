package iviewj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueWith2StacksTest {
  QueueWith2Stacks instance;
  public QueueWith2StacksTest() {
  }
  
  @Before
  public void setUp() {
    instance = new QueueWith2Stacks(new TestVerifier());
  }
  
  @Test
  public void testEnqueue() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput();
  }
}

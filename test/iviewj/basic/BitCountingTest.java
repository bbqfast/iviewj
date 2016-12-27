package iviewj.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iviewj.TestHelper;
import iviewj.TestVerifier;
import iviewj.basic.BitCounting;

import static org.junit.Assert.*;

public class BitCountingTest {
  BitCounting instance;
  
  public BitCountingTest() {
  }
  
  @Before
  public void setUp() {
    instance = new BitCounting(new TestVerifier());
  }

  @Test
  public void zeroBit() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(0, 0);
  }

  @Test
  public void three() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(3, 2);
  }

  @Test
  public void oneBit() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(1, 1);
  }
  
  @Test
  public void is16Bit() {
    System.out.println(TestHelper.getMethodName(2));
    instance.TestInput(65535, 16);
  }
}

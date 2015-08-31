package iviewj;

import java.util.Stack;

public class QueueWith2Stacks extends TestBase {
  Stack<Integer> a = new Stack<Integer>(); 
  Stack<Integer> b = new Stack<Integer>(); 
  
  public QueueWith2Stacks(IVerifier v)  
  {
    super(v);
    a = new Stack<Integer>();
  }
  
  public void enqueue(int d)
  {
    a.push(d);
  }
  
  public int dequeue()
  {
    if (a.isEmpty() && b.isEmpty())
      return -1;
    
    if (!b.isEmpty())
      return b.pop();
    else
    {
      while (!a.empty())
        b.push(a.pop());
      return b.pop();
    }
  }  
  
  public void TestInput()
  {
    enqueue(1);
    enqueue(2);
    enqueue(3);
    verifier.Verify("dequeue", 1, dequeue()); 
    verifier.Verify("dequeue", 2, dequeue()); 
    enqueue(4);
    enqueue(5);
    verifier.Verify("dequeue", 3, dequeue()); 
    verifier.Verify("dequeue", 4, dequeue()); 
    verifier.Verify("dequeue", 5, dequeue()); 
    verifier.Verify("dequeue", -1, dequeue()); 
  }
}

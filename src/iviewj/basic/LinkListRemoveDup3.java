package iviewj.basic;

import GDC.*;
import iviewj.IVerifier;

public class LinkListRemoveDup3 extends LinkListRemoveDup {

  public LinkListRemoveDup3(IVerifier v) {
    super(v);
  }

  @Override
  public void RemoveDup(Node head) {
    Node last, p1=head;
    Node p2 = p1.next;
    
    while (p1 != null && p1.next != null)    
    {
      last = p1;
      p2 = p1.next;
      while (p2 != null)
      {
        if (p2.data == p1.data)
        {
          last.next = p2.next;
        }
        else
        {
          last = p2;
        }
        p2 = p2.next;
      } // p2
      p1 = p1.next;
    }
  }
}

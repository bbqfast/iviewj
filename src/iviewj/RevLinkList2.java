package iviewj;

import GDC.*;

public class RevLinkList2 extends RevLinkList {

  public RevLinkList2(IVerifier v) {
    super(v);
  }

  public Node Reverse(Node head) {
    Node t, n=head, p=null;
    
    while (n != null)
    {
      t = n.next;
      n.next = p;
      p = n;
      n = t;
    }
    
    return p;
  }
}

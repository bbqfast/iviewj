package iviewj;
import GDC.*;

public class RevLinkList2 extends RevLinkList
    {
    public RevLinkList2(IVerifier v)
    {
      super(v);
    }
    
    // use of 3 variable
    // cursor
    // last - remember last node when cursor advance
    // next - remember next node when cur.next is twisted to point to last
    public Node Reverse(Node head)
    {
        Node p = null;
        Node t = null;
        Node c = head;

        // mistake:  tmp should assign to .next because .next will be modified
        while ( c != null)
        {
            t = c.next;
            c.next = p;
            p = c;
            c = t;
        }
        return p;
    }
}

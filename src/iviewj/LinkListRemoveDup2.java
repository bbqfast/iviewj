package iviewj;
import GDC.*;

public class LinkListRemoveDup2 extends LinkListRemoveDup {
    public LinkListRemoveDup2(IVerifier v)
    {
      super(v);
    }
    
    @Override
    public void RemoveDup(Node head) {
        Node i = head;
        Node j = head;
        
        while (i != null)
        {
            Node p = i;
            j = i.next;
            
            while ( j != null)
            {
                if (j.data == i.data )
                {
                    p.next = j.next;
                    j = j.next;
                    continue;
                }
                p = j;
                j = j.next;
            }
            i = i.next;
        }
    }
}

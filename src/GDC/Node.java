package GDC;
import java.lang.*;

public class Node
    {
            public Node next;
            public Integer data;
    public Node()
    {
        Integer[] xx = {0,1,2};
    }

    public Node(Integer _data)
    {
        data = _data;
    }

    public String ToString()
    {
        String buf="";
        Node cur=this;
        while (cur != null)
        {
            buf+=cur.data+", ";
            cur=cur.next;
        }
        return buf;
    }
}

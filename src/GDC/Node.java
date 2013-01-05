package GDC;

public class Node
    {
            public Node next;
            public int data;
    public Node()
    {
    }

    public Node(int _data)
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

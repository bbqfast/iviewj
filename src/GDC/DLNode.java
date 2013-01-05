package GDC;

public class DLNode
{
    public DLNode next;
    public DLNode prev;

    public int data;
    public String ToString()
    {
        String buf = "";
        DLNode cur = this;
        while (cur != null)
        {
            buf += cur.data + ", ";
            cur = cur.next;
        }
        return buf;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iviewj;

/**
 *
 * @author alan.chung
 */
public class Utils
{
    public Utils()
    {
    }

    public static String PrintArray(String desc, int[] a)
    {
        StringBuilder buf = new StringBuilder();
        buf.append(desc + " ");
        for (int i = 0; i < a.length; i++)
        {
            buf.append(a[i] + ", ");
        }
        return buf.toString();
    }


//
//        public static Node ArrayToLinkList(int[] elements)
//    {
//        Node prev = new Node();
//        Node head = prev;
//        foreach (int e in elements)
//        {
//            Node n = new Node();
//            n.data = e;
//            prev.next = n;
//            n.next = null;
//            prev = n;
//        }
//        head = head.next;
//        return head;
//    }



}

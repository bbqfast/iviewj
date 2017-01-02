/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iviewj;

import GDC.*;
import java.awt.Point;
import java.util.*;

/**
 *
 * @author alan.chung
 */
public class Utils {

  public Utils() {
  }

  public static void Swap(Integer[] a, int i, int j) {
    Integer t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void Swap(String[] a, int i, int j) {
    String t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static Node ArrayToLinkList(Integer[] elements) {
    Node prev = new Node();
    Node head = prev;

    for (int i = 0; i < elements.length; i++) {
      Node n = new Node();
      n.data = elements[i];
      prev.next = n;
      n.next = null;
      prev = n;
    }
    head = head.next;
    return head;
  }

  public static Integer[] LinkListToArray(Node n) {
    ArrayList<Integer> a = new ArrayList<Integer>();

    // IntArray a = new IntArray();
    for (Node c = n; c != null; c = c.next) {
      a.add(c.data);
    }

    Integer[] intarray = new Integer[a.size()];
    a.toArray(intarray);
    return intarray;
  }

  public static boolean MatchArray(Integer[] a, Integer[] b) {
    boolean match = true;
    StringBuilder astr = new StringBuilder();
    StringBuilder bstr = new StringBuilder();
    if (a.length != b.length) {
      return false;
    } else {
      for (int i = 0; i < a.length; i++) {
        if (a[i] != b[i]) {
          match = match && false;
          astr.append("{" + a[i] + "}" + ",");
          bstr.append("{" + b[i] + "}" + ",");
        } else {
          astr.append(a[i] + ",");
          bstr.append(b[i] + ",");
        }
      }
    }

    w("a:" + astr.toString());
    w("b:" + bstr.toString());
    return match;
  }

  public static boolean MatchArray(String[] a, String[] b) {
    boolean match = true;
    StringBuilder astr = new StringBuilder();
    StringBuilder bstr = new StringBuilder();
    if (a.length != b.length) {
      return false;
    } else {
      for (int i = 0; i < a.length; i++) {
        if (!a[i].equals(b[i])) {
          match = match && false;
          astr.append("{" + a[i] + "}" + ",");
          bstr.append("{" + b[i] + "}" + ",");
        } else {
          astr.append(a[i] + ",");
          bstr.append(b[i] + ",");
        }
      }
    }

    w("a:" + astr.toString());
    w("b:" + bstr.toString());
    return match;
  }

  public static String PrintArray(String desc, Integer[] a) {
    StringBuilder buf = new StringBuilder();
    buf.append(desc + " ");
    for (int i = 0; i < a.length; i++) {
      buf.append(a[i] + ", ");
    }
    return buf.toString();
  }

  public static String PrintArray(String desc, String[] a) {
    StringBuilder buf = new StringBuilder();
    buf.append(desc + " ");
    for (int i = 0; i < a.length; i++) {
      buf.append(a[i] + ", ");
    }
    return buf.toString();
  }

  public static String PrintArray(String desc, char[] a) {
    StringBuilder buf = new StringBuilder();
    buf.append(desc + " ");
    for (int i = 0; i < a.length; i++) {
      buf.append(a[i] + ", ");
    }
    return buf.toString();
  }

  public static String PrintArray(String desc, Point[] a) {
    StringBuilder buf = new StringBuilder();
    buf.append(desc + " ");
    for (int i = 0; i < a.length; i++) {
      String ps = "(" + a[i].x + "," + a[i].y + ")";
      buf.append(ps + ", ");
    }
    return buf.toString();
  }

  public static void PrintLinkList(Node n) {
    // f("PrintLinkList");
    Node c = n;
    while (c != null) {
      ww(c.data + " ,");
      c = c.next;
    }
    w("");
  }

  public static void Insert(TNode[] n, Integer[] d) {
    for (int i = 0; i < d.length; i++) {
      Insert(n, d[i]);
    }
  }

  public static void Insert(TNode[] n, int d) {
    if (n == null) {
      n[0] = new TNode(d);
    } else {
      TNode[] left = new TNode[] { n[0].left };
      TNode[] right = new TNode[] { n[0].right };
      if (d < n[0].Data) {
        Insert(left, d);
      } else {
        Insert(right, d);
      }
    }
  }

  public static void PrintTree(TNode root, String space) {
    if (root == null) {
      return;
    }
    PrintTree(root.left, space + " ");
    w(space + root.Data);
    PrintTree(root.right, space + " ");
  }

  public static void PrintTreePost(TNode root, String space) {
    if (root == null) {
      return;
    }
    PrintTreePost(root.left, space + " ");
    PrintTreePost(root.right, space + " ");
    w(space + root.Data);
  }

  public static void Print2DArray(Integer[][] g) {
    for (int y = 0; y < g[0].length; y++) {
      StringBuilder buff = new StringBuilder();
      for (int x = 0; x < g.length; x++) {
        buff.append(g[x][y]);
      }
      w(buff.toString());
    }
  }

  public static void ww(String line) {
    System.out.print(line);
  }

  public static void w(String line) {
    System.out.println(line);
  }

  public static void f(String line) {
    System.out.println("---------- " + line + "-------------");
  }

  public static void Inorder(TNode root, String space) {
    if (root == null) {
      return;
    }
    Inorder(root.left, space + " ");
    w(space + root.Data);
    Inorder(root.right, space + " ");
  }
  //
  // public static Node ArrayToLinkList(int[] elements)
  // {
  // Node prev = new Node();
  // Node head = prev;
  // foreach (int e in elements)
  // {
  // Node n = new Node();
  // n.data = e;
  // prev.next = n;
  // n.next = null;
  // prev = n;
  // }
  // head = head.next;
  // return head;
  // }
}

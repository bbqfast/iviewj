package iviewj.company;

import java.util.HashMap;
import java.util.LinkedList;

import iviewj.IVerifier;
import iviewj.TestBase;

public class LRU extends TestBase{
  node top;
  public LRU(IVerifier v) {
    super(v);
  }

  public static class node {
    public node(node prev, node next, String data) {
      super();
      this.next = next;
      this.prev = prev;
      this.data = data;
    }
    public node next;
    public node prev;
    String data;
  }
  
  int a=6;
  LinkedList<Integer> list = new LinkedList<>(); 
  HashMap<Integer,node> hash = new HashMap<>();
  
  public node addTop(String d) {
    node n = new node(null, top, d);
    if (top != null)
      top.prev =n ;
    top = n;
    return n;
  }
  
  public String lru() {
    node h = top;
    StringBuffer sb = new StringBuffer("");
    while (h != null) {
      sb.append(h.data + "-");
      h = h.next;
    }
    System.out.println("lru:" + sb.toString());
    return sb.toString();
  }
  
  
  public void moveTop(node dn) {
    if (dn == top) 
      return;
    // detach
    if (dn.prev != null)
      dn.prev.next = dn.next;
    if (dn.next != null)
      dn.next.prev = dn.prev;
    dn.next = top;
    top.prev = dn;   // mistake:  old top prev=null, need to relink to new top
    dn.prev = null;
    top = dn;
  }
  
  public node detach(node dn) {
    if (dn.prev != null)
      dn.prev.next = dn.next;
    if (dn.next != null)
      dn.next.prev = dn.prev;
    return dn;
  }
  
  public String get(int k) {
    node dn = hash.get(k);
    System.out.println("get  " + dn.data);
    moveTop(dn);
     
    return dn.data;
  }

  public void set(int key, String value) {
    node dn = addTop(value);
    hash.put(key, dn);
    list.add(key);
    return;
  }
  
  public void remove(int key) {
    node dn = hash.get(key);
    if (dn == top)
      top = dn.next;  
    detach(dn);
    hash.remove(key);
  }
}

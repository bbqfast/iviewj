package iviewj.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import GDC.TNode;
import iviewj.IVerifier;
import iviewj.TestBase;

public class TreePrintLevel extends TestBase {
  public TreePrintLevel(IVerifier v) {
    super(v);
  }

  public List<String> printLevels(TNode r) {
    ArrayList<String> lines = new ArrayList<>();
    Queue<TNode> q = new LinkedList<>();
    int cnt = 0;
    q.add(r);
    StringBuffer sb = new StringBuffer();

    while (!q.isEmpty()) {
      StringBuffer line = new StringBuffer();
      cnt = q.size();
      while (cnt != 0) {
        TNode x = q.remove();

        // sb.append(x + ",");
        line.append(x.Data + ",");
//        System.out.print(x.Data + ", ");
        // System.out.println(q.size());
        if (x.left != null)
          q.add(x.left);
        if (x.right != null)
          q.add(x.right);
        cnt --;
      }
//      System.out.println();
      lines.add(line.toString());
    }
    
    return lines;
  }
}

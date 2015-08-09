package iviewj;
import GDC.*;

public class LinkListRemoveDup extends TestBase {
    public LinkListRemoveDup(IVerifier v)
    {
      super(v);
    }
    
    public void RemoveDup(Node head) {
        if (head == null) {
            return;
        }
        Node previous = head;
        Node current = previous.next;
        while (current != null) {
            Node runner = head;
            while (runner != current) { // Check for earlier dups
                if (runner.data == current.data) {
                    Node tmp = current.next; // remove current
                    previous.next = tmp;
                    current = tmp; // update current to next node
                    break; // all other dups have already been removed
                }
                runner = runner.next;
            }
            if (runner == current) { // current not updated - update now
                previous = current;
                current = current.next;
            }
        }
    }

    protected void TestInput(Integer[] input, Integer[] expected)
    {
        w(Utils.PrintArray("Input", input));
        Node[] inputList = new Node[1];
        inputList[0] = Utils.ArrayToLinkList(input);
        RemoveDup(inputList[0]);
        Integer[] result = Utils.LinkListToArray(inputList[0]);
        w(Utils.PrintArray("result", result));

        Verify("Match", result, expected);
    }


    public void Test1()
    {
        TestInput(new Integer[] { 2, 3, 2, 2, 4, 4 },
            new Integer[] { 2, 3, 4 });

        TestInput(new Integer[] { 1, 2, 3, 1, 2, 3 },
            new Integer[] { 1, 2, 3 });


    }


}

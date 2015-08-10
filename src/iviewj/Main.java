package iviewj;

import javax.management.OperationsException;
import GDC.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws OperationsException {
        // TODO code application logic here
        IVerifier v = new Verifier();
        System.out.println("aaa");
        Run(new MaxSum(v));
        Run(new LongestCommonSubsequence(v));
        Run(new RevLinkList2(v));
        // Run(new TicTacToe());
        // Run(new PermutationSimple2());
        // Run(new Heap());
        // Run(new SortLinkList2());
        // Run(new Atoi2());
        // Run(new BinarySearch());
        // Run(new RebuildTree());
//        Run(new A1a2a3_2(v));
        // Run( new Sorting2());
        // Run( new TreeTraverseNoRecursion());
        // Run ( new BinarySearch2());
        // Run ( new FindShiftedArray());
        // Run (new Heap2());
        // Run (new BitCounting2());
        // Run (new LinkListRemoveDup2());
        // Run (new StrStr());
        // Run ( new RevSentence());
        // ReverseSentence rs = new ReverseSentence();
        // Run( new PermutationSimple2());
        // Run( new StrRemoveDups());
        // Run ( new StrReplaceInPlace());
        // rs.Test();
        //TNode.test();
    }

    public static void Run(TestBase t) throws OperationsException {
        t.Test1();
    }
}

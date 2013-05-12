package iviewj;

import javax.management.OperationsException;
import java.util.*;
import GDC.*;

public class BSTFromPreOrder extends TestBase
{
    TNode constructTreeUtil (int pre[], int[] preIndex, int low, int high, int size)
    {
        // Base case
        if (preIndex[0] >= size || low > high)
            return null;

        // The first node in preorder traversal is root. So take the node at
        // preIndex from pre[] and make it root, and increment preIndex
        // struct node* root = newNode ( pre[*preIndex] );
        TNode root = new TNode( pre[preIndex[0]] );
        preIndex[0] = preIndex[0] + 1;

        // If the current subarry has only one element, no need to recur
        if (low == high)
            return root;

        // Search for the first element greater than root
        int i;
        for ( i = low; i <= high; ++i )
            if ( pre[ i ] > root.Data )
                break;
     // Use the index of element found in postorder to divide postorder array in
        // two parts. Left subtree and right subtree
        root.left = constructTreeUtil ( pre, preIndex, preIndex[0], i - 1, size );
        root.right = constructTreeUtil ( pre, preIndex, i, high, size );

        return root;
    }

    TNode ConstructTree (int pre[], int size)
    {
        int []preIndex = new int[1];
        preIndex[0] = 0;
        return constructTreeUtil(pre, preIndex, 0, pre.length - 1, pre.length);
    }

    public void TestInput(int n, int expected)
    {
        int[] preArr = { 4, 2, 1, 3, 8, 6, 5, 7, 9 };
        int[] inArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        RebuildTree rt = new RebuildTree();
        TNode root = rt.Rebuild(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1);
        
            // Verify("countBits", expected, cnt);
    }

    @Override
    public  void Test1()
    {
    }
}

package iviewj;

import GDC.*;


// Given a pre-order traversal of a binary tree in an array
// Given an In-order tranversal of a binary tree in an array
// Rebuild the tree based on the 2 array, its not necessary a sorted binary tree
public class RebuildTree extends TestBase
{
    public TNode Rebuild(int []preArr, int pb, int pe, int []inArr, int ib, int ie)
    {
        int rootElem = preArr[pb];
        TNode newRoot = new TNode();
        newRoot.Data = preArr[pb];

        int []leftEnd = new int[1];
        int []rightStart = new int[1];

        int midIdx = SplitInArr(inArr, ib, ie, rootElem, leftEnd, rightStart);
        if (midIdx + ib != ib) // has left subtree?
            newRoot.left = Rebuild(preArr, pb + 1, pb + midIdx, inArr, ib, leftEnd[0]);
        if (midIdx + ib != ie) // has right subtree?
            newRoot.right = Rebuild(preArr, pb + 1 + midIdx, pe, inArr, rightStart[0], ie);
        return newRoot;
    }

    private int SplitInArr(int[] inArr, int ib, int ie, int midElem, int []leftEnd, int []rightStart)
    {
        int i=ib;
        for (i = ib; i <= ie; i++)
        {
            if (inArr[i] == midElem)
                break;
        }
        leftEnd[0] = i - 1;
        rightStart[0] = i + 1;
        return i - ib; // size
    }

    public void Preorder(TNode root)
    {
        if(root==null) return;
        w(root.Data.toString());
        Preorder(root.left);
        Preorder(root.right);
    }

    public void Inorder(TNode root, String space)
    {
        if (root == null) return;
        Inorder(root.left, space + " ");
        w(space + root.Data);
        Inorder(root.right, space + " ");
    }



    public int TreeHeight(TNode root)
    {
        if (root == null)
            return 0;
        return Math.max(1 + TreeHeight(root.left), 1 + TreeHeight(root.right));
    }

    @Override
    public void Test1()
    {
        //int []preArr = {4,2,1,3,6,5,7};
        //int []inArr = {1,2,3,4,5,6,7};

        int[] preArr = { 4, 2, 1, 3, 8, 6, 5, 7, 9 };
        int[] inArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        RebuildTree rt = new RebuildTree();
        TNode root = rt.Rebuild(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1);
        rt.Inorder(root, "");

        int height = rt.TreeHeight(root);
        w("Height:" + height);
    }
}

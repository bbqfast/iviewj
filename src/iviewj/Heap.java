package iviewj;
public class Heap extends  TestBase
{
    public static int MAX = 100;
    protected Integer last = 0;
    protected Integer[] tr = new Integer[MAX];

    public Heap(IVerifier v)
    {
      super(v);
      Init();
    }
    
    public void Init()
    {
        for(int i=0;i<tr.length;i++)
            tr[i] = -1;
    }

    public void Insert(Integer x)
    {
        last++;
        tr[last] = x;
        int cr  = last;
        while (cr > 1 && tr[cr] < tr[cr / 2])
        {
            swap(tr, cr, cr / 2);
            cr = cr / 2;
        }
    }

    public boolean Delete(int []d)
    {
        d[0] = -1;
        if (last == 0)
            return false;
        int cr = 1;
        d[0] = tr[cr];

        int lastidx = last;
        int lastv = tr[last];
        last--;
        while (cr * 2 <= last)
        {
            int child = cr * 2;

            if (child != last)
                if (tr[child + 1] < tr[child])
                    child++;

            if (lastv > tr[child])
                tr[cr] = tr[child];
            else break;

            cr = child;
        }
        tr[cr] = lastv;


        return true;
    }

    protected void swap(Integer []a, int i, int j)
    {
        Integer t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void printHeap()
    {
        Inorder(tr, 1, "");
    }

    public void Inorder(Integer []tr, int idx, String space)
    {
        if (tr[idx] == -1) return;
        Inorder(tr , idx * 2 ,  space + " ");
        w(space + tr[idx]);
        Inorder(tr, idx * 2 + 1, space + " ");
    }

    public void BulkInsert(Integer[] insertList)
    {
            for (int i=0;i < insertList.length; i++)
                    Insert(insertList[i]);
    }

    public void BulkDelete(Integer[] toDelete, Integer [][]deleted)
    {
        deleted[0] = new Integer[toDelete.length];
        for (int i=0;i<toDelete.length;i++)
        {
            int []del = new int[1];
            this.Delete(del);
            deleted[0][i] = del[0];
        }
    }
    protected void TestInput(Integer[] input, Integer[] expected)
    {
        Init();
        w(Utils.PrintArray("Input: ", input));
        this.BulkInsert(input);
        this.printHeap();
        Integer [][]deleted = new Integer[1][1];
        BulkDelete(input, deleted);

        Verify("Match", deleted[0], expected);
    }

    public void Test1()
    {
        TestInput(new Integer[] {3,2,4,7,9,1}, new Integer[] {1,2,3,4,7,9});
        TestInput(new Integer[] {6,3,2,4,7,5,9,1,8}, new Integer[] {1,2,3,4,5,6,7,8,9});
        TestInput(new Integer[] {3}, new Integer[] {3});
    }
}


//        ElementType
//        DeleteMin( PriorityQueue H )
//        {
//            int i, Child;
//            ElementType MinElement, LastElement;
//
///* 1*/      if( IsEmpty( H ) )
//            {
///* 2*/          Error( "Priority queue is empty" );
///* 3*/          return H->Elements[ 0 ];
//            }
///* 4*/      MinElement = H->Elements[ 1 ];
///* 5*/      LastElement = H->Elements[ H->Size-- ];
//
///* 6*/      for( i = 1; i * 2 <= H->Size; i = Child )
//            {
//                /* Find smaller child */
///* 7*/          Child = i * 2;
///* 8*/          if( Child != H->Size && H->Elements[ Child + 1 ]
///* 9*/                                < H->Elements[ Child ] )
///*10*/              Child++;
//
//                /* Percolate one level */
///*11*/          if( LastElement > H->Elements[ Child ] )
///*12*/              H->Elements[ i ] = H->Elements[ Child ];
//                else
///*13*/              break;
//            }
///*14*/      H->Elements[ i ] = LastElement;
///*15*/      return MinElement;
//        }


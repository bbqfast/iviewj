package GDC;

import javax.management.OperationsException;
import java.util.*;
import GDC.*;

public class NodeStack extends Stack
{
    public void PushNode(TNode n)
    {
        push((Object)n);
    }

    public TNode Pop()
    {
        return (TNode)Pop();
    }

}

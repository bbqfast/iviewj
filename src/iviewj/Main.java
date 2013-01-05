package iviewj;

import javax.management.OperationsException;
import GDC.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws OperationsException {
        // TODO code application logic here
        System.out.println("aaa");
        Run(new MaxSum());
        //TNode.test();
    }

    public static void Run(TestBase t) throws OperationsException {
        t.Test1();
    }
}

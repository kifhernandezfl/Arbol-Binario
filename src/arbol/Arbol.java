package arbol;

public class Arbol 
{
    public static void main(String[] args) 
    {
        BinaryTree testTree = new BinaryTree();
            testTree.insert(52);
            testTree.insert(18);
            testTree.insert(74);
            testTree.insert(60);
            testTree.insert(87);
            testTree.insert(83);
            testTree.insert(100);
            testTree.insert(85);
            System.out.println("Pre - Orden: ");
            testTree.preOrderPrint(testTree.root);
            System.out.println("In - Orden: ");
            testTree.inOrderPrint(testTree.root);
            System.out.println("Pos - Orden: ");
            testTree.posOrderPrint(testTree.root);
           // testTree.delete(52);
            System.out.println("Pos - Orden: ");
            testTree.posOrderPrint(testTree.root);
    }
}

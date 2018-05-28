package arbol;

public class Complete 
/*Pre: DBACEGF      In: ABCDEFG[2,1,3,0,4,6,5]       Post: ACBFGED
 */

{
        public Complete()
        {

        }

        public String in_pre2post(String inorder, String preorder)
        {
            BinaryTree recovery = new BinaryTree();
            recovery = recovery_subtree(inorder, preorder);
            recovery.posOrderPrint(recovery.root);
            /*int [] indexes = new int[inorder.length()];

            for(int i = 0; i < inorder.length(); i++)
                    indexes[i] = preorder.indexOf(inorder.substring(i, i + 1));

            for(int i = 0; i < indexes.length; i++)
                    System.out.println(indexes[i] + " ");*/

            return null;
        }

        public String in_post2pre(String inorder, String preorder)
        {
            BinaryTree recovery = new BinaryTree();
            recovery = recovery_subtree_inpost(inorder, preorder);
            recovery.preOrderPrint(recovery.root);
            /*int [] indexes = new int[inorder.length()];

            for(int i = 0; i < inorder.length(); i++)
                    indexes[i] = preorder.indexOf(inorder.substring(i, i + 1));

            for(int i = 0; i < indexes.length; i++)
                    System.out.println(indexes[i] + " ");*/

            return null;
        }

        public BinaryTree recovery_subtree(String sub_inorder, String preorder)
        {

            if(sub_inorder.length() == 0)
                    return new BinaryTree();
            else
            {
                BinaryTree temp = new BinaryTree();

                if(sub_inorder.length() == 1)

                {
                        BinaryTree temp = new BinaryTree();
                        temp.root = new Node(sub_inorder);
                }else
                {	
                        int [] indexes = new int[sub_inorder.length()];

                        for(int i = 0; i < sub_inorder.length(); i++)
                                indexes[i] = preorder.indexOf(sub_inorder.substring(i, i + 1));

                        for(int i = 0; i < indexes.length; i++)
                                System.out.println(indexes[i] + " ");

                        int less = Integer.MAX_VALUE, index = -1;

                        for(int i = 0; i < indexes.length; i++)
                                if(indexes[i] < less)
                                {
                                        index = i;
                                        less = indexes[i];
                                }

                        temp.root = new Node(sub_inorder.substring(index,index + 1));
                        temp.root.left = recovery_subtree(sub_inorder.substring(0,index), preorder).root;
                        temp.root.right = recovery_subtree(sub_inorder.substring(index + 1), preorder).root;
                }

                return temp;
                }

        }

        public BinaryTree recovery_subtree_inpost(String sub_inorder, String preorder)
        {

                if(sub_inorder.length() == 0)
                        return new BinaryTree();
                else
                {
                        BinaryTree temp = new BinaryTree();

                        if(sub_inorder.length() == 1)
                        {
                                temp.root = new Node(sub_inorder);
                        }else
                        {	
                                int [] indexes = new int[sub_inorder.length()];

                                for(int i = 0; i < sub_inorder.length(); i++)
                                        indexes[i] = preorder.indexOf(sub_inorder.substring(i, i + 1));

                                for(int i = 0; i < indexes.length; i++)
                                        System.out.println(indexes[i] + " ");

                                int greater = Integer.MIN_VALUE, index = -1;

                                for(int i = 0; i < indexes.length; i++)
                                        if(indexes[i] > greater)
                                        {
                                                index = i;
                                                greater = indexes[i];
                                        }

                                temp.root = new Node(sub_inorder.substring(index,index + 1));
                                temp.root.left = recovery_subtree(sub_inorder.substring(0,index), preorder).root;
                                temp.root.right = recovery_subtree(sub_inorder.substring(index + 1), preorder).root;

                        }

                        return temp;
                }

        }

        public static void main(String[] args)
    {
                Complete com = new Complete();
                com.in_pre2post("ABCDEFG", "DBACEGF");


    }
}


package TobyMyers_FSU;

public class AVLTree {

    private static final int ALLOWED_IMBALANCE = 1;
    public static AvlNode root;


    //Constructs the nodes of the AVL Tree.
    private static class AvlNode<Record>{
        Record record;
        AvlNode leftChild;
        AvlNode rightChild;
        int height;

        AvlNode(Record theRecord) {
            this(theRecord, null, null);
        }

        AvlNode(Record theRecord, AvlNode left, AvlNode right) {
            record = theRecord;
            leftChild = left;
            rightChild = right;
            height = 0;
        }

        @Override
        public String toString() {
            return "Record = " + this.record;
        }


    }



    //Returns the height of node root, -1 if null.

    private int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    public void insert(Record record) {
        root = insert(record, root);
    }

    /*
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode insert(Record record, AvlNode root) {
        if (root == null)
            return new AvlNode(record, null, null);

        int compareResult = record.toString().compareTo(root.record.toString());

        if (compareResult < 0)
            root.leftChild = insert(record, root.leftChild);
        else if (compareResult > 0)
            root.rightChild = insert(record, root.rightChild);
        else
            ;

        return balance (root);
    }
    // Assume t is either balanced or within one of being balanced
    private AvlNode balance(AvlNode root) {
        if (root == null)
            return root;

        if (height(root.leftChild) - height(root.rightChild) > ALLOWED_IMBALANCE)
            if (height(root.leftChild.leftChild) >= height(root.leftChild.rightChild))
                root = rotateWithLeftChild(root);
            else
                root = doubleWithLeftChild(root);
       else
       if (height(root.rightChild) - height(root.leftChild) > ALLOWED_IMBALANCE)
           if (height(root.rightChild.rightChild) >= height(root.rightChild.leftChild))
               root = rotateWithRightChild(root);
           else
               root = doubleWithRightChild(root);

       root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
       return root;
    }

    /*
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1.
     * Update heights, then return new root.
     */
    private AvlNode rotateWithLeftChild(AvlNode root) {
        AvlNode newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    /*
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     * Update heights, then return new root.
     */
    private AvlNode rotateWithRightChild(AvlNode root) {
        AvlNode newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    /*
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     */
    private AvlNode doubleWithLeftChild(AvlNode root) {
        root.leftChild = rotateWithRightChild(root.leftChild);
        return rotateWithLeftChild(root);
    }

    /*
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     * Update heights, then return new root.
     */
    private AvlNode doubleWithRightChild(AvlNode root) {
        root.rightChild = rotateWithLeftChild(root.rightChild);
        return rotateWithRightChild(root);
    }
    public boolean isEmpty() {
        return root == null;
    }

    private void setHeight(AvlNode node) {
        node.height = Math.max(height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(AvlNode root) {
        if (root == null)
            return  0;
        else {
            int i = 1;
            i += countNodes(root.leftChild);
            i += countNodes(root.rightChild);

            return i;
        }
    }

    public void printTree(AvlNode root) {
        if (root != null) {
            printTree(root.leftChild);
            System.out.println(root.record);
            printTree(root.rightChild);
        }
    }

//    private AvlNode findLastName() {
//        AvlNode current = root;
//        while (current != null) {
//            if ()
//        }
//    }

}

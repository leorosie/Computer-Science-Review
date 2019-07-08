class RosiesBinaryTree {
    private node root;

    public RosiesBinaryTree(node root) {
        this.root = root;
    }

    public node getRoot() {
        return this.root;
    }


    public node insertRecursive(node currentNode, int newValue) {
        if (currentNode == null) {
            node newNode = new node(newValue);
            return newNode;
        }


        if (newValue < currentNode.getValue()) {

            currentNode.setLeft(insertRecursive(currentNode.getLeft(), newValue));


        } else {
            currentNode.setRight(insertRecursive(currentNode.getRight(), newValue));
        }

        return currentNode;
    }




    public void add(int newValue) {

        if (this.root == null) {
            this.root = new node(newValue);
        }
        this.root = insertRecursive(this.root, newValue);
    }



    public void delete(int deleteValue) {
        root = deleteRecursive(root, deleteValue);
        //  System.out.println(deleteNode.value);

    }

    public node deleteRecursive(node deleteNode, int deleteValue) {

        //  System.out.println(deleteNode.value);
        if (deleteNode == null) {
            System.out.println("The value " + deleteValue + " does not exist in the tree");
        } else if (deleteNode.getValue() == deleteValue) {
            if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {

                deleteNode = null;


            } else if (deleteNode.getLeft() == null) {

                deleteNode = deleteNode.getRight();
            } else if (deleteNode.getRight() == null) {
                deleteNode = deleteNode.getLeft(); //null;
            } else {
                deleteNode = reorganizeTree(deleteNode);

            }
        } else if (deleteValue < deleteNode.getValue()) {
            deleteNode.setLeft(deleteRecursive(deleteNode.getLeft(), deleteValue));

        } else {

            deleteNode.setRight(deleteRecursive(deleteNode.getRight(), deleteValue));

        }
        return deleteNode;

    }

    public node searchRecursive(node currentNode, int searchValue) {


        if (currentNode == null) {
            return null;
        } else if (searchValue < currentNode.getValue()) {

            return searchRecursive(currentNode.getLeft(), searchValue);


        } else if (searchValue > currentNode.getValue()) {
            return searchRecursive(currentNode.getRight(), searchValue);
        }

        return currentNode;


    }

    public node reorganizeTree(node deleteNode) {
        node replaceNode = findMin(deleteNode.getRight());
        delete(replaceNode.getValue());
        replaceNode.setLeft(deleteNode.getLeft());
        replaceNode.setRight(deleteNode.getRight());
        return replaceNode;
    }



    public node findMin(node deleteNode) {
        while (deleteNode.getLeft() != null) {
            deleteNode = deleteNode.getLeft();

        }
        return deleteNode;


    }


    public static void printBinaryTree(node root, int level) {
        if (root == null)
            return;
        printBinaryTree(root.getRight(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.getValue());
        } else
            System.out.println(root.getValue());
        printBinaryTree(root.getLeft(), level + 1);
    }


}




public class Main {
    public static void main(String[] args) {
        node root = new node(16);
        RosiesBinaryTree tree = new RosiesBinaryTree(root);
        // tree.add(16);
        tree.add(8);
        tree.add(20);
        tree.add(3);
        tree.add(10);
        tree.add(18);
        tree.add(2);
        tree.add(30);
        tree.add(25);
        tree.add(19);
        tree.add(17);
        tree.delete(16);
        tree.delete(20);
        tree.add(40);
        tree.printBinaryTree(tree.getRoot(), 0);

    }
}

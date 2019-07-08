public class node {
    private int value;
    private node left;
    private node right;

    public node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public node getLeft() {
        return this.left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return this.right;
    }

    public void setRight(node right) {
        this.right = right;
    }

}
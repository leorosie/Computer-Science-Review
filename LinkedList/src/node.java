public class node {

    private int value;
    private node previous;
    private node next;

    public node(int value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public node getPrevious() {
        return this.previous;
    }

    public void setPrevious(node previous) {
        this.previous = previous;
    }

    public node getNext() {
        return this.next;
    }

    public void setNext(node next) {
        this.next = next;
    }

}

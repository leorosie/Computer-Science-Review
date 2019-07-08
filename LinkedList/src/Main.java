class RosiesLinkedList {
    private node head;




    public RosiesLinkedList(node head) {
        this.head = head;
    }

    public void insert(int newValue) {
        node newNode = new node(newValue);
        if (head == null) {
            this.head = newNode;

        } else {
            node last = this.head;

            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
            newNode.setPrevious(last);
        }

    }

    public void delete(int deleteValue) {


        node currentNode = search(deleteValue);

        if (currentNode == null) {
            System.out.println(deleteValue + " doesn't exist in the list");
        } else {

            if (currentNode == head) {
                head = currentNode.getNext(); //next;
                currentNode = currentNode.getNext();
                currentNode.setPrevious(null);

            } else if (currentNode.getNext() == null) {
                currentNode = currentNode.getPrevious();
                currentNode.setNext(null);

            } else {
                currentNode = currentNode.getPrevious();
                currentNode.setNext(currentNode.getNext().getNext());
                currentNode = currentNode.getNext();
                currentNode.setPrevious(currentNode.getPrevious().getPrevious());
            }
        }
    }

    public void printList() {
        node currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    public node search(int searchValue) {
        node currentNode = head;
        while (currentNode != null && currentNode.getValue() != searchValue) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

}




public class Main {
    public static void main(String[] args) {
        node head = new node(2);
        RosiesLinkedList list = new RosiesLinkedList(head);
        list.insert(7);
        list.insert(8);
        list.insert(11);
        list.insert(25);
        list.insert(13);
        list.delete(25);
        list.insert(4);
        list.printList();
    }
}

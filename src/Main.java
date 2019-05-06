import java.util.Arrays;

class RosiesArrayList {

    private int size;
    private int[] myList;
    private int newSize;
    private int[] newList;
    private int indexValue;
    private int index;

    //Initialize ArrayList
    public RosiesArrayList(int size) {
        this.size = size;
        myList = new int[size];
        this.index = 0;

    }

    //Add a new value to the ArrayList
    public void add(int newValue) {
        if (index == myList.length) {
            myList = increaseSize();

        }
        myList[index] = newValue;

        ++index;

    }

    //Increase the size of the ArrayList
    public int[] increaseSize() {
        newSize = myList.length + (int)(myList.length * 0.5);
        newList = Arrays.copyOf(myList, newSize);

        return newList;
    }

    //Get value in ArrayList given a specified index
    public int get(int indexnum) {
        indexValue = myList[indexnum];
        return indexValue;
    }

    //Change a value of a specified index in the ArrayList
    public void set(int indexnum, int value) {
        myList[indexnum] = value;
    }

    //Print the ArrayList for QC
    public void printArray() {
        System.out.println(Arrays.toString(myList));
    }
}

public class Main {
    public static void main(String[] args) {
        RosiesArrayList test = new RosiesArrayList(10);

        //Testing the ArrayList
        int totalSize = (int) 1e7;

        //Testing the runtime
        double start = System.currentTimeMillis();

        for (int n = 0; n < totalSize; ++n) {
            test.add(n);
        }
        double timeSpent = System.currentTimeMillis() - start;

        System.out.println(test.get(88));
        test.set(8, 99);
        System.out.println(timeSpent);

    }
}

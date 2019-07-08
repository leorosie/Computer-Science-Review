import java.util.*;


public class Main {

    public static int[] BubbleSort(int[] array){
        boolean sorted=false;
        while (sorted==false){
            sorted = true;

            for (int i = 0; i < array.length - 1; ++i) {

                if (array[i] > array[i + 1]) {
                    sorted = false;
                    swap(array,i,i+1);
                    //array[i]=array[i]+array[i+1];
                    //array[i+1]=array[i]-array[i+1];
                    //array[i]=array[i]-array[i+1];
                }

            }
        }

        return array;
    }

    public static void swap(int[] array, int index1, int index2){
        array[index1]=array[index1]+array[index2];
        array[index2]=array[index1]-array[index2];
        array[index1]=array[index1]-array[index2];

    }

    public static int[] MergeSort(int[] array){
        if (array.length<2){
            return array;
        }
        int midIndex=array.length/2;
        int[] firstHalf=Arrays.copyOfRange(array,0,midIndex);
        int [] secondHalf=Arrays.copyOfRange(array,midIndex, array.length);

        int[] left=MergeSort(firstHalf);
        int[] right=MergeSort(secondHalf);

        merge(array,left,right,midIndex);

        return array;
    }

    public static void merge(int[]array,int[]left, int[]right,int midIndex){
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length && j<right.length){
            if (left[i]>right[j]){
                array[k]=right[j];
                ++k;
                ++j;

            }
            else{
                array[k]=left[i];
                ++k;
                ++i;

            }

        }

        while (i<left.length){
            array[k]=left[i];
            ++k;
            ++i;

        }

        while(j<right.length){

            array[k]=right[j];
            ++j;
            ++k;

        }


    }

    public static int[] QuickSort(int[] array){
        int[] pivot;
        int[] left;
        int[] right;
        for (int i=0; i<array.length;++i){
            if (array[i]>pivot){

            }
            else (array[i]<=pivot){

            }
        }
        if (left.length==1){ ///what if left is empty
            return left;
        }
        if (right.length==1){
            return right;
        }
        left=QuickSort(left);
        right=QuickSort(right);

        //lock in

        return array;
    }



    public static void main(String[] args){
        int[] test = new int[5];
        test[0]=5;
        test[1]=8;
        test[2]=1;
        test[3]=3;
        test[4]=7;

        System.out.println(Arrays.toString(test));
        //test=BubbleSort(test);
        //System.out.println(Arrays.toString(test));
        test=MergeSort(test);
        System.out.println(Arrays.toString(test));
    }
}

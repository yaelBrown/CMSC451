package hw;

// Insertion Sort
public class Homework2 {
    static void selectionSort(int array[]){
        sort(array, 0);
    }

    static void sort(int[] array, int i){
        if (i < array.length -1) {
            int j = smallest(array, i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            sort(array, i + 1);
        }
    }

    static int smallest(int[] array, int j) {
        if (j == array.length -1) return array.length -1;
        int k = smallest(array, j + 1);
        return array[j] < array[k] ? j : k;
    }

    public static void main(String[] args) {
        int[] wc = { 5, 4, 3, 2, 1 };

        selectionSort(wc);

        for (int i : wc) {
            System.out.println("i = " + i);
        }
    }


}

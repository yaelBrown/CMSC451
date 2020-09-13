package proj.Project1;

// Iterative BubbleSort initially retrived from https://www.geeksforgeeks.org/recursive-bubble-sort/

public class BubbleSort implements SortInterface {

    private long time = 0L;
    private int count = 0;
    private long sTime = 0L;
    private long eTime = 0L;

    // A function to implement recursion bubbleSort
    public void recursiveSort(int arr[], int n)
    {
        sTime = System.nanoTime();
        // Base case
        if (n == 1)
            return;

        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                this.count++;
            }

        // Largest element is fixed,
        // recur for remaining array
        recursiveSort(arr, n-1);
        eTime = System.nanoTime();
        time += (eTime - sTime);
    }

    public void iterativeSort(int arr[], int n) {
        sTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {       // arr.length - 1 - i, assumes the highest element is at arr.length - 1 index i of this iteration
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    this.count++;
                }
            }
        }
        eTime = System.nanoTime();
        time += (eTime - sTime);
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public long getTime() {
        return this.time;
    }

    static void printArr(int arr[]) {
        String out = "";
        for (int n : arr) {
            out += n + " ";
        }
        System.out.println(out);
    }

    public void resetCounters() {
        this.count = 0;
        this.time = 0L;
    }














    // Test sorting methods
    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();

        int[] aa = { 9, 8, 5, 3, 6, 1, 2, 7 };
        System.out.println("before sort");
        printArr(aa);

        bs.recursiveSort(aa, aa.length);
        System.out.println("after sort : recursive");
        printArr(aa);
        
        int[] bb = { 9, 8, 5, 3, 6, 1, 2, 7 };
        System.out.println("before sort");
        printArr(bb);

        bs.iterativeSort(bb, bb.length);
        System.out.println("after sort: iterative");
        printArr(bb);
    }

}

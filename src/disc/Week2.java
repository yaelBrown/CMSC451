package disc;

public class Week2 {
    public static void main(String[] args) {
        int out = factorial(4);

        System.out.println(out);
    }

    public static int factorial(int n) {            // Method definition
        if (n == 1) {                               // Check if n is 1
            return 1;                               //  return 1.
        } else {
            return n * factorial(n-1);          // recursive method that multiplies the return of the factorial by n
        }
    }

}

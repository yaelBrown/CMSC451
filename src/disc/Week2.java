package disc;

public class Week2 {
    public static void main(String[] args) {
      aa(4);
    }

    public static String[] numbers = {"zero", "one", "two", "three", "four"};

    public static void aa(int n) {
        if (n >= numbers.length) {
            System.out.println("Invalid number"); // O(1)
        } else if (n == 0) {
            System.out.println("Number is 0!"); // O(1)
        } else {
            for (int i = 0; i < n; i++) System.out.println(numbers[n] + ": hello"); // O(n)
            aa(n-1); // O(n)
        }
    }
}
package hw;

import java.util.*;

// #3
public class SortedPriorityQueue<E> extends PriorityQueue {

    public SortedPriorityQueue() {}

    ArrayList<E> spq = new ArrayList<>();

    @Override
    public boolean add(Object o) {
        spq.add((E) o);
        Collections.sort((List) spq);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        spq.remove(o);
        Collections.sort((List) spq);
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (Object t : this.spq) {
            out += t + "\n";
        };
        return out;
    }

    public static void main(String[] args) {
//        SortedPriorityQueue<String> test = new SortedPriorityQueue<>();
//
//        test.add("Yael");
//        test.add("Apple");
//        test.add("Cookies");
//
//        System.out.println(test.toString());
//
//        test.add("Popcorn");
//
//        System.out.println(test.toString());
//
//        test.remove("Popcorn");
//
//        System.out.println(test.toString());
    }
}

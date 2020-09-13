package proj.Project1;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
    static {
        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println("Warm Up time : " + (end - start));
    }

    public static ArrayList<String> readFile() {
        ArrayList<String> out = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        Integer res = chooser.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                if (f.isFile()) {
                    Scanner myReader = new Scanner(f);
                    while (myReader.hasNextLine()) {
                        String line = myReader.nextLine();
                        out.add(line);
                    }
                    myReader.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        printArrayList(out);

        return out;
    }

    static void printArrayList(ArrayList<String> al) {
        System.out.println("\nPrinting contents of file\n");
        for (String l : al) {
            System.out.println(l);
        }
    }

    static void run() {
        BenchmarkSorts bms = new BenchmarkSorts(readFile());
        GUI g = new GUI(bms.getResults());
    }

    public static void main(String[] args) {
        run();
    }

}

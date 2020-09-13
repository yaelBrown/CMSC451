package proj.Project1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BenchmarkSorts {
    BubbleSort bs = new BubbleSort();

    static Random random = new Random();

    final int[] quantities = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
    final String[] sortMethods = { "BubbleSort Recursive", "BubbleSort Iterative" };

    private ArrayList<Results> results = new ArrayList<Results>();
    private HashMap<String, Integer[]> dataSets = new HashMap<String, Integer[]>();

    public BenchmarkSorts() {
        populateDataSets();
    }

    public BenchmarkSorts(ArrayList<String> al) {
        populateDataSets(al);
        benchmark();
    }

    private void populateDataSets() {
        System.out.println("BenchmarkSorts: Populating dataSets");
        for (int q : quantities) {
            System.out.println("BenchmarkSorts:     Populating for " + q);
            Integer[] temp = new Integer[q];
            for (int i = 0; i < q; i++)  temp[i] = random.nextInt(10000);
            dataSets.put(String.valueOf(q), temp);
        }
        System.out.println("BenchmarkSorts: Finished populating dataSets");
    }

    private void populateDataSets(ArrayList<String> al) {
        System.out.println("BenchmarkSorts: Populating dataSets");

        for (int i = 0; i < quantities.length; i++) {
            System.out.println("BenchmarkSorts:     Populating for " + quantities[i]);

            String[] temp = al.get(i).split(" ");
            Integer[] tempN = new Integer[temp.length];

            for (int j = 0; j < temp.length; j++) {
                tempN[j] = Integer.parseInt(temp[j]);
            }

            dataSets.put(String.valueOf(quantities[i]), tempN);
        }

        System.out.println("BenchmarkSorts: Finished populating dataSets");
    }

    private void benchmark() {
        System.out.println("BenchmarkSorts: Warming up JVM");
        warmup();

        System.out.println("BenchmarkSorts: Running Benchmark...");
        int[] temp;
        int[] unsortedData;

        int runs = 0;

        for (int i = 0; i < dataSets.size(); i++) {
            String dataSetsSizeLabel = String.valueOf(quantities[i]);
            temp = convertIntergerToInt(dataSets.get(dataSetsSizeLabel));
            unsortedData = temp;

            // Testing recursive sort
            System.out.println("BenchmarkSorts: Benchmarking " + sortMethods[0] + " Data Size = " + temp.length);
            bs.recursiveSort(temp, temp.length);
            checkSorted(temp);
            runs++;

            // Resetting data
            temp = unsortedData;

            // Testing iterative sort
            System.out.println("BenchmarkSorts: Benchmarking " + sortMethods[1] + " Data Size = " + temp.length);
            bs.iterativeSort(temp, temp.length);
            checkSorted(temp);
            runs++;

            // Calculate results
            System.out.println("BenchmarkSorts: Calculating results...");
            String size = dataSetsSizeLabel;
            double averageCount = (double) bs.getCount() / runs;
            double coefficientCount = calcStandardDev(bs.getCount()); // Figure this out
            double averageTime = (double) bs.getTime() / runs;
            double coefficientTime = calcStandardDev(bs.getTime()); // Figure this out as well

            // Saving results
            System.out.println("BenchmarkSorts: Saving results");
            Results r = new Results(size, averageCount, coefficientCount, averageTime, coefficientTime);
            results.add(r);

            System.out.println("BenchmarkSorts: Saved results" +
                    "\n\tsize = " + size +
                    "\n\taverageCount = " + averageCount +
                    "\n\tcoefficientCount = " + coefficientCount +
                    "\n\taverageTime = " + averageTime +
                    "\n\tcoefficientTime = " + coefficientTime);
            System.out.println("\n");
        }
    }

    private void checkSorted(int[] sortedArr) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (i == (sortedArr.length - 1)) {
                return;
            } else {
                if (sortedArr[i] > sortedArr[i+1]) {
                    throw new UnsortedException("array is out of order: " + sortedArr[i] + " > " + sortedArr[i+1] + " - at index: " + i);
                }
            }
        }
    }

    private double calcStandardDev(long val) {
        double[] temp = new double[(int) val];
        for (int i = 0; i < temp.length; i++) temp[i] = i;

        double sum = 0;
        double finalSum = 0;
        double avg = 0;

        for (double t : temp) {
            sum += t;
        }
        avg = sum/val;

        double aa = 0;

        for (double t : temp) {
            finalSum += Math.sqrt(Math.abs(t - avg));
        }

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);

        return Double.parseDouble(df.format(Math.sqrt(finalSum/(double) val)));
    }

    private int[] convertIntergerToInt(Integer[] i) {
        int[] out = new int[i.length];
        for (int p = 0; p < i.length; p++) {
            out[p] = Integer.valueOf(i[p]);
        }
        return out;
    }

    private void warmup() {
        BubbleSort warmupBS = new BubbleSort();

        int[] warmupData = {1, 2, 3, 4, 5};
        for (int i = 0; i < 1000; i++) {
            bs.iterativeSort(warmupData, warmupData.length);
            bs.recursiveSort(warmupData, warmupData.length);
        }
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    class Results {
        private String size;
        private double avgCnt;
        private double coefCnt;
        private double avgTime;
        private double coefTime;

        public Results(String sizee, double avgCnt, double coefCnt, double avgTime, double coefTime) {
            size = sizee;
            this.avgCnt = avgCnt;
            this.coefCnt = coefCnt;
            this.avgTime = avgTime;
            this.coefTime = coefTime;
        }

        public String getSize() {
            return size;
        }

        public double getAvgCnt() {
            return avgCnt;
        }

        public double getCoefCnt() {
            return coefCnt;
        }

        public double getAvgTime() {
            return avgTime;
        }

        public double getCoefTime() {
            return coefTime;
        }
    }
}

package ds;

public class ScanningAlgorithmMaxSub {

    public static void main(String[] args) {
        int[] x = {31, -41, 59, 26,  -53, 58, 97, -93, -23, 84};

        printData(x);

        int maxsofar = 0;
        int maxendinghere = 0;
        String series = "0";

        for (int i = 0; i < x.length - 1; i++) {
            System.out.printf("%d, %d, [%s]\n", maxendinghere, maxsofar, series);

            maxendinghere = Math.max(maxendinghere + x[i], 0);
            maxsofar = Math.max(maxsofar, maxendinghere);

            series = series + ", " + x[i];

        }

        System.out.printf("%d, %d\n", maxendinghere, maxsofar);

    }

    private static void printData(int[] x) {
        for (int i : x) {
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }

}

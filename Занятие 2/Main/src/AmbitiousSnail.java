import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class AmbitiousSnail {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("TheMinimumRectangle/input.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            List<Integer> list = new ArrayList<>();
            Long maxLen = 0L;
            int n = Integer.parseInt(bufferedReader.readLine());
            List<long[]> sequencePositive = new ArrayList<>();
            List<long[]> sequenceNegative = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            long mind = 0;
            long trace = 0;
            long[] maxmaxPositive = new long[3];
            long[] maxNegative = new long[3];
            for (int i = 0; i != n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                long up = Long.parseLong(stringTokenizer.nextToken());
                long down = Long.parseLong(stringTokenizer.nextToken());
                long[] a = new long[3];
                a[0] = up - down;
                a[1] = up;
                a[2] = i + 1;
                if (a[0] > 0) {
                    sequencePositive.add(a);
                } else {
                    sequenceNegative.add(a);
                    if (maxNegative[1] < a[1]) {
                        maxNegative[0] = a[0];
                        maxNegative[1] = a[1];
                        maxNegative[2] = a[2];
                    }
                }
            }
            if (!sequencePositive.isEmpty()) {
                maxmaxPositive[0] = sequencePositive.get(0)[0];
                maxmaxPositive[1] = sequencePositive.get(0)[1];
                maxmaxPositive[2] = sequencePositive.get(0)[2];
            }

//
            for (var elem : sequencePositive) {
                if (elem[1] - elem[0] > maxmaxPositive[1] - maxmaxPositive[0]) {
                    maxmaxPositive[0] = elem[0];
                    maxmaxPositive[2] = elem[2];
                    maxmaxPositive[1] = elem[1];
                }
            }
            //sequencePositive.sort(Comparator.comparingLong((long[] a)-> a[0]).reversed().thenComparingLong(a -> a[1]));
        //   sequenceNegative.sort(Comparator.comparingLong((long[] a) -> a[1]).reversed());
            for (var elem : sequencePositive) {
                if (elem[2] != maxmaxPositive[2]) {
                    maxLen = Math.max(maxLen, trace + elem[1]);
                    trace += elem[0];
                    list.add((int) elem[2]);
                    stringBuilder.append(elem[2]).append(" ");
                }
            }
            if (!sequencePositive.isEmpty()) {
                maxLen = Math.max(maxLen, trace + maxmaxPositive[1]);
                trace += maxmaxPositive[0];
                stringBuilder.append(maxmaxPositive[2]).append(" ");
            }
            if (!sequenceNegative.isEmpty()) {
                maxLen = Math.max(maxLen, trace + maxNegative[1]);
                trace += maxNegative[0];
                stringBuilder.append(maxNegative[2]).append(" ");
            }
            for (var elem : sequenceNegative) {
                if (elem[1] != maxNegative[1]) {
                    stringBuilder.append(elem[2]).append(" ");
                }
            }
            bufferedWriter.write(maxLen + "\n" + stringBuilder.toString());
            bufferedWriter.flush();
        }
    }
}

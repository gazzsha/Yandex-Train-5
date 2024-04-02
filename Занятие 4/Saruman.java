import java.io.*;
import java.util.StringTokenizer;

public class Saruman {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] a = new int[n];
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            long[] prefixSum = new long[n + 1];
            for (int i = 1; i != n + 1; i++) {
                prefixSum[i] = a[i - 1] + prefixSum[i - 1];
            }
            for (int i = 0; i != k; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int l = Integer.parseInt(stringTokenizer.nextToken());
                long s = Long.parseLong(stringTokenizer.nextToken());
                int indexEquals = searchEquals(prefixSum, l, s);
                bufferedWriter.write(indexEquals + "\n");
            }
            bufferedWriter.flush();
        }
    }

    public static int lBinarySearch(long[] a, long target, long k) {
        long l = 0L;
        long r = a.length - 1;
        while (l < r) {
            long mid = (l + r) / 2;
            if (mid - k >= 0) {
                if (a[(int) mid] - a[(int) (mid - k)] >= target) r = mid;
                else l = mid + 1;
            } else l = mid + 1;
        }
        if (l - k < 0) return -1;
        return a[(int) l] - a[(int) ((int) l - k)] == target ? (int) (l - k + 1) : -1;
    }

    public static int searchEquals(long[] a, long l, long s) {
        return lBinarySearch(a, s, l);
    }

}

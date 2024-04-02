import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickArraySearch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] a = new int[n];
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int countQueries = Integer.parseInt(bufferedReader.readLine());
            Arrays.sort(a);
            for (int i = 0; i != countQueries; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int l = Integer.parseInt(stringTokenizer.nextToken());
                int r = Integer.parseInt(stringTokenizer.nextToken());
                writeAnswer(l,r,a,bufferedWriter);
            }
            bufferedWriter.flush();
        }
    }

    public static void writeAnswer(int l,int r,int[] a,BufferedWriter bufferedWriter) throws IOException {
        int indexL = leftBinarySearch(a,l);
        int indexR = rightBinarySearch(a,r);
        if (indexL != -1 && indexR != -1) {
            bufferedWriter.write(indexR - indexL + 1 + " ");
        } else bufferedWriter.write(0 + " ");
    }
    public static int leftBinarySearch(int[] a,int target) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= target)
                r = mid;
            else l = mid + 1;
        }
      return a[l] >= target ? l : -1;
    }

    public static int rightBinarySearch(int[] a,int target) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (a[mid] <= target)
                l = mid;
            else r = mid - 1;
        }
        return a[l] <= target ? l : -1;
    }
}

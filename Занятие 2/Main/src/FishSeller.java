import java.io.*;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class FishSeller {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            Deque<Integer> deque = new ArrayDeque<>();
            int maxValue = 0;
            int[] a = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(stringTokenizer.nextToken());;
            }
            for (int i = 0; i != n; i++) {
                while (!deque.isEmpty() && deque.peekLast() > a[i]) {
                    deque.removeLast();
                }
                deque.add(a[i]);
                maxValue = Math.max(maxValue,a[i] - deque.peekFirst());
                if (i - k >= 0) {
                    if (deque.peekFirst() == a[i - k]) {
                        deque.removeFirst();
                    }
                }
            }
           bufferedWriter.write(maxValue+"");
            bufferedWriter.flush();
        }
    }
}

import java.io.*;
import java.util.*;

public class TwoOutThree {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            Set<Integer> res = new TreeSet<>();
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j != n; j++) {
                set1.add(Integer.valueOf(stringTokenizer.nextToken()));
            }
            n = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (set1.contains(value)) res.add(value);
                else set2.add(value);
            }
            n = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (set1.contains(value) || set2.contains(value)) res.add(value);
            }
            for (var elem : res)
                bufferedWriter.write(elem + " ");
            bufferedWriter.flush();
        }
    }
}

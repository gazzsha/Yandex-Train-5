import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RecurringNumber {
    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[] a = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Map<Integer, Integer> map = new HashMap<>();
            boolean flag = false;
            for (int i = 0; i != n; i++) {
                if (!map.containsKey(a[i])) {
                    map.put(a[i], i);
                } else {
                    if (map.get(a[i]) >= i - k)  {
                        flag = true;
                        break;
                    } else map.put(a[i],i);
                }
            }
            if (flag) bufferedWriter.write("YES");
            else bufferedWriter.write("NO");
            bufferedWriter.flush();
        }
    }
}

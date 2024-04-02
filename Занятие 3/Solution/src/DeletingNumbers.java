import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DeletingNumbers {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (!map.containsKey(value)) {
                    map.put(value, 1);
                } else map.put(value, map.get(value) + 1);
            }
            int minCount = n;
            for (var pair : map.entrySet()) {
                if (map.containsKey(pair.getKey() - 1)) {
                    minCount = Math.min(minCount, n - pair.getValue() - map.get(pair.getKey() - 1));
                } else minCount = Math.min(minCount,n - pair.getValue());
            }
            bufferedWriter.write(minCount + "");
            bufferedWriter.flush();
        }

    }
}

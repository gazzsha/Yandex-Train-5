import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Playlists {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i != n; i++) {
                int k = Integer.parseInt(bufferedReader.readLine());
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int l = 0; l != k; l++) {
                    String s = stringTokenizer.nextToken();
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else map.put(s, map.get(s) + 1);
                }
            }
            List<String> collect = map.entrySet().stream()
                    .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == n)
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getKey)
                    .toList();
            bufferedWriter.write(collect.size() + "\n");
            for (var elem : collect)
                bufferedWriter.write(elem + " ");
            bufferedWriter.flush();
        }

    }
}
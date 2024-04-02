import java.io.*;
import java.util.*;

public class BuildSquare {
    public static void main(String[] args) throws IOException {


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Map<Pair<Integer>, Integer> point = new HashMap<>();
            List<Pair<Integer>> list = new ArrayList<>();
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                Pair<Integer> pair = new Pair<>(Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken()));
                int lenSize = Math.abs(Math.max(pair.x(), pair.y()) - Math.min(pair.x(), pair.y()));
                point.put(pair, lenSize);
            }
        }
    }
}

record Pair<T>(T x, T y) {
}

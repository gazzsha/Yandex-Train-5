import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int q = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int[] in1 = new int[]{p - v, -1};
            int[] out1 = new int[]{p + v, 1};
            int[] in2 = new int[]{q - m, -1};
            int[] out2 = new int[]{q + m, 1};
            List<int[]> events = new ArrayList<>();
            events.add(in1);
            events.add(out1);
            events.add(in2);
            events.add(out2);
            events.sort(Comparator.comparing((int[] a) -> a[0]).thenComparing((int[] a) -> a[1]));
            int online = 0;
            int lastIn = 0;
            int size = 0;
            int count = 0;
            for (int i = 0; i != events.size(); i++) {
                if (events.get(i)[1] == -1) {
                    online++;
                    size++;
                } else {
                    online--;
                    size++;
                }
                if (online == 0) {
                    count += (events.get(i)[0] - events.get(i - size + 1)[0] + 1);
                    size = 0;
                }
            }
            bufferedWriter.write(count + "");
            bufferedWriter.flush();
        }
    }
}

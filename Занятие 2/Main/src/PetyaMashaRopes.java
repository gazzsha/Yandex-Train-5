import java.io.*;
import java.util.StringTokenizer;

public class PetyaMashaRopes {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] len = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                len[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int sum = 0;
            int max = 0;
            for (int i = 0; i != n; i++) {
                sum += len[i];
                max = Math.max(max,len[i]);
            }
            int last = sum - max;
            if (last < max) {
                bufferedWriter.write(max - last + "");
            } else {
                bufferedWriter.write(sum + "");
            }
            bufferedWriter.flush();

        }

    }
}

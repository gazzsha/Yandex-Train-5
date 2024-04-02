import java.io.*;
import java.util.StringTokenizer;

public class MishaAndMathematics {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] a = new int[n];
            for (int i = 0; i != n; i++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (Math.abs(value) % 2 == 1) {
                    a[i] = 1;
                } else a[i] = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i != n - 1; i++) {
                if (a[i] == 0 && a[i + 1] == 0) {
                    a[i + 1] = 0;
                    stringBuilder.append('+');
                } else if (a[i] == 1 && a[i+1] == 1) {
                    stringBuilder.append('x');
                } else {
                    stringBuilder.append('+');
                    a[i + 1] = 1;
                }
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class ProfitableStartup {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long n = Integer.parseInt(stringTokenizer.nextToken());
            long k = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            long lastN = n;
            boolean flag = false;
            int i = 0;
            for (; i != d; i++) {
                for (int j = 0; j != 10; j++) {
                    long nNew = n * 10 + j;
                    if (nNew % k == 0) {
                        n = nNew;
                        if (j == 0) {
                            flag = true;
                            i++;
                        }
                        break;
                    }
                }
                if (flag) break;
                if (n == lastN) {
                    n = -1;
                    break;
                } else lastN = n;
            }
            if (n != -1) {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
                stringBuilder.append("0".repeat(Math.max(0, d - i)));
                bufferedWriter.write(stringBuilder.toString());
            } else {
                bufferedWriter.write(-1 + "");
            }
            bufferedWriter.flush();
        }
    }
}

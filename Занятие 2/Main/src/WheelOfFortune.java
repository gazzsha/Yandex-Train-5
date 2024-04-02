import java.io.*;
import java.util.StringTokenizer;

public class WheelOfFortune {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] points = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                points[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int maxPoint = 0;
            int count = 0;
            for (int i = a; count != n && i < b + 1; i+=k) {
                int countRound = (i % k == 0) ? i / k - 1 : i / k;
                maxPoint = Math.max(maxPoint,maxPoint(points,n,countRound,i));
                count++;
            }
            bufferedWriter.write(maxPoint + "");
            bufferedWriter.flush();
        }
    }
    public static int maxPoint(int[] a,int n,int k, int v) {
        return Math.max(a[((-k) % n + ((-k) < 0 ? n : 0))%n],a[(k) % n]);
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class TheMinimumRectangle {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int minXLeft = Integer.MAX_VALUE;
            int minYLeft = Integer.MAX_VALUE;
            int maxXRight = Integer.MIN_VALUE;
            int maxYRight = Integer.MIN_VALUE;
            for (int i = 0; i != n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                minXLeft = Math.min(x,minXLeft);
                maxXRight = Math.max(maxXRight,x);
                minYLeft = Math.min(y,minYLeft);
                maxYRight = Math.max(maxYRight,y);
            }
            bufferedWriter.write(minXLeft + " " + minYLeft + " " + maxXRight + " " + maxYRight);
            bufferedWriter.flush();
            }
    }
}
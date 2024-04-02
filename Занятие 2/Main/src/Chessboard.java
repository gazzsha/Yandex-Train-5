import java.io.*;
import java.util.StringTokenizer;

public class Chessboard {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] desk = new int[8][8];
            int count = 0;
            for (int i = 0; i != n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                desk[x - 1][y - 1] = 1;
                count++;
            }
            int countСommunications = 0;
            for (int i = 0; i != 8; i++) {
                for (int j = 0; j != 8; j++) {
                    if (desk[i][j] == 1) {
                        if ((j != 7 && desk[i][j + 1] == 1)) {
                            countСommunications++;
                        }
                        if ((i != 7 && desk[i + 1][j] == 1)) {
                            countСommunications++;
                        }
                    }
                }
            }
            bufferedWriter.write(count * 4 - countСommunications * 2 + "");
            bufferedWriter.flush();
        }
    }
}

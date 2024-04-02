import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BishopsAndRooks {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int[][] a = new int[8][8];
            List<int[]> xy = new ArrayList<>();
            for (int i = 0; i != 8; i++) {
                String path = bufferedReader.readLine();
                for (int j = 0; j != 8; j++) {
                    if (path.charAt(j) == 'R') {
                        int[] r = new int[3];
                        r[0] = i;
                        r[1] = j;
                        r[2] = 0;
                        xy.add(r);
                        a[i][j] = 5;
                    } else if (path.charAt(j) == 'B') {
                        int[] r = new int[3];
                        r[0] = i;
                        r[1] = j;
                        r[2] = 1;
                        xy.add(r);
                        a[i][j] = 9;
                    } else a[i][j] = 0;
                }
            }
            for (int[] coor : xy) {
                if (coor[2] == 0)
                    R(a,coor[0],coor[1]);
                else B(a,coor[0],coor[1]);
            }
            int count = 0;
            for (int i = 0; i != 8; i++) {
                for (int j = 0; j != 8; j++) {
                    if (a[i][j] == 0) count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void R(int[][] a, int x, int y) {
        for (int i = y + 1; i != 8; i++) {
            if (a[x][i] == 0 || a[x][i] == 1) a[x][i] = 1;
            else break;
        }
        for (int i = y - 1; i >= 0; i--) {
            if (a[x][i] == 0 || a[x][i] == 1) a[x][i] = 1;
            else break;
        }
        for (int i = x + 1; i != 8; i++) {
            if (a[i][y] == 0 || a[i][y] == 1) a[i][y] = 1;
            else break;
        }
        for (int i = x - 1; i >= 0; i--) {
            if (a[i][y] == 0 || a[i][y] == 1) a[i][y] = 1;
            else break;
        }
    }

    public static void B(int[][] a, int xx, int yy) {
        int x = xx - 1;
        int y = yy - 1;
        while (x >= 0 && y >= 0 && (a[x][y] == 0 || a[x][y] == 1)) {
            a[x][y] = 1;
            x--;
            y--;
        }
        x = xx + 1;
        y = yy + 1;
        while (x < 8 && y < 8 && (a[x][y] == 0 || a[x][y] == 1)) {
            a[x][y] = 1;
            x++;
            y++;
        }
        x = xx + 1;
        y = yy - 1;
        while (x < 8 && y >= 0 && (a[x][y] == 0 || a[x][y] == 1)) {
            a[x][y] = 1;
            x++;
            y--;
        }
        x = xx - 1;
        y = yy + 1;
        while (x >= 0 && y < 8 && (a[x][y] == 0 || a[x][y] == 1)) {
            a[x][y] = 1;
            x--;
            y++;
        }
    }
}

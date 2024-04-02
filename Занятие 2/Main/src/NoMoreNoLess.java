import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NoMoreNoLess {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                int len = Integer.parseInt(bufferedReader.readLine());
                int[] a = new int[len];
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j != len; j++) {
                    a[j] = Integer.parseInt(stringTokenizer.nextToken());
                }
                var res = find(a,len);
                bufferedWriter.write(res.size() + "\n");
                for (var elem : res) {
                    bufferedWriter.write(elem + " ");
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
        }
    }
    public static List<Integer> find(int[] a,int len) {
        List<Integer> list = new ArrayList<>();
        int back = 0;
        int minValue = a[0];
        list.add(back);
        for (int i = 0; i != len; i++) {
            if (a[i] >= back + 1 && minValue >= back + 1) {
                list.set(list.size() - 1, list.getLast() + 1);
                minValue = Math.min(minValue,a[i]);
                back++;
            }
            else {
                minValue = a[i];
                back = 1;
                list.add(back);
            }
        }
        return list;
    }

}



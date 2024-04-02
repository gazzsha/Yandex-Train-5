import java.io.*;

public class FormattingTheFile {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
//            int[] a = new int[(int) (10e5 + 1)];
//            for (int i = 0; i != a.length; i++) {
//                if (i < a.length - 1 && (a[i + 1] == 0 || a[i + 1] > a[i] + 1)) {
//                    a[i + 1] = a[i] + 1;
//                }
//                if (i > 0 && a[i - 1] > a[i] + 1) {
//                    a[i - 1] = a[i] + 1;
//                }
//                if (i < a.length - 4 && (a[i + 4] == 0 || a[i + 4] > a[i] + 1)) {
//                    a[i + 4] = a[i] + 1;
//                }
//            }
            int n = Integer.parseInt(bufferedReader.readLine());
            long count = 0;
            for (int i = 0; i != n; i++) {
                int k = Integer.parseInt(bufferedReader.readLine());
                count += count(k);
            }
            bufferedWriter.write(count + "");
            bufferedWriter.flush();
        }
    }
    public static long count(int a) {
        int k = a/4;
        int k_ = a/4 + 1;
        int count = 0;
        int count_ = a;
        if (Math.abs(k_ * 4 - a) < Math.abs(k * 4 - a)) {
            count += k_ * 4 - a + k_ ;
        } else count = Math.abs(k * 4 - a) + k;
//        System.out.println(Math.min(count_,count));
        return Math.min(count_,count);
    }
}

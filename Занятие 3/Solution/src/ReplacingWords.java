import java.io.*;
import java.util.*;

public class ReplacingWords {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<String> set = new TreeSet<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                String s = stringTokenizer.nextToken();
                StringBuilder stringBuilder = new StringBuilder();
                boolean flag = false;
                for (int i = 0; i != s.length(); i++) {
                    stringBuilder.append(s.charAt(i));
                    if (set.contains(stringBuilder.toString())) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) set.add(stringBuilder.toString());
            }
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            List<String> list = new ArrayList<>();
            while (stringTokenizer.hasMoreTokens()) {
                list.add(stringTokenizer.nextToken());
            }
            for (int i = 0; i != list.size(); i++) {
                String s = list.get(i);
                StringBuilder stringBuilder = new StringBuilder();
                boolean flag = false;
                for (int j = 0; j != 100 && j != s.length(); j++) {
                    stringBuilder.append(s.charAt(j));
                    if (set.contains(stringBuilder.toString())) {
                        bufferedWriter.write(stringBuilder.toString() + " ");
                        flag = true;
                        break;
                    }
                }
                if (!flag) bufferedWriter.write(stringBuilder.toString() + " ");
            }
            bufferedWriter.flush();
        }
    }
}
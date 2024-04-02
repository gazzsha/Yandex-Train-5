import java.io.*;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String s = bufferedReader.readLine();
            String p = bufferedReader.readLine();
            int[] sMap = new int[26];
            int[] pMap = new int[26];
            for (int i = 0; i != s.length(); i++) {
                sMap[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i != p.length(); i++) {
                pMap[p.charAt(i) - 'a']++;
            }
            bufferedWriter.write(Arrays.equals(sMap,pMap) ? "YES" : "NO");
            bufferedWriter.flush();
        }
    }
}

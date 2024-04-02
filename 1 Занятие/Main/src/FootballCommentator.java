import java.io.*;
import java.util.StringTokenizer;

public class FootballCommentator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), ":");
            int g1 = Integer.parseInt(stringTokenizer.nextToken());
            int g2 = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), ":");
            int j1 = Integer.parseInt(stringTokenizer.nextToken());
            int j2 = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(bufferedReader.readLine());
            int countGoalsOfOpponent = 0;
            int countGoalsMine = 0;
            if (k == 1) {
                countGoalsOfOpponent = g2;
                countGoalsMine = j1;
            } else {
                countGoalsMine = g1;
                countGoalsOfOpponent = j2;
            }
            if (g1 + j1 > g2 + j2) {
                bufferedWriter.write("0");
            } else if (g1 + j1 == g2 + j2) {
                if (countGoalsMine > countGoalsOfOpponent) {
                    bufferedWriter.write("0");
                } else bufferedWriter.write("1");
            } else {
                int countGoals = g2 + j2 - g1 - j1;
                if (k == 1) {
                    countGoalsMine += countGoals;
                    if (countGoalsMine > countGoalsOfOpponent) {
                        bufferedWriter.write(countGoals + "");
                    } else bufferedWriter.write(countGoals + 1 + "");
                } else {
                    // мы дома
                    if (countGoalsMine > countGoalsOfOpponent) {
                        bufferedWriter.write(countGoals+"");
                    } else bufferedWriter.write(countGoals + 1 + "");
                }
            }
            bufferedWriter.flush();
        }
    }
}

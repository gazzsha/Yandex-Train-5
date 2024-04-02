import java.io.*;

public class OneDimensionalNavalBattle {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Long n = Long.parseLong(bufferedReader.readLine());
            bufferedWriter.write(rightBinarySearch(n) + "");
            bufferedWriter.flush();
        }
    }

    public static Long rightBinarySearch(Long target) {
        Long l = 0L;
        Long r = target / 2 + 1;
        while (l < r) {
            Long mid = (l + (r - l) / 2 + 1);
            if (check(mid, target) <= target) {
                l = mid;
            } else r = mid - 1;
        }
        return l;
    }

    public static Long check(Long k, long n) {
        long sum = 0L;
        long count = 1L;
        if (k % 2 == 0) {
            while (count <= k / 2 && sum >= 0 && sum <= n) {
                sum += count * (k - count + 1);
                count++;
            }
            sum *= 2;
        } else {
            while (count <= k / 2 && sum >= 0 && sum <= n) {
                sum += count * (k - count + 1);
                count++;
            }
            sum *= 2;
            sum += count * (k - count + 1);
        }
        long countOfShips = (long) ((double) (2 + (k - 1)) / 2.d * (double) k);
        if (countOfShips > sum) return sum;
        else return sum + countOfShips - 1;
    }
}

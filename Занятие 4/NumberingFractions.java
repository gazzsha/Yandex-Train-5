import java.io.*;
import java.math.BigInteger;

public class NumberingFractions {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long n = Long.parseLong(bufferedReader.readLine());
            find(n,bufferedWriter);
            bufferedWriter.flush();
        }
    }

    public static void find(long n,BufferedWriter bufferedWriter) throws IOException {
        long d = lBinarySearch(n);
     //   long mod = n - check(d - 1).longValue();
        long mod = check(d).longValue() % n;
        if (d % 2 == 0) {
//            bufferedWriter.write((d - mod + 1) + "/" + mod);
//            bufferedWriter.newLine();
//            bufferedWriter.newLine();
     //       bufferedWriter.write((1 + mod) + "/" + (d - mod));
            bufferedWriter.write((1 + mod) + "/" + (d - mod));
      //      bufferedWriter.write(  mod + "/" + (d - mod + 1));
        } else {
         //   bufferedWriter.write((1 + mod) + "/" + (d - mod));
            bufferedWriter.write( d - mod + "/" + (1 + mod));
        }
    }

    public static long lBinarySearch(long target) {
        long l = 1;
        long r = target;
        while (l < r) {
            long mid = (l + (r - l) / 2);
            if (check(mid).compareTo(BigInteger.valueOf(target)) >= 0) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static BigInteger check(long a) {
        BigInteger add = BigInteger.valueOf(a - 1).add(BigInteger.valueOf(2L));
        BigInteger divide = add.multiply(BigInteger.valueOf(a)).divide(BigInteger.valueOf(2));
        return divide;
        //return (long) (((double) 2 + (a - 1)) / 2.d * (double) a);
    }
//    179470704/1234742859;
//    179470721/1234742842
}



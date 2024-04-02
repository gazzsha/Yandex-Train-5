import java.io.*;

public class DestroyTheBarracks {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int x = Integer.parseInt(bufferedReader.readLine());
            int y = Integer.parseInt(bufferedReader.readLine());
            int p = Integer.parseInt(bufferedReader.readLine());
            int k = 0;
            int countOfOpponents = 0;
            int countOfRemainingSoldiers = x;
            int l = search(y,x,countOfOpponents,countOfRemainingSoldiers,k,p);
//            if (y + countOfOpponents - x > 0) bufferedWriter.write(-1 + "");
//            else bufferedWriter.write( k + 1  + "");
//            bufferedWriter.flush();
            System.out.println(l);
        }
    }

    public static int search(int y,int x,int countOfOpponents,int countOfRemainingSoldiers,int k,int p) {
        while (y + countOfOpponents - x > 0 && x > 0) {
            if (y > 0) {
                if (countOfOpponents > 0) {
                    int l1 = -1;
                    int l2 = -1;
                    if (countOfRemainingSoldiers >= y
                            && countOfOpponents - 2 * (countOfRemainingSoldiers - y) <= x - (countOfOpponents - (countOfRemainingSoldiers - y))) {

                        l1 = search(0, x - (countOfOpponents - (countOfRemainingSoldiers - y)),
                                countOfOpponents - (countOfRemainingSoldiers - y),x - (countOfOpponents - (countOfRemainingSoldiers - y)), k + 1,p);
//                        x -= (countOfOpponents - (countOfRemainingSoldiers - y));
//                        countOfOpponents = countOfOpponents - (countOfRemainingSoldiers - y);
//                        y = 0;
//                        countOfRemainingSoldiers = x;
                    }
                    if (x > countOfOpponents) {
                        l2 = search(y -  x + countOfOpponents,x,y -  x + countOfOpponents > 0 ? p : 0,x,k + 1,p);
//                        countOfRemainingSoldiers = x - countOfOpponents;
//                        countOfOpponents = 0;
//                        y -= countOfRemainingSoldiers;
//                        countOfRemainingSoldiers = x;
                    }
                    if (l1 != -1 && l2 != -1) return Math.min(l1,l2);
                    else if (l1 != -1) return l1;
                    else return l2;
                } else {
                    y -= countOfRemainingSoldiers;
                }
            } else {
                countOfOpponents -= x;
                x -= countOfOpponents;
                countOfRemainingSoldiers = x;
            }
            k++;
            if (y > 0) countOfOpponents += p;
        }
        if (y + countOfOpponents - x > 0) return -1;
        return k + 1;
    }
}

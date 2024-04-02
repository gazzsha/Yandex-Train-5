import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Schedule {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int year = Integer.parseInt(bufferedReader.readLine());
            String[] holidays = new String[n];
            for (int i = 0; i != n; i++) {
                holidays[i] = bufferedReader.readLine();
            }
            DayOfWeek[] holidaysInWeek = new DayOfWeek[n];
            String firstDayInYear = bufferedReader.readLine();
            LocalDate localDate = LocalDate.of(year, 1, 1);
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> mapHolidays = new HashMap<>();
            int[] days = new int[7];
            while (localDate.getYear() < year + 1) {
//                if (!map.containsKey(localDate.getDayOfWeek().getValue())) {
//                    map.put(localDate.getDayOfWeek().getValue(),1);
//                } else map.put(localDate.getDayOfWeek().getValue(),map.get(localDate.getDayOfWeek().getValue()) + 1);
                days[localDate.getDayOfWeek().getValue() - 1]++;
                localDate = localDate.plusDays(1);
            }
            int[] holidaysDays = new int[7];
            for (int i = 0; i != holidays.length; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(holidays[i]);
                int day = Integer.parseInt(stringTokenizer.nextToken());
                String month = stringTokenizer.nextToken().toUpperCase();
                holidaysDays[LocalDate.of(year, Month.valueOf(month), day).getDayOfWeek().getValue() - 1]++;
//                String month = stringTokenizer.nextToken().toUpperCase();
//                if (!mapHolidays.containsKey( LocalDate.of(year, Month.valueOf(month),day).getDayOfWeek().getValue())) {
//                    mapHolidays.put( LocalDate.of(year, Month.valueOf(month),day).getDayOfWeek().getValue(),1);
//                } else mapHolidays.put( LocalDate.of(year, Month.valueOf(month),day).getDayOfWeek().getValue(),mapHolidays.get( LocalDate.of(year, Month.valueOf(month),day).getDayOfWeek().getValue()) + 1);
                //    map.put(LocalDate.of(year, Month.valueOf(month),day).getDayOfWeek().getValue(),map.get(LocalDate.of(year, Month.valueOf(month),day).getDayOfWeek().getValue()) + 1);
            }
            for (int i = 0; i != days.length; i++) {
                for (int j = 0; j != days.length; j++) {
                    if (i != j) days[i] += holidaysDays[j];
                }
            }
            int minDay = days[0];
            int maxDay = days[1];
            int dayMax = 2;
            int dayMin = 1;
            for (int i = 0; i != days.length; i++) {
                if (days[i] > maxDay) {
                    maxDay = days[i];
                    dayMax = i + 1;
                }
                if (days[i] < minDay) {
                    minDay = days[i];
                    dayMin = i + 1;
                }
            }

            List<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).toList();
            String s1 = DayOfWeek.of(dayMax).toString().substring(0, 1).toUpperCase() + DayOfWeek.of(dayMax).toString().toLowerCase().substring(1);
            String s2 = DayOfWeek.of(dayMin).toString().substring(0, 1).toUpperCase() + DayOfWeek.of(dayMin).toString().toLowerCase().substring(1);

            bufferedWriter.write(s1 + " " + s2);
            bufferedWriter.flush();
        }
    }
}

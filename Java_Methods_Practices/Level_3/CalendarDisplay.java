import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDisplay {

    public static String monthName(int month) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        if (month < 1 || month > 12) return "Invalid";
        return months[month - 1];
    }

    public static boolean isLeap(int year) {
        return (year%4==0 && year%100!=0) || (year%400==0);
    }

    public static int daysInMonth(int month, int year) {
        int[] mdays = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeap(year)) return 29;
        return mdays[month - 1];
    }

    // Zeller's Congruence to find day of week (0=Sunday)
    public static int firstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;
        Calendar cal = new GregorianCalendar(y, m-1, 1);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static void displayCalendar(int month, int year) {
        System.out.println("    " + monthName(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int first = firstDayOfMonth(month, year);
        int days = daysInMonth(month, year);
        for (int i = 0; i < first; i++) System.out.print("   ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%2d ", d);
            if ((first + d) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void demo() {
        displayCalendar(7, 2005); // sample from prompt
    }
}

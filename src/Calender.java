import java.time.LocalDate;
import java.util.Scanner;


public class Calender {
    int WIDTH = 10;

    public static void main(String[] args) {
        Calender calender = new Calender();
        calender.printCalender();
    }
// we connected all other method inside printCalender.
    public void printCalender(){
        // Scanner
        System.out.println("Rahat");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Calender Month(1-12): ");
        int month = scan.nextInt();
        System.out.println("Enter the Calender Year (YYYY): ");
        int year = scan.nextInt();

        // method call

        int day = 1;
        printHeader(month,year);

        int dayOfWeek = getDayOfWeek(year,month,day);
        int daysInMonth = getLengthOfMonth(year,month,day);
        int currentDay = day;

        while (currentDay <= daysInMonth) {
            currentDay = printWeek(currentDay, dayOfWeek, daysInMonth);
            dayOfWeek = 0; // every row of calendar after the first starts on Sunday
        }

    }

    public String spaces(int numSpace){
        String space = "";
        for(int i = 0; i < numSpace; i++){
            space += " ";
        }
        return space;
    }

    public void printHeader(int mo,int yr){
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String month = months[mo-1];
        String monthYear = month + " " + yr;
        int leadSpace = (WIDTH - monthYear.length()/2);
        System.out.println("\n" + spaces(leadSpace) + monthYear);
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    public int getDayOfWeek(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getValue();
    }

    public int getLengthOfMonth(int year, int month, int day ) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.lengthOfMonth();
    }

    public int printWeek(int dayNumber, int weekday, int daysInMonth){
        System.out.print(spaces(weekday * 3));
        while (weekday <= 6 && dayNumber <= daysInMonth){
            System.out.printf("%2d ", dayNumber);
            weekday++;
            dayNumber++;
        }
        System.out.println();
        return dayNumber;
    }
}

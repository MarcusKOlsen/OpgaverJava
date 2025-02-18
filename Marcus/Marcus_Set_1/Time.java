import java.util.Scanner;

public class Time {
    /**
     * 
     * @param hours
     * @param minutes
     * @param seconds
     * 
     * Penis
     */
    public static void main(String[] args) {
        Scanner scanman = new Scanner(System.in);
        System.out.println("How many hours? ");
            int hours = Integer.parseInt(scanman.nextLine()); 

        System.out.println("How many minutes? ");
            int minutes = Integer.parseInt(scanman.nextLine()); 

        System.out.println("How many seconds? ");
            int seconds = Integer.parseInt(scanman.nextLine());

        // Prints out the result of convert_to_seconds
        System.out.println(convert_to_seconds(hours, minutes, seconds));
        scanman.close();
    }
    public static int convert_to_seconds(int hour, int minute, int second) {
        // Converts hours, minutes and seconds into a total in seconds
        return  (
                (hour * 360) + 
                (minute * 60) +
                second
                );
    }
}

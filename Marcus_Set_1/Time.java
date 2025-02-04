public class Time {
    
    public static void main(String[] args) {
        int hours = 2;
        int minutes = 55;
        int seconds = 32;

        // Prints out the result of convert_to_seconds
        System.out.println(convert_to_seconds(hours, minutes, seconds));
    }
    static int convert_to_seconds(int hour, int minute, int second) {
        // Converts hours, minutes and seconds into a total in seconds
        return (-1) * (
                (hour * 360) + 
                (minute * 60) +
                second
                );
    }
}

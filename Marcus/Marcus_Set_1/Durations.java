import java.util.Arrays;
import java.util.Scanner;

public class Durations {
    public static void main(String[] args){
        Scanner scanman = new Scanner(System.in);
        System.out.println("How many seconds?: ");
        
        int seconds = Integer.parseInt(scanman.nextLine());
        System.out.println(Arrays.toString(convert_to_timeframe(seconds)));

        scanman.close();
    }

    public static int[] convert_to_timeframe(int second) {
        int z = second;
        int x;
        int y;

        // x is how many times 360 occurs in z
        x = z / 360;
        // Keeps the remainder after this calculation
        z = z % 360;

        // y is how many times 60 occurs in z
        y = z / 60;
        // Keeps the remainder from this calculation
        z = z % 60;

        // Creates an integer array, where x = hours, y = minutes, z = seconds.
        int[] L = {x, y, z};

        return L;
    }
}

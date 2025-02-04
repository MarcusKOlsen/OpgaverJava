import java.util.Arrays;

public class Durations {
    public static void main(String[] args){
        int seconds = 500;
        System.out.println(Arrays.toString(convert_to_timeframe(seconds)));

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

import java.util.ArrayList;
import java.util.Collections;

public class random_list {
    public static ArrayList<Integer> makeRandomList(int n){
        System.out.println("Generating lists... ");
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
        randomList.add(i);
        
        }
        Collections.shuffle(randomList);
        return randomList;
    }
}
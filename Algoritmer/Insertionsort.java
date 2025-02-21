import java.util.ArrayList;

public class Insertionsort {
    static long time;
    public static ArrayList<Integer> insertion_sort(ArrayList<Integer> A, int n){
        time = System.currentTimeMillis();
        System.out.println("Starting sort... ");
        for(int i = 0; i < n; i++) {
            int key = A.get(i);
            int j = i - 1;

            while(j >= 0 && A.get(j) > key) {
                A.set(j+1, A.get(j));
                j--;
            }
            A.set(j+1, key);
        }
        

        time = System.currentTimeMillis() - time;
        

        return A;
    }
    public static void main(String[] args) {
        ArrayList<Integer> penis = random_list.makeRandomList(100000);
        ArrayList<Integer> balls = insertion_sort(penis, penis.size());
 
        for(int i = 0; i < balls.size(); i++) {
            System.out.println(Integer.toString(balls.get(i)));
        }
        System.out.println("time: " + Long.toString(time));
    }
}
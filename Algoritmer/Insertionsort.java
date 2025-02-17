import java.util.ArrayList;

public class Insertionsort {
    public static ArrayList<Integer> insertion_sort(ArrayList<Integer> A, int n){
        for(int i = 0; i < n; i++) {
            int key = A.get(i);
            int j = i - 1;

            while(j >= 0 && A.get(j) > key) {
                A.set(j+1, A.get(j));
                j--;
            }
            A.set(j+1, key);
        }
        return A;
    }
    public static void main(String[] args) {
        ArrayList<Integer> penis = new ArrayList<Integer>();
        penis.add(5);
        penis.add(3);
        penis.add(4);
        penis.add(6);
        penis.add(4);
        penis.add(1);

        ArrayList<Integer> balls = insertion_sort(penis, penis.size());
        for(int i = 0; i < balls.size(); i++) {
            System.out.println(Integer.toString(balls.get(i)));
        }
    }
}
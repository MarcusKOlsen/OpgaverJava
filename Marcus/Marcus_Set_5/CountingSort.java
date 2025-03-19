public class CountingSort {

    public int[] convert_to_int(String text) {
        char[] letters = text.toCharArray();
        int[] temp = new int[letters.length];

        for(int i = 0; i < letters.length; i++) {
            temp[i] = (int)letters[i];
        }
        
        return temp;
    }

    public static int[] sort_bible(int[] A){
        int[] B = A.clone();

        int[] C = new int[255];

        for(int i = 0; i < C.length; i++) {
            C[i] = 0;
        }
        for(int j = 0; j < B.length; j++ ) {
            C[A[j]] = C[A[j]] + 1;
        }
        for(int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i-1];
        }
        for(int j = B.length - 1; j > 0; j--) {
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
        return B;
    }
    public static void main(String[] args) {
        int[] test = {3,1,2,0,5,3,2,5};
        for(int i : sort_bible(test)) {
            System.out.println(Integer.toString(i));
        }
    }
}
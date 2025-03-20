package David.Øvelsessæt_2;

public class Arrays2D {
    public static void printLengths(int[][] m){
        for(int i = 0; i < m.length;i++){
            System.out.println(Integer.toString((m[i].length)));
        }
    }
    public static int maxLength(int[][] m){
        int max = m[0].length;
        for (int i = 1; i < m.length; i++){
            if (m[i].length > max ){
                max = m[i].length;
            }
        }
        return max;
    }
    public static int totalLength(int[][] m){
        int sum = 0;
        for (int i = 0; i < m.length;i++){
            sum = sum +m[i].length;
        }
        return sum;
    }
    public static int count(int[][] m, int n){
        int count = 0;
        for (int i = 0; i < m.length;i++){
            int j = 0;
            while (j < m[i].length){
                if (m[i][j] == n){
                    count++;
                }
                j++;
            }
        }
    return count;
    }
    public static int max(int[][] m){
        int max = m[0][0];
        for (int i = 0; i < m.length;i++){
            for (int j = 0; i < m[i].length;j++){
                if (m[i][j] > max){
                    max = m[i][j];
                }
            }
        }
        return max;
    }
    public static void increment(int[][] m){
        for (int i = 0; i < m.length;i++){
            for (int j = 0; i < m[i].length;j++){ m[i][j]++;}
        }
    }

    public static void parity(int[][] m){
        for (int i = 0; i < m.length;i++){
            for (int j = 0; i < m[i].length;j++){
                 if (m[i][j] % 2 == 0){
                    m[i][j] = 0;
                 }
                 else{
                    m[i][j] = 1;
                 }
             }
         }
    }
}

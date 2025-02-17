package David.Øvelsessæt_2;

import java.util.ArrayList;

public class Arrays {
    public static int sum(int[] v){
        int i = 0;
        int summing = 0;
        while (i < v.length){
            summing = v[i] + summing;
            i++;
        }
        return summing;
    }
    public static int count(int[] v, int n){
        int i = 0;
        int counting = 0;
        while (i < v.length){
            if (v[i] == n){
                counting++;
            }
            i++;
        }
        return counting;
    }
    public static int smallerThan(int[] v, int n){
        int i = 0;
        int counting = 0;
        while (i < v.length){
            if (v[i] < n){
                counting++;
            }
            i++;
        }
        return counting;
    }

    public static String Stringify(int[] v){
        int i = 0;
        String text = "";
        while ( i< v.length){
            text = text + Integer.toString(v[i]);
            i++;
        }
        return text;
    }
    public static int[] squares(int[] v){
        int i = 0;
        int[] squarednmb = new int[v.length];
        while(i < v.length){
            squarednmb[i] = v[i]*v[i];
            i++;
        }
        return squarednmb;
    } 
    public static int[] reversed(int[] v){
        int i = 0;
        int[] reversedlist = new int[v.length];
        while(i < v.length){
            reversedlist[i] = v[v.length-i];
            i++;
        }
        return reversedlist;
    }
    public static int[] decreasingSquares(int n){
        int[] arr = new int[n];
        int i = n;
        while(n > i){
            arr[n-i] = n^2;
            i++;
        }
        return arr;
    }
    public static int[] divisors(int n){
       
        int i = 1;
        ArrayList<Integer> divisor = new ArrayList<>();
        while(i <= n/2){
            if(n%i == 0){
                divisor.add(i);
            }
            i++;
            }
        int[] end = new int[divisor.size()];
        for(int j = 0; j < divisor.size(); j++){
            end[j] = divisor.get(j);
        }
            
        return end; 
    }

    public static int max(int[] v){
        
    }
}

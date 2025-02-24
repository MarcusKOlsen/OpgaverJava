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
            return listToArray(divisor);
        }
    public static int max(int[] v){
        int big = v[0];
        for(int i = 1; i < v.length; i++){
            if (v[i] > big){
                big = v[i];
            }
        }
        return big;
    } 
    public static boolean subset(int[] v, int[] w){
        int i = 0;
        int j = 0;
        while (i < v.length && j < v.length){
                if (v[i] == w[j]){
                    i++;
                    j = 0;
                }
                else j++;

            }
        //Returns True if the loop stops because of the entire of v being gone through.
        return i == v.length;
        } 
    public static int[] intersection(int[] v, int[] w){
        ArrayList<Integer> intersec = new ArrayList<>();
        for (int i = 0; i < v.length; i++){
            for (int j = 0; j < w.length;j++ ){
                if(v[i] == v[j]){
                    intersec.add(v[i]);
                    i++;
                    j = 0;
                }
                
                    j++;
                
            }
        }
        return listToArray(intersec);
    }
    public static int firstPositionMax(int[] v){
        int save = 0;
        for (int i = 1; i < v.length; i++){
            if(v[i] > v[save]){
                save = i;
            }
        }
        return save;
    }
    public static int lastPositionMax(int[] v){
        int save = 0;
        for (int i = 1; i < v.length; i++){
            if(v[i] >= v[save]){
                save = i;
            }
        }
        return save;
    }
    public static int[] positionMax(int[] v){
        int big = v[0];
        ArrayList<Integer> positions = new ArrayList<>(0);
        for (int i = 1; i < v.length; i++){
            if (big == v[i]){
                positions.add(i);
            
            }
            else if(v[i] > big){
                positions.clear();
                positions.add(i);
                big = v[i];
            }
            i++;
        }
        return listToArray(positions);

    } 
    public static void square(int[] v){
        for(int i = 0; i < v.length; i++){
            v[i] = v[i]*v[i];
        }
    }
    public static void reverse(int[] v){
        int temp;
        for (int i = 0; i < v.length/2; i++){
            temp = v[i];
            v[i] = v[v.length-i];
            v[v.length-i] = temp;
        }
    }
    public static int[] join(int[] v, int[] w){
        int[] joined = new int[v.length+w.length];
        int i = 0;
        while( i < v.length){
           joined[i] = v[i];
           i++; 
        }
        for(int j = 0; j < w.length;j++){
            joined[i+j] = v[j]; 
        }
        return joined;
    }
    public static int[] sortedJoin(int[] v, int[] w){
        int[] joined = new int[v.length+w.length];
        int i = 0;
        int j = 0;
        while (i + j < v.length + w.length ){
            if ( j == w.length){
                joined[i+j] = v[i];
                i++;
            }
            else if (i == v.length){
                joined[i+j] = w[j];
                j++;
            }
            else if (v[i] > w[j]){
                joined[i+j] = w[j];
                j++;
            }
            else{
                joined[i+j] = v[i];
                i++;
            }
    
        }
        return joined;
        }
    public static int[] shuffle(int[] v, int[]w){
       
        //Kræver de to lister er lige lange
        int[] joined = new int[v.length*2];
        for(int i = 0; i < v.length;i++ ){
            joined[i*2] = v[i];
            joined[i*2+1] = w[i];
        }
        return joined;
    }
    public static boolean isSorted(int[] v){
        boolean current = true;
        int i = 1;
        while ( i < v.length && current){
            current = v[i-1] <= v[i];
            i++;
        }
        return current;
    }
    public static int[] listToArray(ArrayList<Integer> v){
        int[] list = new int[v.size()];
        for(int i = 0; i < v.size(); i++){
            list[i] = v.get(i);
        }   
        return list; 
    }
    }
    

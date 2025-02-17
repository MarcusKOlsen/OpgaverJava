package Marcus_Set_2;

public class Numbers {
    public static void main(String[] args){
        System.out.println(Integer.toString(factorial(5)));
    }
    public static void printMultiples(int k, int n) {
        int i = 1;
        while (n > i) {
            if (k % i == 0) {
                System.out.println(Integer.toString(i));
            }
            i++;
        }
    }    
    public static int sumUpTo(int n) {
        int i = 0;
        int sum = 0;
        while( i <= n ) {
            sum += i;
            i++;
        }
        return sum;
        
    }
    public static int sumBetween(int m, int n) {
        int i = m + 1;
        int sum = 0;

        while( i < n) {
            sum += i;
            i++;
        }
        return sum;
    }
    public static int sumEven(int m, int n) {
        int i = m + 1;
        int sum = 0;

        if (i % 2 != 0) {
            i++;
        }

        while(i < n) {
            sum += i;
            i+= 2;
        }
        return sum;
    }
    public static int factorial(int n) {
        // requres n <= 0
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);    
        }
    }
    public static int doubleFactorial(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * doubleFactorial(n-2);    
        }
    }
}

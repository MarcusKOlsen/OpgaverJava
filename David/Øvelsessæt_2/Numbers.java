package David.Øvelsessæt_2;

public class Numbers {
    public static void printMultiples(int k, int n){
        int i = 0;
        while (i<n){
            System.out.println(i);
            i = i + k;
        }
    }
    public static int sumUpTo(int n){
        if (n <= 0){
            return 0;
        }
        else{
            return sumUpTo(n-1) + n-1;
        }
    }
    public static int sumBetween(int m, int n){
        if (m >= n ){
            return 0;
        }
        else{
            return sumBetween(m+1, n);
        }
    }


    public static int sumEven(int m, int n){
        m++;
        if (m%2 == 1){
            m++;
        }
        
        int sum = 0;
        while (m<n){
        sum = sum + m;
        m = m + 2;    
        }
        return sum;
     }
    public static int factorial(int n){
        if (n <= 0){
            return 1;
        }
        else{
            return factorial(n-1)*n;
        }
    }
    public static int doubleFactorial(int n){
        if (n <= 0){
            return 1;
        }
        else{
            return factorial(n-2)*n;
        }
    }
    public static int fibonacci(int n){
        int current = 1;
        int last = 0;
        int i = 2;
        while(i < n){
            current = current + last;
            last = current - last;
            i++;
        }
        return current;
    }
    public static int log2(int n){
        int i = 0;
        while (n>2){
           n = n/2;
           i++;

        }
        return i;
    }
    public static int triangular(int n){
        return sumUpTo(n+1);
    }
    public static int hexagonal(int n){
        return sumUpTo(n*2-1);
    }
    public static int countDivisors(int n){
        int i = 1;
        int amount = 0;
        while(i<=n/2){
            if(n%i == 0){
                amount++;
            }
        i++;
        }
        return amount;
    }
    public static boolean isPerfect(int n){
        int i = 0;
        int sum = 0;
        while(i<=n/2){
            if(n%i == 0){
                sum = sum + i;
            }
        i++;
        }
        return sum == n;
    }
    public static int countPerfect(int n){
        int i = 0;
        int amount = 0;
        while(i < n){
            if (isPerfect(i)){
                amount++;
            }
        i++;
        }
        return amount;
    }

    public static boolean isPrime(int n){
        return (countDivisors(n) == 0);
    }
    public static int countPrime(int n){
        int i = 1;
        int amount = 0;
        while (i<n){
            if (isPrime(i)){
                amount++;
            }
        i++;
        }
        return amount;
    }
    public static int largestDifference(int n){
        int last_prime = 0;
        int difference = 0;
        int i = 0;
        while(i<n){
            if (isPrime(i)){
                if (i-last_prime > difference){
                    difference = i- last_prime;
                }
            last_prime = i;
            }
        i++;
        }
    return difference;    
    }

    public static int lcm(int m, int n){
        return m*n/gcd(m,n);
    }
    public static int gcd(int m, int n){
        if (m%n == 0){
            return n;
        }
        else{
            return gcd(n,m%n);
        }
    }
    public static int hofstadterF(int n){
        if (n == 0){
            return 1;
        }
        else{
            return n-hofstadterM(hofstadterF(n-1));
        }
    }
    public static int hofstadterM(int n){
        if (n == 0){
            return 0;
        }
        else{
            return n-hofstadterF(hofstadterM(n-1));
        }
    }
}

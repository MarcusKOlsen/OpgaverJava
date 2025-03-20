public class Fraction {
    private int tæller;
    private int nævner;

    public Fraction() {
        this.nævner = 1;
        this.tæller = 1;
    }

    public Fraction(int tæller) {
        this(tæller, 1);
    }

    /**
     * @param tæller
     * @param nævner må ikke være 0
     */
    public Fraction(int tæller, int nævner) {
        assert nævner != 0; // for debugging
        this.tæller = tæller;
        this.nævner = nævner;
    }

    public Fraction divide(Fraction b) {

        if (b.tæller == 0) {
            throw new ArithmeticException("divide by zero error");
        }

        int newTæller = this.tæller * b.nævner;
        int newNævner = this.nævner * b.tæller;

        return new Fraction(newTæller, newNævner);
    }

    public Fraction multiply(Fraction b){

        int newTæller = this.tæller * b.tæller;
        int newNævner = this.nævner * b.nævner;

        return new Fraction(newTæller,newNævner);

    }

    public Fraction subtract(Fraction b){
        
        int newNævner = lcm(this.nævner,b.nævner);
        int newTæller = newNævner/this.nævner*this.tæller - newNævner/b.nævner*b.tæller;

        return new Fraction(newTæller,newNævner);
    }

    public Fraction add(Fraction b){
        
        int newNævner = lcm(this.nævner,b.nævner);
        int newTæller = newNævner/this.nævner*this.tæller + newNævner/b.nævner*b.tæller;

        return new Fraction(newTæller,newNævner);
    }

    public void simplify(){

        int divisor = gcd(tæller, nævner);
        this.tæller = this.tæller/divisor;
        this.nævner = this.nævner/divisor;

    }

    public double value(){

        double aprox = this.tæller/this.nævner;
        return aprox;
    }

    public int integerPart(){

        return this.tæller/this.nævner;

    }

    public Fraction properPart(){

        int newtæller = this.tæller%this.nævner;

        return new Fraction(newtæller,this.nævner);
    }


    public Fraction clone(){

        return new Fraction(this.tæller,this.nævner);
    }

    public String toString(){

        return (Integer.toString(this.tæller) + "/" + Integer.toString(this.nævner) );   
    }

    private static int gcd(int m, int n){
        if (m%n == 0){
            return n;
        }
        else{
            return gcd(n,m%n);
        }
    }

    private static int lcm(int m, int n){
        return m*n/gcd(m,n);
    }



}

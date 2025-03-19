package Marcus.Marcus_Set_4;

public class Fraction {
    int top;
    int bottom;


    public Fraction() {
        this.top = 1;
        this.bottom = 1;
    }
    public Fraction(int x) {
        this.top = x;
        this.bottom = 1;
    }
    public Fraction(int x, int y) {
        this.top = x;
        this.bottom = y;
    }

    public int get_denominator(){
        return this.top;
    }
    public int get_numerator(){
        return this.bottom;
    }

    public void set_denominator(int x){
        this.top = x;
    }

    public void set_numerator(int x){
        this.bottom = x;

    }

    public Fraction add(Fraction b) {
        Fraction temp = new Fraction(this.top, this.bottom);
        temp.set_denominator(this.top + b.get_denominator());
        temp.set_numerator(this.bottom + b.get_numerator());

        return temp;
    }

    public Fraction subtract(Fraction b) {
        Fraction temp = new Fraction(this.top, this.bottom);

        int a_top = temp.get_denominator();
        int a_bot = temp.get_numerator();

        int b_top = b.get_denominator();
        int b_bot = b.get_numerator();

        assert a_top >= b_top;
        assert a_bot  >= b_bot;

        temp.set_denominator(a_top - b_top);
        temp.set_numerator(a_bot - b_bot);

        return temp;
    }

    public Fraction multiply(Fraction b) {
        Fraction temp = new Fraction(this.top, this.bottom);

        int a_top = temp.get_denominator();
        int a_bot = temp.get_numerator();

        int b_top = b.get_denominator();
        int b_bot = b.get_numerator();

        temp.set_denominator(a_top * b_top);
        temp.set_numerator(a_bot * b_bot);

        return temp;
    }

    public Fraction divide(Fraction b){
        Fraction temp = new Fraction(this.top, this.bottom);

        int a_top = temp.get_denominator();
        int a_bot = temp.get_numerator();

        int b_top = b.get_denominator();
        int b_bot = b.get_numerator();

        temp.set_denominator(a_top / b_top);
        temp.set_numerator(a_bot / b_bot);

    
        return temp;
    }

    public void simplify(){

        int x = gcd(this.top, this.bottom);

        this.top /= x;
        this.bottom /= x;
    }

    int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        else {
            return gcd(b, a%b);
        }
    }

    public double value(){
        return (double)this.top / this.bottom;
    }

    public int integer_part(){
        return this.top / this.bottom;
        // heltalsdivision
    }

    public Fraction proper_part(){
        return new Fraction(this.top % this.bottom, this.bottom);
    }


    public Fraction clone(){
        return new Fraction(this.top, this.bottom);
    }

    public String to_string(){
        return Integer.toString(this.top) + " / " + Integer.toString(this.bottom);
    }
}
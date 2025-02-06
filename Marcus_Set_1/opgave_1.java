public class opgave_1 {
    public static void main(String[] args){

        // 1 Typer, operatorer, variable og udtryk

        //  1.1
        short age;
        float weight;
        int income;
        byte civil_state;
        long distance_to_earth;
        long distance_between_objects;

        System.out.println("Opgave 1.2: ");
        opgave1_2();

        System.out.println("Opgave 1.3: ");
        opgave1_3();
    }
            
    public static void opgave1_2() {
        int I = 3;
        double D = 2.19;

        int a = I + 3 * I;
        System.out.println("a: " + Integer.toString(a));

        double b = (I + 3.0) * I;
        System.out.println("b: " + Double.toString(b));

        int c = 45 - I + 23;
        System.out.println("c: " + Integer.toString(c));

        double d = 3.24 + I * 3;
        System.out.println("d: " + Double.toString(d));

        double e = 2 * 5.0 / I + 3;
        System.out.println("e: " + Double.toString(e));

        int f = 2 * 5 / I + 3;
        System.out.println("f: " + Integer.toString(f));

        double g = 4 - D + I / 2;
        System.out.println("g: " + Double.toString(g));

        double h = (D + 2) / I;
        System.out.println("h: " + Double.toString(h));
    }
    public static void opgave1_3(){
        System.out.println("(a)");
        int j = 2;
        int i = 1;
        j = 3 + i * 2;
        i = j / 2 * i + 3;
        i = i + 1;
        System.out.println("i: " + Integer.toString(i));
        System.out.println("j: " + Integer.toString(j));

        System.out.println("(b)");
        i = 3;
        double d = 3.0;
        d = d - 2.3;
        i = (int) d;
        System.out.println("i: " + Integer.toString(i));
        System.out.println("d: " + Double.toString(d));
    
        System.out.println("(c)");
        int x;
        int y = 4;
        x = y + y;
        System.out.println("x: " + Integer.toString(x));
        System.out.println("y: " + Integer.toString(y));

        System.out.println("(d)");
        double b = 3.1;
        double c = 0.0;
        c = c + 2.0;
        b = b - (c + 3.0);
        i = (int) (c + b);
        i = i - 1;
        System.out.println("i: " + Integer.toString(i));
        System.out.println("b: " + Double.toString(b));
        System.out.println("c: " + Double.toString(c));

        System.out.println("(e)");
        x = 5;
        y = x;
        x = x + y;
        System.out.println("x: " + Integer.toString(x));
        System.out.println("y: " + Integer.toString(y));

        System.out.println("(f)");
        y = 4;
        int z = 3;
        x = y / z;
        System.out.println("y: " + Integer.toString(y));
        System.out.println("z: " + Integer.toString(z));
        System.out.println("x: " + Integer.toString(x));
    }
}
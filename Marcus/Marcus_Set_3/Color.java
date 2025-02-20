public class Color {

    int this_red;
    int this_green;
    int this_blue;
    int this_rgb;

    public static Color BLACK = new Color(0,0,0);
    public static Color WHITE = new Color(255,255,255);
    public static Color GRAY = new Color(128,128,128);
    public static Color RED = new Color(255,0,0);
    public static Color MAROON = new Color(128,0,0);
    public static Color LIME = new Color(50,205,50);
    public static Color GREEN = new Color(0,255,0);
    public static Color NAVY = new Color(0,0,50);
    public static Color YELLOW = new Color(255,255,0);
    public static Color MAGENTA = new Color(255,0,255);
    public static Color CYAN = new Color(0,255,255);
    public static Color PINK = new Color(255,192,203);
    public static Color ORANGE = new Color(255,165,0);

    public Color(int rgb){   
        this_rgb = rgb;    
    }
    public Color(int red, int green, int blue) {
        // Requires all int values being between 0 and 255.
        this_red = red;
        this_green = green;
        this_blue = blue;
    }
    public int red(){
        return this_red;
    }

    public int green() {
        return this_green;
    }

    public int blue(){
        return this_blue;
    }

    public int rgb(){
        return this_rgb;
    }
}
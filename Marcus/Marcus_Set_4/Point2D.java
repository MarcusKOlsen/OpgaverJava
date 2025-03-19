package Marcus.Marcus_Set_4;

public class Point2D {
    double x = 0;
    double y = 0;

    public Point2D(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public Double get_x(){
        return this.x;
    }
    public Double get_y(){
        return this.y;
    }


    public boolean is_origin(){
        return x == 0 && y == 0;
    }

    public void move(Double delta_x, Double delta_y) {
        this.x += delta_x;
        this.y += delta_y;
    }

    public Double distance_to_origin(){
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }
    
    public Double distance_to(Point2D p) {
        double distance_x = this.x - p.get_x();
        double distance_y = this.y - p.get_y();
        return Math.sqrt((distance_x * distance_x) + (distance_y * distance_y));
    }

    public Point2D clone(){
        return new Point2D(this.x, this.y);
    }

    public String to_string() {
        return "(" + Double.toString(this.x) + ", " + Double.toString(this.y) + ")";
    }
}

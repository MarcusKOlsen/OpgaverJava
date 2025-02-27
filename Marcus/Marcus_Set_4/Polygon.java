package Marcus.Marcus_Set_4;

public class Polygon {
    Point2D[] corners;

    public Polygon(Point2D[] p) {
        this.corners = p;
    }

    public Point2D[] get_corners(){
        return this.corners;
    }

    public void set_corner(int i, Point2D p){
        this.corners[i] = p;
    }

    public double perimeter(){
        double temp = this.corners[this.corners.length-1].distance_to(this.corners[0]);
        for(int i = 0; i < this.corners.length - 1; i++) {
            temp += this.corners[i].distance_to(this.corners[i+1]);
        }

        return temp;
    }

    public Point2D nearest() {
        Point2D[] temp_corners = this.corners.clone();
        Point2D result  = temp_corners[0];
        for(int i = 1; i < temp_corners.length; i++ ) {
            if(temp_corners[i].distance_to_origin() > result.distance_to_origin()){
                result = temp_corners[i];
            }
        }
        return result;
    }

    public Double longest_side(){
        Double result = this.corners[0].distance_to(this.corners[1]); 
        for(int i = 1; i < this.corners.length; i++) {
            if(this.corners[i].distance_to(this.corners[i+1]) > result) {
                result = this.corners[i].distance_to(this.corners[i+1]);
            }
        }
        return result;
    }

    public void move(double delta_x, double delta_y) {
        for(int i = 0; i < this.corners.length; i++) {
            this.corners[i].move(delta_x, delta_y);
        }
    }

}

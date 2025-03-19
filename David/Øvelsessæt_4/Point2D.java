import java.lang.Math;

public class Point2D {
    private double xCord;
    private double yCord;

   public Point2D(){

    this.xCord = 0;
    this.yCord = 0;
   }

   public Point2D(double m, double n){
    this.xCord = m;
    this.yCord = n;
   }

   public double xCord(){
    
    return xCord;
   }

   public double yCord(){
    
    return yCord;
   }

   public boolean isOrigin(){

    return (xCord == 0 && yCord == 0);
   }

   public void move(double deltaX, double deltaY){

    this.xCord = this.xCord + deltaX;
    this.yCord = this.yCord + deltaY;
   }

   public double distanceToOrigin(){

    //return Math.sqrt(Math.pow(this.xCord,2)+(Math.pow(this.yCord,2)));
    return Math.hypot(this.xCord,this.yCord);
   }

   public double distanceTo(Point2D point){

    return Math.hypot(this.xCord-point.xCord,this.yCord-point.yCord);
   }

   public Point2D clone(){

    return new Point2D(this.xCord, this.yCord);
   }

   public String toString(){

    return ("(" + Double.toString(this.xCord) + "," + Double.toString(this.yCord) + ")");
   }
   
}

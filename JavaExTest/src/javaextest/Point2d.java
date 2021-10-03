
package javaextest;

public class Point2d {
    
    protected double x, y;
    private double length, scalar;
    private static int pointsCount;

    
    public final int ID;
    
    static {
        System.out.println("Point2d: ");
    }
           

    public Point2d() {
        this(0,0);
    }
    public Point2d(double x, double y) {
        setX(x);
        setY(y);
        ID = pointsCount++;
    }
    
   
    public double getX() {
        return x;
    }
    public final void setX(double x) {
        this.x = x;
        length();
    }
    public double getY() {
        return y;
    }
    public final void setY(double y) {
        this.y = y;
        length();
    }
    public double getLength() {
        return length;
    }

       

    public Point2d addTo(Point2d rValue) {
        
        return new Point2d(x+rValue.x, y+rValue.y);
    }
    
    protected double distanceTo (Point2d rValue){
        return Math.sqrt((rValue.x-x)*(rValue.x-x)+(rValue.y-y)*(rValue.y-y));
    }
    
        
    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object obj) {
        Point2d tmp = (Point2d) obj;
        return (this.x == tmp.x) && (this.y == tmp.y);
    }
    
    
    private void length(){
        length = Math.sqrt(x*x + y*y);
    }
    
    public double scalar(Point2d rValue, Point2d lValue){
   return scalar = lValue.length*rValue.length*Math.cos(0);
    }
    
}

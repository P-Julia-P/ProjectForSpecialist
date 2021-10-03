
package javaextest;

public class Segment extends Point2d {
    private double a, b;
    private Point2d beg, end;

     public Segment(double x, double y) {
        super(x, y);
    }
     static {
         System.out.println("Segment: ");
     }
     
    @Override
        protected double distanceTo (Point2d rValue){
            this.a =Math.sqrt((rValue.x-x)*(rValue.x-x)+(rValue.y-y)*(rValue.y-y));
        return a;
    }
  
     
     public boolean belongTo (Point2d rValue, Point2d pValue){
        this.b = Math.sqrt((pValue.x-x)*(pValue.x-x)
                           +(pValue.y-y)*(pValue.y-y))
                +Math.sqrt((rValue.x-pValue.x)*(rValue.x-pValue.x)
                           +(rValue.y-pValue.y)*(rValue.y-pValue.y));
        return ((this.a-this.b)==0);
     }
     
   
}


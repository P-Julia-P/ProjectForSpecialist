
package javaextest;

import java.lang.reflect.Method;

public class JavaExTest {

  
    public static void main(String[] args) throws ClassNotFoundException {
       Point2d p1 = new Point2d();
       p1.setX(-1);
       p1.setY(1);
             
        System.out.println(p1.ID+ " : " + p1 + ", length p1,p3= " + p1.getLength());
        
        Point2d p2 = new Point2d(4, -3);
        System.out.println(p2.ID+ " : " + p2 + ", length p2= " + p2.getLength());
       
        Point2d p3 = new Point2d(-1, 1);
        if (p1.equals(p3))System.out.println("ok");
        System.out.println("add= "+ p1.addTo(p2)+ ", distance = "+ p2.distanceTo(p3)+", scalar = "+p1.scalar(p2,p3));
        
        Segment s = new Segment(4, 1);
        Segment s1 = new Segment(4, 0);
        System.out.println("segment= "+s.distanceTo(p2));
        if (s.belongTo(p2, s1)) System.out.println("yes");
        else System.out.println("no");
    }
    
}

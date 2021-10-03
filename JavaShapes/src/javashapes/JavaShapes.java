
package javashapes;

public class JavaShapes {

 
    public static void main(String[] args) {
       
        Rect r1 = new Rect (2, 3, -2, 3, "Rectangle-1");
        Circle c1 = new Circle(10, 1, -2, "Circle-1");

        Shape []shapes ={
            r1, c1, new Rect(3, 7, 1, 4, "Rectangle-2")
        }; 
         for (Shape shape : shapes) {
             System.out.println(shape);
             System.out.println(shape.area()); 
         }
    }
      private static void  printAreas(Shape[] shapes){
          for (Shape shape : shapes) {
              if (shape instanceof Rect) 
                  System.out.println(((Rect)shape).area());
              else if (shape instanceof Circle)
                  System.out.println(((Circle)shape).area());
          }
    }
    
    
}


package javashapes;

public abstract class Shape {
    protected int x,y; 
    protected String name;

    public Shape(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override 
    public String toString() {
        return "Shape{" + "name= " + name + ", x=" + x + ", y=" + y  ;
    }
    
    public abstract double area();
}

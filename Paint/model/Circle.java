package model;

import java.awt.*;

public class Circle extends Shape {
    private Point topLeft;
    private int width;

    public Circle(Color color, Point topLeft, Point end) {
        super(color);
        this.topLeft = topLeft;
        this.width =  (int) Math.sqrt(Math.pow(topLeft.getY()-end.getY(),2) + Math.pow(topLeft.getX()-end.getX(),2)) ;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(topLeft.getX(), topLeft.getY(), width, width);
    }

    public static void main(String[] args) {
        Circle c = new Circle(Color.blue, new Point(0,0), new Point(3,4));
        System.out.println(c.getWidth());
    }
}

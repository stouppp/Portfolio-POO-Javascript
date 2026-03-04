package model;
import viewcontrol.GraphicalArea;

import java.awt.*;


public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
    }
}

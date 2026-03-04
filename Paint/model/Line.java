package model;

import java.awt.*;

public class Line extends Shape{
    private Point start;
    private Point end;

    public Line(Color color, Point start, Point end) {
        super(color);
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());

    }
}

package viewcontrol;

import model.*;
import model.Point;
import model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphicalArea extends JPanel implements MouseMotionListener, MouseListener {
    private BottomBar bottomBar;
    private TopBar topBar;
    private Point pInit;
    private Point pEnd;
    private boolean boo;
    private List<Shape> shapes;


    public GraphicalArea(BottomBar bottomBar, TopBar topBar) {
        this.bottomBar = bottomBar;
        this.topBar = topBar;
        pInit = new Point();
        pEnd = new Point();
        boo = false;
        shapes = new LinkedList<>();
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);
        setVisible(true);
    }

    public BottomBar getBottomBar() {
        return bottomBar;
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public void setpInit(Point pInit) {
        this.pInit = pInit;
    }

    public void setpEnd(Point pEnd) {
        this.pEnd = pEnd;
    }


    private void draw(){
        EnumColour selectedColor = topBar.getSelectedColour();
        Color color = selectedColor.getColor();
        if (!boo) {
            switch (topBar.getSelectedShape()) {
                case LINE:
                    Line l = new Line(color, new Point(pInit.getX(), pInit.getY()), new Point(pEnd.getX(), pEnd.getY()));
                    shapes.add(l);
                    break;

                case CIRCLE:
                    Point topLeft = new Point(pInit.getX(), pInit.getY());
                    Point center = new Point(pEnd.getX(), pEnd.getY());

                    Circle c = new Circle(color, topLeft, center);
                    shapes.add(c);
                    break;
                default:
                    System.out.println("pas ok");
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
            System.out.println(shape.toString());
        }

        EnumColour selectedColor = topBar.getSelectedColour();
        Color color = selectedColor.getColor();
        if (boo) {
            switch (topBar.getSelectedShape()) {
                case LINE:
                    Line l = new Line(color, new Point(pInit.getX(), pInit.getY()), new Point(pEnd.getX(), pEnd.getY()));
                    l.draw(g);
                    break;

                case CIRCLE:
                    Point topLeft = new Point(pInit.getX(), pInit.getY());
                    Point center = new Point(pEnd.getX(), pEnd.getY());

                    Circle c = new Circle(color, topLeft, center);
                    c.draw(g);
                    break;
                default:
                    System.out.println("pas ok");
            }


        }
    }


    public void undo(){
        shapes.remove(shapes.size()-1);
        repaint();
    }
    public void clear(){
        shapes.clear();
        repaint();

    }





    @Override
    public void mouseDragged(MouseEvent e) {
        bottomBar.mouseMovement(e);
        System.out.println("mouseDragged");
        pEnd.setPoint(e.getX(), e.getY());
        draw();





    }

    @Override
    public void mouseMoved(MouseEvent e) {
        bottomBar.mouseMovement(e);
        System.out.println("mouseMoved");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        boo = true;
        pInit.setPoint(e.getX(), e.getY());
        System.out.println(pInit.toString());
        getBottomBar().getMessage().setText("Release to view the shape");




    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pEnd.setPoint(e.getX(), e.getY());
        System.out.println(pEnd.toString());
        getBottomBar().getMessage().setText("Click to initiate a shape");
        boo = false;
        draw();


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");

    }
}

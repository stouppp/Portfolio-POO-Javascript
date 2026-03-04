package viewcontrol;

import model.EnumColour;
import model.EnumShape;
import sun.awt.windows.WingDings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBar extends JPanel implements ActionListener {
    private JComboBox boxColors;
    private JComboBox boxShapes;
    private JButton clear;
    private JButton undo;
    private JButton eraser;
    private Window window;

    public TopBar(Window window) {
        this.window = window;
        EnumColour [] colors = EnumColour.values();
        EnumShape [] shapes = EnumShape.values();
        boxColors = new JComboBox(colors);
        boxShapes = new JComboBox(shapes);
        add(boxColors);
        add(boxShapes);
        boxColors.addActionListener(this);
        boxShapes.addActionListener(this);
        clear = new JButton("clear");
        undo = new JButton("undo");
        add(clear);
        add(undo);
        clear.addActionListener(new ClearListener());
        class UndoListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed : undo");
                window.undo();
            }
        }
        undo.addActionListener(new UndoListener());
        eraser = new JButton("Enable Eraser");
        add(eraser);
        ActionListener EraserListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eraser.getText().equals("Enable Eraser")) eraser.setText("Disable Eraser");
                else eraser.setText("Enable Eraser");


            }
        };
        eraser.addActionListener(EraserListener);

        setVisible(true);
    }

    public JComboBox getBoxColors() {
        return boxColors;
    }

    public JComboBox getBoxShapes() {
        return boxShapes;
    }

    class ClearListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed : clear");
            window.clear();

        }
    }




    public EnumColour getSelectedColour(){
        return (EnumColour) boxColors.getSelectedItem();
    }

    public EnumShape getSelectedShape(){
        return (EnumShape) boxShapes.getSelectedItem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Color selected : " + getSelectedColour());
        System.out.println("Shape selected : " + getSelectedShape());
    }

    public static void main(String[] args) {
       /* JFrame window = new JFrame();
        TopBar bar = new TopBar();
        window.add(bar);
        window.setVisible(true);*/
    }
}

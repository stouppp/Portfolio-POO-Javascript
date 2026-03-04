package viewcontrol;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private BottomBar bottomBar;
    private TopBar topBar;
    private GraphicalArea graph;


    public Window(){
        setSize(500, 300);
        setTitle("My first window!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        graph = new GraphicalArea(new BottomBar(), new TopBar(this));
        add(graph.getBottomBar(), BorderLayout.SOUTH);
        add(graph.getTopBar(), BorderLayout.NORTH);
        add(graph, BorderLayout.CENTER);
        MyWindowListener listener = new MyWindowListener();
        addWindowListener(listener);
        setVisible(true);
    }



    public BottomBar getBottomBar() {
        return bottomBar;
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public GraphicalArea getGraph() {
        return graph;
    }

    public void undo(){
        graph.undo();

    }

    public void clear(){
        graph.clear();
    }

    public static void main(String[] args) {
        Window myWindow = new Window();

        /* myWindow.getBar().setBackground(Color.green);
        myWindow.getBar().getMessage().setForeground(Color.blue);*/

    }
}

package viewcontrol;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;

public class BottomBar extends JPanel{

    private JLabel message;
    private JLabel coord_x;
    private JLabel coord_y;

    public BottomBar(){
        message = new JLabel("Click to initiate a shape");
        coord_x = new JLabel("x = ");
        coord_y = new JLabel("y = ");
        add(message);
        add(coord_x);
        add(coord_y);
        setVisible(true);
    }

    public JLabel getMessage() {
        return message;
    }

    public JLabel getCoord_x() {
        return coord_x;
    }

    public JLabel getCoord_y() {
        return coord_y;
    }

    public void setMessage(JLabel message) {
        this.message = message;
    }

    public void setCoord_x(JLabel coord_x) {
        this.coord_x = coord_x;
    }

    public void setCoord_y(JLabel coord_y) {
        this.coord_y = coord_y;
    }

    public void mouseMovement(MouseEvent evt){
        getCoord_x().setText("x = " + evt.getX());
        getCoord_y().setText("y = " + evt.getY());
    }

}

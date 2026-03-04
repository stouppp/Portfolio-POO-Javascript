package model;

import java.awt.*;

public enum EnumColour {
    BLUE(Color.blue),
    RED(Color.red),
    GREEN(Color.green),
    YELLOW(Color.yellow),
    BLACK(Color.black);

    private Color color;

    private EnumColour(Color color){
        this.color=color;
    }

    public Color getColor() {
        return color;
    }
}

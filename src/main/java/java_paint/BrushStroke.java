package java_paint;

import java.awt.Color;
import java.awt.Shape;

/**
 * 
 * An instance of the BrushStroke class emulates a brush stroke behavior.
 * So, once that a brush type has been selected, it has a color, thickness and shape.
 * 
 * @author
 */
public class BrushStroke {

    private Shape shape;
    private Color color;
    private int thickness;
    private boolean filledOption;

    public BrushStroke(Shape shape, Color color, int thickness, boolean filled) {
        this.shape = shape;
        this.color = color;
        this.thickness = thickness;
        this.filledOption = filled;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public boolean isFilled() {
        return filledOption;
    }

    public void setFilledOption(boolean filledOption) {
        this.filledOption = filledOption;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}

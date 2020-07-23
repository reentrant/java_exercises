package java_paint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * In the ToolPalette class we configure some buttons that we add to a JToolBar component.
 * These button allows us to configure the type of brush that we would use to create a
 * BrushStroke instance.
 * 
 * @author 
 *
 */
public class ToolPalette extends JToolBar implements ActionListener {

    private JToggleButton buttonPencil;
    private JToggleButton buttonLine;
    private JToggleButton buttonRectangle;
    private JToggleButton buttonEllipse;
    private JToggleButton buttonArc;
    private JToggleButton buttonPolygon;
    private String choice;
    private String PATH_IMAGES = "/jpaint/images/";

    public ToolPalette() {
        choice = "pencil";
        setFloatable(true);  // Let the user to move the tool bar
        initializeComponents();
        updateButtonState();
    }

    private void initializeComponents() {
    	setupPencilButton();
    	setupLineButton();
    	setupRectangleButton();
    	setupEllipseButton();
    	setupArcButton();
    	setupPolygonButton();
    }
    
    private void setupPencilButton() {
        buttonPencil = new JToggleButton();
        buttonPencil.setIcon(createImageIcon(PATH_IMAGES + "pencil.png"));
        buttonPencil.addActionListener(this);
        add(buttonPencil);    	
    }
    
    private void setupLineButton() {
        buttonLine = new JToggleButton();
        buttonLine.setIcon(createImageIcon(PATH_IMAGES + "line.png"));
        buttonLine.addActionListener(this);
        add(buttonLine);
    }
    
    private void setupRectangleButton() {
        buttonRectangle = new JToggleButton();
        buttonRectangle.setIcon(createImageIcon(PATH_IMAGES + "rectangle.png"));
        buttonRectangle.addActionListener(this);
        add(buttonRectangle);
    }
    
    private void setupEllipseButton() {
        buttonEllipse = new JToggleButton();
        buttonEllipse.setIcon(createImageIcon(PATH_IMAGES + "ellipse.png"));
        buttonEllipse.addActionListener(this);
        add(buttonEllipse);
    }
    
    private void setupArcButton() {
        buttonArc = new JToggleButton();
        buttonArc.setIcon(createImageIcon(PATH_IMAGES + "arc.png"));
        buttonArc.addActionListener(this);
        add(buttonArc);
    }
    
    private void setupPolygonButton() {
    	buttonPolygon = new JToggleButton();
        buttonPolygon.setIcon(createImageIcon(PATH_IMAGES + "polygon.png"));
        buttonPolygon.addActionListener(this);
        add(buttonPolygon);
    }

    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ToolPalette.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found: " + path);
            return null;
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPencil) {
        	setButtonSelected("pencil");
        } else if (e.getSource() == buttonLine) {
            setButtonSelected("line");
        } else if (e.getSource() == buttonRectangle) {
        	setButtonSelected("rectangle");
        } else if (e.getSource() == buttonEllipse) {
        	setButtonSelected("ellipse");
        } else if (e.getSource() == buttonArc) {
        	setButtonSelected("arc");;
        } else if (e.getSource() == buttonPolygon) {
        	setButtonSelected("polygon");
        }
    }
    
    public void setButtonSelected(String userChoice) {
        this.choice = userChoice;
        updateButtonState();
    }
    
    public String getButtonSelected() {
        return choice;
    }

    private void updateButtonState() {
    	buttonPencil.setSelected(false);
        buttonLine.setSelected(false);
        buttonRectangle.setSelected(false);
        buttonEllipse.setSelected(false);
        buttonArc.setSelected(false);
        buttonPolygon.setSelected(false);

        if (choice.equalsIgnoreCase("pencil")) {
            buttonPencil.setSelected(true);
        } else if (choice.equalsIgnoreCase("line")) {
        	buttonLine.setSelected(true);
        } else if (choice.equalsIgnoreCase("rectangle")) {
        	buttonRectangle.setSelected(true);
        } else if (choice.equalsIgnoreCase("ellipse")) {
        	buttonEllipse.setSelected(true);
        } else if (choice.equalsIgnoreCase("arc")) {
        	buttonArc.setSelected(true);
        } else {
        	buttonPolygon.setSelected(true);
        }
    }
}

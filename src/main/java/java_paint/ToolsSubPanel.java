package java_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * The ToolsSubPanel class contains a button for setting the brush color, a checkBox for enable
 * the fill of our drawings and an slider to configure our brush thickness.
 * 
 * @author 
 *
 */
public class ToolsSubPanel extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel thicknessLabel;
    private JLabel colorLabel;
    private JLabel spaceLabel1;
    private JLabel spaceLabel2;
    private JSlider thicknessSlider;
    private JButton colorButton;
    private JCheckBox filledCheckBox;

    public ToolsSubPanel() {
    	setupColorButton();
    	setupThickness();
    	setupFilledCheckBox();
    }
    
    private void setupColorButton() {
    	colorLabel = new JLabel("Color");
    	spaceLabel1 = new JLabel("    ");
        colorButton = new JButton();
        colorButton.setBackground(Color.green);
        colorButton.addActionListener(this);
        add(colorLabel);
        add(colorButton);
        add(spaceLabel1);
    }
    
    private void setupThickness() {
    	thicknessLabel = new JLabel("brush thickness");
        thicknessSlider = new JSlider(1, 20, 1);
        spaceLabel2 = new JLabel("    ");
        add(thicknessLabel);
        add(thicknessSlider);
        add(spaceLabel2);
    }
    
    private void setupFilledCheckBox() {
    	filledCheckBox = new JCheckBox("filled");
        add(filledCheckBox);
    }

    public JSlider getThicknessSlider() {
        return thicknessSlider;
    }
    
    public JButton getColorButton() {
        return colorButton;
    }

    public boolean isCheckBoxSelected() {
        return filledCheckBox.isSelected();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(null, "Choose Color", Color.yellow);
        colorButton.setBackground(color);
	}
}

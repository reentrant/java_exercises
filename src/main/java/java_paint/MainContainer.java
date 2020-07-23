package java_paint;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * MainContainer class is where we set a layout in our main window, for setting a menu in the top,
 * a drawing area in the center, and a brush configuration tool in the bottom.
 * 
 * Also, from this class we call the JFileChooser component which will allows us to select the path
 * for opening and saving a file. 
 * 
 * @author 
 *
 */
public class MainContainer extends JFrame {

    private MenuBar myMenuBar;
    private ToolPalette myBrushes;
    private DrawingPanel myCanvas;
    private ToolsSubPanel myOptionTools;

    public MainContainer() {
        super("Drawing Panel");
        setupWindow();
        initializeComponents();
    }

    private void setupWindow() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        myMenuBar = new MenuBar(this);
        myCanvas = new DrawingPanel(this);
        myOptionTools = new ToolsSubPanel();
        setJMenuBar(myMenuBar);
        myBrushes = new ToolPalette();
        add(myBrushes, BorderLayout.NORTH);
        add(myCanvas, BorderLayout.CENTER);
        add(myOptionTools, BorderLayout.SOUTH);
    }

    public void clearDrawing() {
        myCanvas.clearDrawing();
    }
    
    public void openFile() {
    	try {
    		String fileToBeOpen = getFileToBeOpened();
    		if (fileToBeOpen.length() > 0)
    			new ImageFrameViewer(fileToBeOpen);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    protected String getFileToBeOpened() {
    	String fileToOpen = "";
    	JFileChooser fileChooser = new JFileChooser();
    	int result = fileChooser.showOpenDialog(this);
    	if (result == JFileChooser.APPROVE_OPTION) {
    		 // user selects a file
    	    File selectedFile = fileChooser.getSelectedFile();
    	    fileToOpen = selectedFile.getAbsolutePath();
    	}
    	return fileToOpen;
    }
    
    public void saveImage() {
    	String outputFile = "";
    	JFileChooser fileChooser = new JFileChooser();
    	int result = fileChooser.showSaveDialog(null);
    	if (result == JFileChooser.APPROVE_OPTION) {
    		// user selects the destination file
	   	    File selectedFile = fileChooser.getSelectedFile();
	   	    outputFile = selectedFile.getAbsolutePath();
	   	    if (outputFile.length() > 0)
	   	    	myCanvas.saveDrawingToFile(outputFile);
    	}
	}

    public int getBrushThickness() {
        return myOptionTools.getThicknessSlider().getValue();
    }

    public Color getBrushColor() {
        return myOptionTools.getColorButton().getBackground();
    }


    public boolean isFigureFilled() {
        return myOptionTools.isCheckBoxSelected();
    }
    
    public String getBrushType() {
        return myBrushes.getButtonSelected();
    }

    public void setBrushType(String opcion) {
        myBrushes.setButtonSelected(opcion);
    }

    public void repaintDrawing() {
        myCanvas.repaint();
    }

    public void undoLastAction() {
        myCanvas.undo();
        myCanvas.repaint();
    }
}

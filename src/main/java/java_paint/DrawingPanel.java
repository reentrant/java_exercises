package java_paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


/**
 * 
 * DrawingPanel class is where the drawing functions take place.
 * Using the mouse we can draw lines or areas. This functionality is achieved by implementing the
 * MouseListener and MouseMotionListener interfaces.
 * 
 *  The paint() method overrides the javax.swing.JComponent.paint() method.
 *  And it is refreshing the JPanel for us.
 * 
 * @author 
 *
 */
public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainContainer window;
    private Point initialPoint;
    private Point finalPoint;
    private GeneralPath polygonPath;
    private ArrayList<BrushStroke> drawings = new ArrayList<BrushStroke>();
    private boolean isPolygonFirstVertex;

    public DrawingPanel(MainContainer frameWindow) {
        this.isPolygonFirstVertex = true;
        this.polygonPath = new GeneralPath();
        this.window = frameWindow;
        this.setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String brushChoice = window.getBrushType();

        drawAllPreviousFigures(g2);
        if (brushChoice.equals("polygon")) {
        	drawPolygon(g2);
        }
        if (wasMouseMoved()) {
            g2.setColor(window.getBrushColor());
            if (brushChoice.equals("pencil")) {
            	// implemented in mousePressed and mouseDragged
            } else if (brushChoice.equals("line")) {
            	drawLine(g2);
            } else if (brushChoice.equals("rectangle")) {
            	drawRectangle(g2);
            } else if (brushChoice.equals("ellipse")) {
            	drawEllipse(g2);
            } else if (brushChoice.equals("arc")) {
            	drawArc(g2);
            }
        }
    }
    
    private void drawAllPreviousFigures(Graphics2D g2) {
        for (BrushStroke drawing : drawings) {
            g2.setColor(drawing.getColor());
            g2.setStroke(new BasicStroke(drawing.getThickness()));
            if (drawing.isFilled() && !(drawing.getShape() instanceof Line2D.Float)) {
                g2.fill(drawing.getShape());
            } else {
                g2.draw(drawing.getShape());
            }
        }
    }

    private void drawPolygon(Graphics2D g2) {
    	int border = 10;
        if (wasMouseMoved() && 
        		initialPoint.x > finalPoint.x - border &&
        		initialPoint.x < finalPoint.x + border &&
        		initialPoint.y > finalPoint.y - border &&
        		initialPoint.y < finalPoint.y + border) {
            drawings.add(new BrushStroke(polygonPath,
            		window.getBrushColor(),
            		window.getBrushThickness(),
            		window.isFigureFilled()));
            polygonPath = new GeneralPath();
            initialPoint = null;
            finalPoint = null;
            isPolygonFirstVertex = true;
            repaint();
        } else {
            g2.setColor(window.getBrushColor());
            g2.setStroke(new BasicStroke(window.getBrushThickness()));
            g2.draw(polygonPath);
        }
    }

    private void drawLine(Graphics2D g2) {
    	BrushStroke lineStroke = createLine(initialPoint.x, initialPoint.y,
    			finalPoint.x, finalPoint.y,
        		window.getBrushColor(), window.getBrushThickness(), window.isFigureFilled());
        g2.setStroke(new BasicStroke(lineStroke.getThickness()));
        g2.draw(lineStroke.getShape());
    }

    private void drawRectangle(Graphics2D g2) {
    	BrushStroke rectangle = createRectangle(initialPoint.x, initialPoint.y, finalPoint.x,
    			finalPoint.y, window.getBrushColor(), window.getBrushThickness(),
    			window.isFigureFilled());
        g2.setStroke(new BasicStroke(rectangle.getThickness()));
        g2.draw(rectangle.getShape());
    }

    private void drawEllipse(Graphics2D g2) {
    	BrushStroke ellipse = createEllipse(initialPoint.x, initialPoint.y, finalPoint.x,
    			finalPoint.y, window.getBrushColor(), window.getBrushThickness(),
    			window.isFigureFilled());
        g2.setStroke(new BasicStroke(ellipse.getThickness()));
        g2.draw(ellipse.getShape());
    }

    private void drawArc(Graphics2D g2) {
    	BrushStroke arc = createArc(initialPoint.x, initialPoint.y, finalPoint.x, finalPoint.y,
        		window.getBrushColor(), window.getBrushThickness(), window.isFigureFilled());
        g2.setStroke(new BasicStroke(arc.getThickness()));
        g2.draw(arc.getShape());
    }

    private boolean wasMouseMoved() {
    	return initialPoint != null && finalPoint != null;
    }

    public void mousePressed(MouseEvent e) {
        String brushChoice = window.getBrushType();
        if (brushChoice.equals("pencil")) {
        	setInitialMousePosition(e);
            repaint();
        } else if (brushChoice.equals("line")) {
        	setInitialMousePosition(e);
        	updateMousePosition();
            repaint();
        } else if (brushChoice.equals("rectangle")) {
        	setInitialMousePosition(e);
        	updateMousePosition();
            repaint();
        } else if (brushChoice.equals("ellipse")) {
        	setInitialMousePosition(e);
        	updateMousePosition();
            repaint();
        } else if (brushChoice.equals("arc")) {
        	setInitialMousePosition(e);
        	updateMousePosition();
            repaint();
        } else if (brushChoice.equals("polygon")) {
            if (isPolygonFirstVertex) {
            	setInitialMousePosition(e);
                polygonPath.moveTo(e.getX(), e.getY());
                isPolygonFirstVertex = false;
            } else {
            	setFinalMousePosition(e);
                polygonPath.lineTo(e.getX(), e.getY());
            }
            repaint();
        }
    }
    
    public void mouseDragged(MouseEvent e) {
        String brushChoice = window.getBrushType();
        if (brushChoice.equals("pencil")) {
            addFreeHandLine(e);
            initialPoint = new Point(finalPoint.x, finalPoint.y);
            repaint();
        } else if (brushChoice.equals("line")) {
        	setFinalMousePosition(e);
            repaint();
        } else if (brushChoice.equals("rectangle")) {
        	setFinalMousePosition(e);
            repaint();
        } else if (brushChoice.equals("ellipse")) {
        	setFinalMousePosition(e);
            repaint();
        } else if (brushChoice.equals("arc")) {
        	setFinalMousePosition(e);
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        String brushChoice = window.getBrushType();
        if (brushChoice.equals("pencil")) {
        	addFreeHandLine(e);
            repaint();
        } else if (brushChoice.equals("line")) {
        	addFreeHandLine(e);
            initialPoint = null;
            finalPoint = null;
            repaint();
        } else if (brushChoice.equals("rectangle")) {
        	addRectangle(e);
            initialPoint = null;
            finalPoint = null;
            repaint();
        } else if (brushChoice.equals("ellipse")) {
        	addEllipse(e);
            initialPoint = null;
            finalPoint = null;
            repaint();
        } else if (brushChoice.equals("arc")) {
        	addArc(e);
            initialPoint = null;
            finalPoint = null;
            repaint();
        }
    }

    public void addFreeHandLine(MouseEvent e) {
    	setFinalMousePosition(e);
        BrushStroke line = createLine(initialPoint.x, initialPoint.y, finalPoint.x,
        		finalPoint.y, window.getBrushColor(), window.getBrushThickness(),
        		window.isFigureFilled());
        drawings.add(line);
    }

    private BrushStroke createLine(int x1, int y1, int x2, int y2, Color color, int thickness,
    		boolean filledOption) {
        return new BrushStroke(new Line2D.Float(x1, y1, x2, y2), color, thickness, filledOption);
    }
    
    public void addRectangle(MouseEvent e) {
    	setFinalMousePosition(e);
        BrushStroke rectangle = createRectangle(initialPoint.x, initialPoint.y, finalPoint.x,
        		finalPoint.y, window.getBrushColor(), window.getBrushThickness(),
        		window.isFigureFilled());
        drawings.add(rectangle);
    }

    private BrushStroke createRectangle(int x1, int y1, int x2, int y2, Color color, int thickness,
    		boolean filledOption) {
        return new BrushStroke(
        		new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
        				Math.abs(y1 - y2)),
        		color, thickness, filledOption);
    }

    public void addEllipse(MouseEvent e) {
    	BrushStroke ellipse = createEllipse(initialPoint.x, initialPoint.y, e.getX(), e.getY(),
        		window.getBrushColor(), window.getBrushThickness(), window.isFigureFilled());
        drawings.add(ellipse);
    }

    private BrushStroke createEllipse(int x1, int y1, int x2, int y2, Color color, int thickness,
    		boolean filledOption) {
        return new BrushStroke(
        		new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
        				Math.abs(y1 - y2)),
        		color, thickness, filledOption);
    }

    public void addArc(MouseEvent e) {
    	BrushStroke arc = createArc(initialPoint.x, initialPoint.y, e.getX(), e.getY(),
        		window.getBrushColor(), window.getBrushThickness(), window.isFigureFilled());
        drawings.add(arc);
    }

    private BrushStroke createArc(int x1, int y1, int x2, int y2, Color color, int thickness,
    		boolean filledOption) {
        int initialValueDegrees = 0;
        int finalValueDegrees = 90;
        
        if (x1 > x2 && y1 < y2) {
            initialValueDegrees = 90;
        }
        if (x1 < x2 && y1 > y2) {
            finalValueDegrees = -90;
        }
        if (x1 > x2 && y1 > y2) {
            initialValueDegrees = 180;
            finalValueDegrees = 90;
        }
        return new BrushStroke(
        		new Arc2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), 
        				Math.abs(y1 - y2), initialValueDegrees, finalValueDegrees, Arc2D.OPEN),
        		color, thickness, filledOption);
    }

    public void setInitialMousePosition(MouseEvent e) {
    	initialPoint = new Point(e.getX(), e.getY());
    }

    public void setFinalMousePosition(MouseEvent e) {
    	finalPoint = new Point(e.getX(), e.getY());
    }
    
    public void updateMousePosition() {
    	finalPoint = initialPoint;
    }

    public void clearDrawing() {
        drawings.clear();
        repaint();
    }
    
    public void undo() {
        if (!drawings.isEmpty()) {
            drawings.remove(drawings.size() - 1);
        }
    }

    public void saveDrawingToFile(String filePath) {
    	BufferedImage image = new BufferedImage(getWidth(), getHeight(),
    			BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		try{
			ImageIO.write(image, "png", new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Intentionally empty to implement inherited abstract method
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Intentionally empty to implement inherited abstract method
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Intentionally empty to implement inherited abstract method
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Intentionally empty to implement inherited abstract method
	}
}

package java_paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * MenuBar class is configuring three menu options: File, Edit and Help.
 * 
 * @author 
 *
 */
public class MenuBar extends JMenuBar implements ActionListener {
	private MainContainer container;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuHelp;

    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveItem;
    private JMenuItem itemUndo;
    private JMenuItem itemAbout;

    public MenuBar(MainContainer container) {
        this.container = container;
        initializeComponents();
    }

    private void initializeComponents() {
    	setupMenuOptionFile();
    	setupMenuOptionEdit();
    	setupMenuOptionHelp();
    }
    
    private void setupMenuOptionFile() {
        menuFile = new JMenu("File");
        
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        
        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        
        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        
        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.add(saveItem);
        add(menuFile);
    }
    
    private void setupMenuOptionEdit() {
        menuEdit = new JMenu("Edit");
        itemUndo = new JMenuItem("Undo");
        itemUndo.addActionListener(this);    
        menuEdit.add(itemUndo);
        add(menuEdit);
    }
    
    private void setupMenuOptionHelp() {
        menuHelp = new JMenu("Help");
        itemAbout = new JMenuItem("About");
        itemAbout.addActionListener(this);
        menuHelp.add(itemAbout);
        add(menuHelp);
    }

	@Override
    public void actionPerformed(ActionEvent e) {
    	// implement how code that reacts to the actions... 
        if (newItem == e.getSource()) {
            container.clearDrawing();
        } else if (openItem == e.getSource()) {
        	container.openFile();
        } else if (saveItem == e.getSource()) {
        	container.saveImage();
        } else  if (itemUndo == e.getSource()) {
            container.undoLastAction();
        } else if (itemAbout == e.getSource()) {
            JOptionPane.showMessageDialog(container,
            		"Drawing Panel v.1\n",
            		"About Drawing Panel",
            		JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

package java_three_in_line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * MenuBar class is configuring three menu options: File and Help.
 * 
 * @author 
 *
 */
public class MenuBar extends JMenuBar implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainContainer container;
    private JMenu menuFile;
    private JMenu menuHelp;

    private JMenuItem newItem;
    private JMenuItem quitItem;
    private JMenuItem itemAbout;

    public MenuBar(MainContainer container) {
        this.container = container;
        initializeComponents();
    }

    private void initializeComponents() {
    	setupMenuOptionFile();
    	setupMenuOptionHelp();
    }
    
    private void setupMenuOptionFile() {
        menuFile = new JMenu("File");
        
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        
        menuFile.add(newItem);
        menuFile.add(quitItem);
        add(menuFile);
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
        	container.getFrame().dispose();
        	container = new MainContainer();
        } else if (quitItem == e.getSource()) {
				System.exit(0);
        } 
        else if (itemAbout == e.getSource()) {
            JOptionPane.showMessageDialog(container,
            		"Three in Line v.1\n",
            		"About Three in Line",
            		JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

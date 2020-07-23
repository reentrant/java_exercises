package java_paint;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * Adapted from: 
 * https://alvinalexander.com/blog/post/jfc-swing/complete-java-program-code-open-read-display-image-file
 * 
 * Java class to load an image from disk with the ImageIO class. Then it
 * displays the image by creating an ImageIcon, placing that icon an a JLabel
 * and placing that label on a JFrame.
 *
 * @author
 * 
 */
public class ImageFrameViewer {

	public ImageFrameViewer(final String filename) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame editorFrame = new JFrame(filename);
				BufferedImage image = null;
				try {
					image = ImageIO.read(new File(filename));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
				ImageIcon imageIcon = new ImageIcon(image);
				JLabel jLabel = new JLabel();
				jLabel.setIcon(imageIcon);
				editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

				editorFrame.pack();
				editorFrame.setLocationRelativeTo(null);
				editorFrame.setVisible(true);
			}
		});
	}
}
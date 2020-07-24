package java_three_in_line;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * MainContainer displays all the information to the user using a graphic user
 * interface (GUI)
 * 
 * @author jruiz
 *
 */
public class MainContainer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows, columns;
	/** GUI frame */
	private JFrame frameContainer;
	/** 2D Array of buttons for GUI board */
	private Cell[][] board;
	/** Menu items */
	private MenuBar menuBar;
	/** Creates a new game */
	private Game game;
	/** Displays Current turn and Winner */
	private JLabel topPanelLabel;
	/** Boolean */
	private boolean gameOver;
	/** Toggle Turn */
	private boolean turn;

	/**
	 * Class constructor
	 */
	MainContainer() {
		frameContainer = new JFrame("Three in Line");
		rows = columns = 3;
		turn = false;
		gameOver = false;
		setupMenu();
		setupTopPanel();
		setupBoardPanel();
		game = new Game(board);
		frameContainer.setSize(500, 500);
		frameContainer.setVisible(true);
		frameContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * setupMenu
	 */
	private void setupMenu() {
		menuBar = new MenuBar(this);
		frameContainer.setJMenuBar(menuBar);
	}

	/**
	 * setupTopPanel() sets up top row of labels and buttons
	 */
	private void setupTopPanel() {
		JPanel topPanel = new JPanel();
		topPanelLabel = new JLabel(" Turn: Cross");
		topPanel.add(topPanelLabel);
		frameContainer.add(BorderLayout.NORTH, topPanel);
	}

	/**
	 * Setup the board game by creating a 2D array of cell buttons
	 */
	private void setupBoardPanel() {
		JPanel boardPanel = new JPanel();
		board = new Cell[rows][columns];
		MouseEventListener mouseEventListener = new MouseEventListener();
		// creates a grid layout
		boardPanel.setLayout(new GridLayout(rows, columns));

		for (int row = 0; row < rows; row++)
			for (int col = 0; col < columns; col++) {
				board[row][col] = new Cell("", row, col);
				board[row][col].addMouseListener(mouseEventListener);
				// Add each cell to the boardPanel
				boardPanel.add(board[row][col]);
			}
		frameContainer.add(BorderLayout.CENTER, boardPanel);
	}

	JFrame getFrame() {
		return frameContainer;
	}

	private void updateTurnLabel() {
		if (turn) {
			topPanelLabel.setText(" Turn: Circle");
		} else {
			topPanelLabel.setText(" Turn: Cross");
		}
	}

	private void displayWinner() {
		if (game.getWinner() == CellType.CROSS) {
			topPanelLabel.setText(" 'X' wins ");
		} else {
			topPanelLabel.setText(" 'O' wins ");
		}
	}

	class MouseEventListener implements MouseListener {

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!gameOver) {
				JComponent clickedCellButton = (JComponent) e.getSource();

				if (((Cell) clickedCellButton).getCellType() == CellType.NONE) {
					turn = !turn;
					updateTurnLabel();
					((Cell) clickedCellButton).updateCellStatus(turn);
					int row = ((Cell) clickedCellButton).getRowPosition();
					int column = ((Cell) clickedCellButton).getColumnPosition();
					if (game.isGameOver(row, column)) {
						gameOver = true;
						displayWinner();
						JOptionPane.showMessageDialog(null, "Game is Over!");
					}
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// Intentionally empty to implement inherited abstract method

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// Intentionally empty to implement inherited abstract method

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// Intentionally empty to implement inherited abstract method

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// Intentionally empty to implement inherited abstract method

		}

	}

}

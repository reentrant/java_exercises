package java_three_in_line;

import javax.swing.JButton;
/**
 * 
 * Class cell inherits from JButton, so every cell in the board is a JButton plus additional 
 * functionality, like position in the board.
 * 
 * @author jruiz
 *
 */
public class Cell extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CellType cellType;
	private int rowPosition, columnPosition; 
	
	Cell(String text, int row, int column) {
		super(text);
		this.cellType = CellType.NONE;
		this.rowPosition = row;
		this.columnPosition = column;
	}

	public void updateCellStatus(boolean turn) {
		if (turn) {
			setCellType(CellType.CROSS);
			setText("X");
		}
		else {
			setCellType(CellType.CIRCLE);
			setText("O");
		}
	}
	
	public CellType getCellType() {
		return cellType;
	}
	
	public void setCellType(CellType option) {
		cellType = option;
	}
	
	public int getRowPosition() {
		return rowPosition;
	}
	
	public int getColumnPosition() {
		return columnPosition;
	}
	
}

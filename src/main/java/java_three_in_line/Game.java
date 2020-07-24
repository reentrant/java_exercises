package java_three_in_line;

public class Game {
	/** 2D Array of Cell type to set up the game */
	private Cell[][] gameBoard;
	
	/** Integer for rows throughout */
	private int rows;

	/** Integer for columns throughout */
	private int columns;
	
	/** Cell type of the last operation */
	private CellType currentCellType;

	/*****************************************************************
	 * Method that sets up a new game according to its parameters by
	 * the size of the board and number of bombs for the GUI to display.
	 * 
	 * @param gameBoard - reference to the gameBoard
	 *****************************************************************/
	public Game(Cell[][] gameBoard) {
		rows = columns = gameBoard.length;
		this.gameBoard = gameBoard;
		this.currentCellType = CellType.NONE;
		restart();
	}
	
	/*****************************************************************
	 * A helper method that will prepare the game to be wiped clean,
	 *****************************************************************/
	public void restart() {
		for (int row = 0; row < rows; row++) 
			for (int col = 0; col < columns; col++) {
				gameBoard[row][col].setText("");
			}	
	}
	
	public boolean isGameOver(int row, int column) {
		updateLastOperation(row, column);
		boolean result = isVerticalInLine(column) || isHorizontalInLine(row) ||
				isPositiveSlopeInLine() || 
				isNegativeSlopeInLine(row, column);
		return result;
	}

	public CellType getWinner() {
		return currentCellType;
	}
	
	public void updateLastOperation(int row, int column) {
		currentCellType = gameBoard[row][column].getCellType();
	}

	public boolean isVerticalInLine(int fixedColumn) {
		for (int row = 0; row < rows; row++) {
			if (currentCellType == gameBoard[row][fixedColumn].getCellType()) {
				continue;
			} 
			else
				return false;
		}
		return true;
	}
	
	private boolean isHorizontalInLine(int fixedRow) {
		for (int col = 0; col < columns; col++) {
			if (currentCellType == gameBoard[fixedRow][col].getCellType()) {
				continue;
			} 
			else
				return false;
		}
		return true;
	}

	private boolean isPositiveSlopeInLine() {
		for (int increasingColumn = 0, decreasingRow = columns - 1; increasingColumn < columns;
				increasingColumn++) {
			if (currentCellType == gameBoard[decreasingRow--][increasingColumn].getCellType()) {
				continue;
			} 
			else
				return false;
		} 
		return true;
	}

	private boolean isNegativeSlopeInLine(int row, int column) {
		boolean result = false;
		if (row == column) {
			for (int incRowColumn = 0; incRowColumn < columns; incRowColumn++) {
				if (currentCellType == gameBoard[incRowColumn][incRowColumn].getCellType()) {
					result = true;
					continue;
				} 
				else {
					result = false;
					break;
				}
			}
		}
		return result;	}
}

//Andrea Soteldo
//COSC-2430.501
//Project2
//29Apr2021
//Sudoku
package college;

public class SudokuPuzzle {
    private int board[][], start[][];
    
    public SudokuPuzzle() {
        start = new int[9][9];
        board = new int[9][9];
    }
    public String toString() {
        String display = "    1  2  3  4  5  6  7  8  9\n";
        display = display + "   __________________________\n";
        for (int i = 0; i < 9; i++) {
        	display = display + (i + 1) + " |";
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0)
                	display = display + " " + ". ";
                else
                	display = display + " " + board[i][j] + " ";
            }
            display = display + "\n";
        }
        return display;
    }
    public void addInitial(int row, int col, int value) {
    	if (row >= 0 && row <= 9)
        	if (col >= 0 && col <= 9)
        		if (value >= 1 && value <= 9) {
        			start[row][col] = value;
        			board[row][col] = value;
        			}
    }
    public void addGuess(int row, int col, int value) {
        if (row >= 0 && row <= 9)
        	if (col >= 0 && col <= 9)
        		if (value >= 1 && value <= 9)
        			if (start[row][col] == 0) {
        				board[row][col] = value;
        				}
    }
    public boolean checkPuzzle() {
        boolean result = true;
        for (int num = 0; num < 9; num++) {
        	result = result && checkRow(num);
        	result = result && checkCol(num);
        	result = result && checkBox(num);
        }
        return result;
    }
    public int getValueIn(int row, int col) {
        return board[row][col];
    }
    public boolean[] getAllowedValues(int row, int col) {
        int setValues = board[row][col];
        boolean allowed[] = new boolean[9];
        for (int value = 1; value <= 9; value++) {
            board[row][col] = value;
            allowed[value-1] = checkPuzzle();
        }
        board[row][col] = setValues;
        return allowed;
    }
    public boolean isFull() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == 0)
                    return false;
        return true;
    }
    public void reset() { 
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                board[i][j] = start[i][j];
    }
    //from checkPuzzle
    private boolean checkRow(int row) {
        int count[] = new int[10];
        for (int col = 0; col < 9; col++) {
            count[board[row][col]]++;
        }
        boolean result = true;
        for (int i = 1; i <= 9; i++)
            result = result && (count[i] <= 1);
        return result;
    }
    private boolean checkCol(int col) {
        int count[] = new int[10];
        for (int row = 0; row < 9; row++) {
            count[board[row][col]]++;
        }
        boolean result = true;
        for (int i = 1; i <= 9; i++)
        	result = result && (count[i] <= 1);
        return result;
    }
    private boolean checkBox(int box) {
        int count[] = new int[10];
        int row = box - box % 3;
        int col = box - box % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count[board[row + i][col + j]]++;
            }
        }
        boolean result = true;
        for (int i = 1; i <= 9; i++)
        	result = result && (count[i] <= 1);
        return result;
    }
}
class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        for (int row = 0; row < 9; row++) 
        {
            for (int col = 0; col < 9; col++) 
            {
                if (board[row][col] != '.') 
                {
                    if (!isSafe(board, row, col, board[row][col])) 
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isSafe(char[][] sudoku, int row, int col, char digit) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (i != col && sudoku[row][i] == digit)
            {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) 
        {
            if (i != row && sudoku[i][col] == digit)
            {
                return false;
            } 
        }

        int subgridStartRow = (row / 3) * 3;
        int subgridStartCol = (col / 3) * 3;
        for (int i = subgridStartRow; i < subgridStartRow + 3; i++) 
        {
            for (int j = subgridStartCol; j < subgridStartCol + 3; j++) 
            {
                if ((i != row || j != col) && sudoku[i][j] == digit)
                {
                    return false;
                } 
            }
        }
        return true;
    }
}
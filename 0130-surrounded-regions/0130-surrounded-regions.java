class Solution {
    public void solve(char[][] board) {
        int height = board.length;
        int width = board[0].length;

        for(int i=0;i<height;i++)
        {
            if(board[i][0]=='O') dfs(board,i,0);
            if(board[i][width-1] == 'O') dfs(board,i,width-1);
        }

        for(int j=0;j<width;j++)
        {
            if(board[0][j]=='O') dfs(board,0,j);
            if(board[height-1][j]=='O') dfs(board,height-1,j);
        }

        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(board[i][j] == 'O') board[i][j]='X';
                if(board[i][j]=='S') board[i][j]='O';
            }
        }
    }

    public void dfs(char[][]board,int i,int j)
    {
        if(i<0 || j<0 || i>=board.length || j>= board[0].length ||board[i][j]== 'X' || board[i][j]== 'S')
        {
            return;
        }

        board[i][j] = 'S';

        dfs(board,i-1,j);  // up 
        dfs(board,i+1,j); // down
        dfs(board,i,j-1);  // left
        dfs(board,i,j+1);  // right

    }
}
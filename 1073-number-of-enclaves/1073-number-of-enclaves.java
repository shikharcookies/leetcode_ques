class Pair {
    int first;
    int second; 
    public Pair(int _first, int _second) {
        this.first = _first; 
        this.second = _second; 
    }
}


class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || i==n-1 || j==0 || j == m-1)
                {
                    if(grid[i][j]==1)
                    {
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};

        while(!q.isEmpty())
        {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int k=0;k<4;k++)
            {
                int nr = r +dr[k];
                int nc = c + dc[k];
                if(nr<n && nr>=0 && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0)
                {
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }

        int count = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0) count++;
            }
        }
        return count;
    }
}
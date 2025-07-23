class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colored = new int[graph.length];
        Arrays.fill(colored,-1);

        for(int i=0;i<graph.length;i++)
        {
            if(colored[i]==-1)
            {
                if(dfs(graph,colored,0,i)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean dfs(int[][]graph, int[] colored, int col, int node)
    {
        colored[node] = col;
        for(int neighbor: graph[node])
        {
            if(colored[neighbor]==-1)
            {
                if(dfs(graph,colored,1-col,neighbor)==false)
                {
                    return false;
                }
            }
            else if(colored[neighbor]==col)
            {
                return false;
            }
        }
        return true;
    }
}
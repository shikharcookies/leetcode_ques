class Solution {
    public boolean isBipartite(int[][] graph) {
        int colored[] = new int[graph.length];
        Arrays.fill(colored,-1);


        for(int i=0;i<colored.length;i++)
        {
            if(colored[i]==-1)
            {
                if(!bfs(graph,colored,i)) // covers disconnected components
                {
                    return false;

                }
            }
        }
        return true;
    }


    public boolean bfs(int[][]graph, int vis[], int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start]=0;

        while(!q.isEmpty())
        {
            int node = q.remove();
            for(int neighbor : graph[node])
            {
                if(vis[neighbor]==-1)
                {
                    if(vis[node]==1)
                    {
                        vis[neighbor]=0;
                    }
                    else {
                        vis[neighbor]=1;
                    }
                    q.add(neighbor);
                }
                else if(vis[neighbor]!= -1 && vis[neighbor] == vis[node])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
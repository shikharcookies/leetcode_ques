class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0,src,0));

        int[] dist = new int[n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist,Integer.MAX_VALUE);
        }
        dist[src]=0;


        while(!q.isEmpty())
        {
            Tuple it = q.peek();
            q.remove();

            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops>k) continue;

            for(Pair iter: adj.get(node))
            {
                int adjNode = iter.first;
                int edgeWeight = iter.second;


                if(cost+edgeWeight<dist[adjNode] && stops <=k)
                {
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuple(stops+1,adjNode, cost + edgeWeight));
                }
            }
        }

        if(dist[dst]== Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}



class Pair {
    int first;
    int second;
    Pair(int _first, int _second)
    {
        this.first = _first;
        this.second = _second;
    }
}


class Tuple {
    int first;
    int second;
    int third;
    Tuple(int _first, int _second, int _third)
    {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create adjacency list for storing flights info
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list with flight edges (from -> (to, cost))
        for (int i = 0; i < flights.length; i++) {
            // flights[i][0] = source
            // flights[i][1] = destination
            // flights[i][2] = cost
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Tuple format: (stops so far, current city, total cost)
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        // Distance array to track minimum cost to reach each city
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();

            int stops = it.first;   // Number of stops made so far
            int node = it.second;   // Current city
            int cost = it.third;    // Total cost so far

            // If stops exceed allowed limit, skip this path
            if (stops > k) continue;

            // Explore all neighbors (connected flights)
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;      // Destination city
                int edgeWeight = iter.second;  // Cost of flight to that city

                // If taking this flight gives cheaper cost, update and push to queue
                if (cost + edgeWeight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuple(stops + 1, adjNode, cost + edgeWeight));
                }
            }
        }

        // If no valid path found, return -1
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

// Helper class to store pair of (destination, cost)
class Pair {
    int first;   // destination node
    int second;  // cost
    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

// Helper class to store (stops, city, totalCost)
class Tuple {
    int first;   // number of stops so far
    int second;  // current city/node
    int third;   // total cost so far
    Tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        // Step 1: Build the reversed graph
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : graph[i]) {
                adjRev.get(it).add(i); // reverse the edge
                indegree[i]++;         // count original outgoing edges
            }
        }

        // Step 2: Topo sort (Kahn's Algorithm)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int prev : adjRev.get(node)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }

        // Step 3: Sort result
        Collections.sort(safeNodes);
        return safeNodes;
    }
}

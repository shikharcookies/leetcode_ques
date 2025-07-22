class Solution {
    public int findCircleNum(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length]; // Track visited cities
    int count = 0;

    for (int i = 0; i < isConnected.length; i++) {
        if (!visited[i]) { // Found a new province
            count++;
            dfs(isConnected, visited, i); //  Explore the entire province
        }
    }
    return count;
}

private void dfs(int[][] isConnected, boolean[] visited, int city) {
    visited[city] = true; //  Mark city as visited

    for (int i = 0; i < isConnected.length; i++) {
        if (isConnected[city][i] == 1 && !visited[i]) { // Explore connected cities
            dfs(isConnected, visited, i);
        }
    }
}
}
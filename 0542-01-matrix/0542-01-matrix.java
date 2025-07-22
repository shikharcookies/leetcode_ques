class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : dir) {
                int newR = row + direction[0];
                int newC = col + direction[1];

                if (newR >= 0 && newR < r && newC >= 0 && newC < c && mat[newR][newC] > mat[row][col] + 1) {
                    mat[newR][newC] = mat[row][col] + 1;
                    queue.add(new int[]{newR, newC});
                }
            }
        }

        return mat;
    }
}

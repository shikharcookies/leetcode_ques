class Solution {
    public int removeStones(int[][] stones) {
        int max_row = 0;
        int max_col = 0;

        for(int[]i : stones)
        {
            max_row = Math.max(max_row,i[0]);
            max_col = Math.max(max_col,i[1]);

        }


        DisjointSet ds = new DisjointSet(max_row + max_col +1);
        HashSet<Integer> stoneNodes = new HashSet<>();
        for(int[]it:stones)
        {
            int node_row = it[0];
        int node_col = it[1]+ max_row +1;
        ds.unionBySize(node_row,node_col);
        stoneNodes.add(node_row);
        stoneNodes.add(node_col);
        }

    int count = 0;
    for(int it : stoneNodes)
    {
        if(ds.findUPar(it)==it)
        {
            count++;
        }
    }
    return stones.length-count;
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
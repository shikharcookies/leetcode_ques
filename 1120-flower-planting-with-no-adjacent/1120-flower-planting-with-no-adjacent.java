class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i] = new ArrayList();
        }

        for(int[]path : paths)
        {
            graph[path[0]-1].add(path[1]-1);
            graph[path[1]-1].add(path[0]-1);
        }

        int[] colors = new int[n];
        for(int i=0;i<n;i++)
        {
            if(colors[i]>0) continue;


            boolean[] takencolors = new boolean[5];
            for(int neighbor: graph[i])
            {
                takencolors[colors[neighbor]] = true;
            }

            for(int c=1;c<=4;c++)
            {
                if(!takencolors[c])
                {
                    colors[i]=c;
                    break;
                }
            }
        }
        return colors;
    }
}
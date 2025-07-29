class Solution {
    public int maxJump(int[] stones) {
        int res = stones[1]-stones[0];  // first jump always from 0 to 1

        for(int i=2;i<stones.length;i+=2) // even indices
        {
            res = Math.max(res,stones[i]-stones[i-2]);
        }

        for(int i=3;i<stones.length;i+=2)
        {
            res = Math.max(res,stones[i]-stones[i-2]);
        }
        return res;
    }
}
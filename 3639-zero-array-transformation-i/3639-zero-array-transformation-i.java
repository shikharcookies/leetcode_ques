class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        
        int[] diff = new int[n];

// difference array approach : codeMik approach
        for(int[]query: queries)
        {
            int start = query[0];
            int end = query[1];
            int x = 1;

            diff[start] +=x;
            if(end+1<n)
            {
                diff[end+1] -=x;
            }
        }

        int[] result = new int[n];

        int totalSum = 0;
        for(int i=0;i<n;i++)
        {
            totalSum +=diff[i];
            result[i]=totalSum;
        }


        for(int i=0;i<n;i++)
        {
            if(result[i]<nums[i])
            {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[]t = new int[n];
        for(int i=0;i<n;i++)
        {
            t[i]=nums[i]*nums[i];
        }
        Arrays.sort(t);
        return t;
    }
}
class Solution {

    private static final int mod = (int)1e9+7;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0]=1;


        for(int i=1;i<n;i++)
        {
            power[i]=(power[i-1]*2)%mod;
        }

        int l=0,r=n-1;
        int res = 0;
        while(l<=r)
        {
            if(nums[l]+nums[r]<=target)
            {
                res = (res+power[r-l])%mod;
                l++;
            }
            else 
            {
                r--;
            }
        }
        return res;
    }
}
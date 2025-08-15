class Solution {
    public boolean isPowerOfTwo(int n) {
        return solve(n);
    }

    public boolean solve(int n)
    {
        if(n==1) return true;
        if(n<=0 || n%2!=0) return false;

        return solve(n/2);
    }
}
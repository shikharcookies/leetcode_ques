class Solution {
    public boolean isPowerOfThree(int n) {
        return solve(n);
    }

    public boolean solve(int n)
    {
        if(n==1) return true;
        if(n<=0 || n%3 != 0) return false;

        return solve(n/3);
    }
}
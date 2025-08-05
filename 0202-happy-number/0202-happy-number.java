class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = square(n);
        while(slow!=fast)
        {
            slow = square(slow);
            fast = square(square(fast));
        }
        return slow ==1;
    }

    public int square(int num)
    {
        int res = 0;
        while(num>0)
        {
            int rem  = num%10;
            res += rem*rem;
            num/=10;
        }
        return res;
    }
}
class Solution {
    public boolean reorderedPowerOf2(int n) {
        String str = check(n);

        for(int i=0;i<31;i++)
        {
            int pow = 1 <<i;
            if(check(pow).equals(str))
            {
                return true;
            }
        }
        return false;
    }

    public String check(int num)
    {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int[] arr = new int[101];
        
        int maxF = 0;
        int total = 0;

        for(int i:nums)
        {
            arr[i]++;

            int freq = arr[i];


            if(freq>maxF)
            {
                maxF = freq;
                total = freq;
            }
            else if(maxF == freq)
            {
                total +=freq;
            }
        }
        return total;
    }
}
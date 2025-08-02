class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int last1 = nums1[nums1.length-1][0];
        int last2 = nums2[nums2.length-1][0];
        int max = Math.max(last1,last2);
        int[] merge = new int[max+1];
        int n = merge.length;

        for(int[]num : nums1)
        {
            merge[num[0]] += num[1];
        }

         for(int[]num : nums2)
        {
            merge[num[0]] += num[1];
        }

        List<int[]> res = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(merge[i]>0)
            {
                res.add(new int[]{i,merge[i]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
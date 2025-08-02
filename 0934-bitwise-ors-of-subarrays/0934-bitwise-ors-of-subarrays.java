class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for(int i:arr)
        {
            Set<Integer> curr = new HashSet<>();
            curr.add(i);
            for(int j:prev)
            {
                curr.add(j|i);
            }
                 prev = curr;
                ans.addAll(curr);
        }
        return ans.size();
    }
}
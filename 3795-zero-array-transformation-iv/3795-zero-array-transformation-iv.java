import java.util.*;

class Solution {
    private int n;


    private boolean canTransform(int[] nums, int[][] queries, int k) {
     
        List<Set<Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new HashSet<>(Collections.singletonList(0)));
        }

        for (int qi = 0; qi <= k; qi++) {
            int l = queries[qi][0], r = queries[qi][1], val = queries[qi][2];
            for (int i = l; i <= r; i++) {
                Set<Integer> curr = dp.get(i);
                Set<Integer> newSums = new HashSet<>();
                for (int sum : curr) {
                    int next = sum + val;
                    if (next <= nums[i]) {
                        newSums.add(next);
                    }
                }
                curr.addAll(newSums);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!dp.get(i).contains(nums[i])) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        n = nums.length;
        int Q = queries.length;


        boolean allZero = true;
        for (int x : nums) {
            if (x != 0) { allZero = false; break; }
        }
        if (allZero) return 0;


        int l = 0, r = Q - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canTransform(nums, queries, mid)) {
                ans = mid + 1; 
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

class Solution {
  public int minZeroArray(int[] nums, int[][] queries) {
    if (Arrays.stream(nums).allMatch(num -> num == 0)) return 0;

    final int n = nums.length;
    Set<Integer>[] dp = new Set[n];
    for (int i = 0; i < n; ++i) dp[i] = new HashSet<>(List.of(0));

    for (int k = 0; k < queries.length; ++k) {
      int l = queries[k][0], r = queries[k][1], val = queries[k][2];
      for (int i = l; i <= r; ++i) {
        Set<Integer> curr = dp[i];
        List<Integer> newSums = new ArrayList<>();
        for (int sum : curr) newSums.add(sum + val);
        curr.addAll(newSums);
      }
      boolean ok = IntStream.range(0, n)
                        .allMatch(i -> dp[i].contains(nums[i]));
      if (ok) return k + 1;
    }
    return -1;
  }
}

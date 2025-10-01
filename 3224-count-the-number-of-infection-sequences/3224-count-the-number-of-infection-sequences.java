class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] fact, invFact;
    private long[] pow2;

    public int numberOfSequence(int n, int[] sick) {
        int m = sick.length;
        // total healthy = n - m
        int totalHealthy = n - m;

        // Precompute factorials and inverses up to totalHealthy
        initFactorials(totalHealthy);

        // Also precompute powers of 2 up to totalHealthy
        pow2 = new long[totalHealthy + 1];
        pow2[0] = 1;
        for (int i = 1; i <= totalHealthy; i++) {
            pow2[i] = (pow2[i-1] * 2) % MOD;
        }

        // Build the gaps (groups)
        // We use an “extended sick” with boundaries at -1 and n
        int[] ext = new int[m + 2];
        ext[0] = -1;
        for (int i = 0; i < m; i++) ext[i+1] = sick[i];
        ext[m+1] = n;

        long answer = fact[totalHealthy];  // S!
        int prev = ext[0];

        for (int i = 1; i < ext.length; i++) {
            int curr = ext[i];
            int gap = curr - prev - 1;  // number of healthy in between
            prev = curr;
            if (gap == 0) continue;

            // divide by gap
            answer = answer * invFact[gap] % MOD;

            // if this is a “middle” group (i not 1, not last index)
            if (i != 1 && i != ext.length - 1) {
                // multiply by 2^(gap - 1)
                answer = answer * pow2[gap - 1] % MOD;
            }
        }

        return (int) answer;
    }

    private void initFactorials(int N) {
        fact = new long[N + 1];
        invFact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i-1] * i % MOD;
        }
        // Fermat’s little theorem to compute invFact[N] = fact[N]^(MOD-2)
        invFact[N] = modPow(fact[N], MOD - 2);
        for (int i = N; i >= 1; i--) {
            invFact[i-1] = invFact[i] * i % MOD;
        }
    }

    private long modPow(long x, long e) {
        long res = 1;
        x %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            e >>= 1;
        }
        return res;
    }
}

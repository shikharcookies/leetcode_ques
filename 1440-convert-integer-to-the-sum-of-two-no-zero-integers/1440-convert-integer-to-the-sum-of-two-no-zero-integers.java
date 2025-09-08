class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = n;
        int b = 0;
        int placeValue = 1;

        while (n > 1) {
            int adjust = 1;

            // If the last digit is 1, subtracting 1 would make a have a zero, avoid
            if (n % 10 == 1) {
                adjust = 2;
            }

            a -= adjust * placeValue;
            b += adjust * placeValue;

            n = (n - adjust) / 10; // move to next digit
            placeValue *= 10;
        }

        return new int[]{a, b};

        // T.C : O(logn).. S.C : O(1)
    }
}
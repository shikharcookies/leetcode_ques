class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j || !(points[i][0] <= points[j][0] && points[i][1] >= points[j][1])) continue;

                boolean isAnotherPointInside = false;
                for(int k=0; k<n; k++) {
                    if(k == i || k == j) continue;

                    boolean isXContained = points[k][0] >= points[i][0] && points[k][0] <= points[j][0];
                    boolean isYContained = points[k][1] <= points[i][1] && points[k][1] >= points[j][1];
                    if(isXContained && isYContained) {
                        isAnotherPointInside = true;
                        break;
                    }
                }

                if(!isAnotherPointInside) ans++;
            }
        }
        return ans;
    }
}
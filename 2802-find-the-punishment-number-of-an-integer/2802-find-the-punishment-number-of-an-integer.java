class Solution {
    private boolean canpunish(String s , int index , int target){
        if(index==s.length()) return target==0;
        int sum=0;
        for(int i=index ; i<s.length() ;i++){
            sum = sum*10 + s.charAt(i)-'0';
            if(sum>target) break;
            if(canpunish(s , i+1 , target - sum)) return true;
        }
        return false;
    }
    private boolean ispunish(int n){
        int sq = n*n;
        return canpunish(Integer.toString(sq) , 0 , n);
    }
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1 ;i <= n ;i++){
            if(ispunish(i)){
                ans+=(i*i);
            }
        }
        return ans;
    }
}
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=1;i<=60;i++){
            long target=(long)num1-(long)i*num2;
            if(target<i) continue;
            if(Long.bitCount(target)<=i) return i;
        }
        return -1;
    }
}
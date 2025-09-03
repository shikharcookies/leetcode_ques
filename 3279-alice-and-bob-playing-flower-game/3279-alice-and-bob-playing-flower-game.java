class Solution {
    public long flowerGame(int n, int m) {
    
        if(m == 1 && n == 1){
          return 0;
        }
        
       long nOdd = n/2 + (n%2!=0?1:0);
       long nEven = n/2;

       long mOdd = m/2 + (m%2!=0?1:0);
       long mEven = m/2;
   
        return nOdd*mEven + mOdd*nEven;
    }
}

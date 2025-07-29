class Solution {
    public int countPrimes(int n) {
		int count =0;
        boolean[] check = new boolean[n] ;
        return sieve(n,check) ;
    }
	

    static int sieve(int n, boolean[] check) {
		for(int i=2; i*i<n; i++) {
		
		// if boolean value is false means number is prime
		
			if(!check[i]) {
			
			// we used j=i*i to reduce time (we can do j = 2*i but this will do repetative task)
			
				for(int j=i*i; j<n; j+=i) {
				
				// if boolean value is true means number is not prime 
				
					check[j] = true ;
				}
			}
		}
		
		//to count prime number: if value is false then number at that index is prime
		
		int count = 0 ;
		for(int i =2;i<n;i++) {
			if(!check[i]) {
				count++ ;
			}
		}
		return count ;
	}
}
class Solution {
    public int twoCitySchedCost(int[][] costs) {
         
    Queue<Integer> pq = new PriorityQueue<>();
    int sum=0;
    
    for(int[] arr : costs)
    {
        sum+=arr[0];
        pq.add(arr[0]-arr[1]);
        if(pq.size()>costs.length/2) pq.poll();
    }
    while(pq.size()>0)
    {
        sum-=pq.poll();
    }
    return sum;
    }
}
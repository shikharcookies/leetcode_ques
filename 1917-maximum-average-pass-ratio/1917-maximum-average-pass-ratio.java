class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0]) 
        );
        for (int[] cls : classes) {
            double pass = cls[0];
            double total = cls[1];
            double marginalGain = (pass + 1) / (total + 1) - pass/total;
            pq.offer(new double[]{marginalGain, pass, total});
        }
        while (extraStudents-- > 0) {
            double[] current = pq.poll();
            double pass = current[1] + 1;
            double total = current[2] + 1;
            double newMarginalGain = (pass + 1)/(total + 1) - pass/total;
            pq.offer(new double[]{newMarginalGain, pass, total});
        }
        double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            double[] cls = pq.poll();
            totalRatio += cls[1] / cls[2];
        }
        return totalRatio / classes.length;
    }
}
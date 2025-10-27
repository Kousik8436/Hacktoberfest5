class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        // Add points to heap
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove farthest point
            }
        }

        // Prepare result
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] p = maxHeap.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(p[0]);
            temp.add(p[1]);
            result.add(temp);
        }

        return result;
    }
}

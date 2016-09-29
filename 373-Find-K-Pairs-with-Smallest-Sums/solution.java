/**
 * 
 * 373. Find K Pairs with Smallest Sums
 * 
 * 
 * 
 */
 
 
// s1: brute force
// O(n^2), O(n)
// hard to think

// s1: use heap, consider: 378. Kth Smallest Element in a Sorted Matrix
// O(klogk), O(n^2)

public class Solution {
    class Number{
        int x;
        int y;
        public Number(int x, int y, int val) {
            this.x = x;
            this.y = y;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // corner case
        List<int[]> result = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0) {
            return result;
        }
        if (nums2 == null || nums2.length == 0) {
            return result;
        }
        if (k <= 0) {
            return result;
        }
        Queue<Number> queue = new PriorityQueue<Number>(new Comparator<Number>(){
                @Override
                int public compare(Number n1, Number n2) {
                    return nums1[n1.x] + nums2[n1.y] > nums1[n2.x] + nums2[n2.y]
                }
            });
        boolean[][] hash = new boolean[nums1.length][nums2.length];
        queue.offer(new Number(0, 0));
        hash[0][0] = true;
        
        // direction triky
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        
        for (int i = 0; i < k; i++) {
            Number num = queue.poll();
            int[] array = new int[2];
            array[0] = nums1[num.x];
            array[1] = nums2[num.y];
            result.add(array);
            for (int j = 0; j < 2; j++) {
                int nx = num.x + dx[j];
                int ny = num.y + dy[j];
                if (isValid(nx, ny, nums1, nums2, hash)) {
                    queue.offer(new Number(nx, ny));
                    hash[nx][ny] = true;
                }
            }
        }
        return result;
    }
    
    public boolean isValid(int nx, int ny, int[] nums1, int[] nums2, boolean[][] hash) {
        boolean result = false;
        if (nx < nums1.length && ny < nums2.length && !hash[nx][ny]) {
            result = true;
        }
        return result;
    }
    
}
/*
public class Solution {
    // Use quick sort 
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int index = partition(nums, left, right) ;
            if (index < k) {
                left = index + 1;
            } else if (index > k) {
                right = index - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left <= right) {
            while(nums[left] < pivot) {
                left++;
            }
            while(nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;        
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
*/


// s1: Arrays.sort() method
// O(nlogn), O(1)

/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
*/

// s1: Arrays.sort() method again
// O(nlogn), O(1)

/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // convert int[] to Integer[]
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = Integer.valueOf(nums[i]);
        }
        
        
        // Arrays.sort(nums);
        Arrays.sort(newNums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        
        // return nums[nums.length - k];
        return newNums[k - 1];
    }
}
*/

// s2: use max heap
// O(nlogn), O(n)

/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }                
            });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }
}
*/


// s2*: use heap, maintain the k size
// O(nlogk), O(n)

/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<Integer>();
        
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
*/

// s3*: use quick sort
// O(n), O(1)
// ticky, T(n) = T(n / 2) + O(n),   T(n) = O(n)

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int k = nums.length - k + 1;
        int result = helper(0, nums.length - 1, nums, k);
        return result;
    }
    
    public int helper(int start, int end, int[] nums, int k) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(left, right, nums);
                left++;
                right--;
            }
        }       
        if (left <= k) {
            return helper(left, end, nums, k - left);
        } else {
            return helper(start, left - 1, nums, k);
        }
        
    }
    
    public void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}



/**
 * 
 * 295. Find Median from Data Stream
 * 1 solution
 * 
 * 
 */


// s1: use Heap
// O(n^2logn), O(n)
// time limit exceeded

/*
public class MedianFinder {


    Queue<Integer> queue = new PriorityQueue<Integer>();
    List<Integer> list = null;
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        queue.offer(num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        Iterator<Integer> iterator = queue.iterator();
        list = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.sort(list);
        int m = list.size();
        return (double)(list.get(m / 2) + list.get((m - 1) / 2)) / 2;
    }
};
*/


// s2: use 2 heaps: a max heap and a min heap
// O(nlogn), O(n)

public class MedianFinder {
    
    Queue<Integer> minQueue = new PriorityQueue<Integer>();
    Queue<Integer> maxQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minQueue.isEmpty() && maxQueue.isEmpty()) {
            maxQueue.offer(num);
        } else if (minQueue.size() == maxQueue.size()){
            if (num <= maxQueue.peek()) {
                maxQueue.offer(num);
            } else if (num >= minQueue.peek()) {
                minQueue.offer(num);
            } else {
                maxQueue.offer(num);
            }
        } else if (minQueue.size() > maxQueue.size()) {
            if (num <= minQueue.peek()) {
                maxQueue.offer(num);
            } else {
                minQueue.offer(num);
                maxQueue.offer(minQueue.poll());
            }
        } else if (maxQueue.size() > minQueue.size()) {
            if (num >= maxQueue.peek()) {
                minQueue.offer(num);
            } else {
                maxQueue.offer(num);
                minQueue.offer(maxQueue.poll());
            }
        }
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        } else if (maxQueue.size() < minQueue.size()) {
            return minQueue.peek();
        } else {
            return (double)(maxQueue.peek() + minQueue.peek()) / 2;
        }
        
    }
    
}


// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
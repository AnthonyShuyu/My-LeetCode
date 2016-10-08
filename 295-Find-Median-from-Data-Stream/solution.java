/**
 * 
 * 295. Find Median from Data Stream
 * 
 */


// s1: use Heap
// O(n^2logn), O(n)
// time limit exceeded

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

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
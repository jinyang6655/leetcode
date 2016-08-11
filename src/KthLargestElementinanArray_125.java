import java.util.PriorityQueue;

/**
 * Created by yjin on 8/6/16.
 */
public class KthLargestElementinanArray_125 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        for(int val:nums){
            minHeap.add(val);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        return minHeap.poll();
    }
}

import java.util.PriorityQueue;

public class KthLargest {
	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}

	public static void main(String[] args) {
		int[] a = {3,2,7,4,1,5,6};
		System.out.println(findKthLargest(a,2));
	}
}

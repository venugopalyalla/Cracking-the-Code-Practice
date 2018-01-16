
public class ArrayShrink {

	static int findEndOfLeftSeq(int[] a) {
		for(int i=1; i<a.length;i++) {
			if(a[i]<a[i-1]) {
				return i-1;
			}
		}
		return a.length-1;
	}
	static int findStartOfRightSeq(int[] a) {
		for(int i=a.length-2; i>=0; i++) {
			if(a[i]>a[i+1]) {
				return i+1;
			}
		}
		return 0;
	}
	static int shrinkLeft(int[] a, int min_index, int end) {
		int c = a[min_index];
		for(int i=end-1;i>=0;i--) {
			if(a[i]<=c) return i+1;
		}
		return 0;
	}
	static int shrinkRight(int[] a, int max_index, int start) {
		int c = a[max_index];
		for(int i=start; i<a.length;i++) {
			if(a[i]>=c) {
				return i-1;
			}
		}
		return a.length-1;
	}
	static void sortMin(int[] array) {
		int end_left = findEndOfLeftSeq(array);
		if(end_left == array.length-1) return;
		int start_right = findStartOfRightSeq(array);
		int max_index = end_left;
		int min_index = start_right;
		for(int i=end_left+1; i<start_right; i++) {
			if(array[i]<array[min_index]) {
				min_index = i;
			}
			if(array[i] >array[max_index]) {
				max_index = i;
			}
		}
		int left_index = shrinkLeft(array, min_index, end_left);
		int right_index = shrinkRight(array, max_index, start_right);
	}
	public static void main(String[] args) {
		int[] a = {1,2,4,7,10,11,7,12,6,7,16,18,19};
	}
}

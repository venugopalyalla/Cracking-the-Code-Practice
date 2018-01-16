
public class BubbleSort {

	static int[] sortUsingInsertion(int[] array) {
		for(int i=1; i<array.length;i++) {
			int key = array[i];
			int j = i-1;
			while(j>=0 && array[j] > key) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1]=key;
		}
		return array;
	}
	static void merge(int[] array, int[] helper, int low, int middle, int high) {
		for(int i=low; i<=high; i++) {
			helper[i]=array[i];
		}
		int hLeft = low;
		int hRight = middle+1;
		int current = low;
		while(hLeft <= middle && hRight <= high) {
			if(helper[hLeft] <= helper[hRight]) {
				array[current] = helper[hLeft];
				hLeft++;
			} else {
				array[current] = helper[hRight];
				hRight++;
			}
			current++;
		}
		int rem = middle-hLeft;
		for(int i=0; i<=rem; i++) {
			array[current+i] = helper[hLeft+i];
		}
	}
	static void mergeSort(int[] array, int[] helper, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergeSort(array, helper, low, mid);
			mergeSort(array, helper, mid+1, high);
			merge(array, helper, low, mid, high);
		}
	}
	static void sortUsingMerge(int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array,helper,0,array.length-1);
	}
	static int[] sortUsingSelection(int[] array) {
		for(int i=0; i<array.length; i++) {
			int minIndex=i;
			for(int j=i+1; j<array.length;j++) {
				if(array[j]<array[minIndex]) {
					minIndex = j;
				}
			}
			int smallestNum = array[minIndex];
			array[minIndex] = array[i];
			array[i] = smallestNum;
		}
		return array;
	}
	static int[] sortUsingBubble(int[] array) {
		for(int i=0; i<array.length;i++) {
			for(int j=0; j<array.length-1;j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i=low-1;
		for(int j=low; j<=high-1;j++) {
			if(array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, high);
		return i+1;
	}
	static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pi = partition(array, low, high);
			quickSort(array,low,pi-1);
			quickSort(array,pi+1,high);
		}
	}
	static int[] bucketSort(int[] a) {
		int[] buckets = new int[10];
		for(int i=0; i<a.length; i++) {
			int bi = a[i]%10;
			buckets[bi] = bi;
		}
		return buckets;
	}
	static void sortUsingQuick(int[] array) {
		quickSort(array,0,array.length-1);
	}
	public static void main(String[] args) {
/*		int[] a = {1,8,4,9,6,2,5,3,7,12,16,3,15,20,21,22,23,24,25};
		int[] b = a;
		sortUsingQuick(b);
		for(int i=0; i<b.length;i++) {
			System.out.println(b[i]);
		}
*/		int[] unsorted = {5,3,7,1,9,8,2,6};
		int[] sorted = bucketSort(unsorted);
		for(int i=0; i<sorted.length;i++) {
			if(sorted[i] != 0) {
				System.out.println(sorted[i]);
			}
		}
	}
}

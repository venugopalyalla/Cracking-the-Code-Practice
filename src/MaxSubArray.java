public class MaxSubArray {
	static long subarraySum(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (((long) arr[i]) * ((long) (i + 1)) * ((long) (arr.length - i)));
		}
		return sum;
	}

	static int maxProduct(int[] a) {
		int max_ending_here = 1;
		int min_ending_here = 1;
		int max_so_far = 1;
		for(int i=0; i<a.length; i++) {
			if(a[i] > 0) {
				max_ending_here = max_ending_here*a[i];
				min_ending_here = Math.min(min_ending_here*a[i], 1);
			} else if(a[i]==0) {
				max_ending_here = 1;
				min_ending_here = 1;
			} else {
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here*a[i],1);
				min_ending_here = temp*a[i];
			}
			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}
	static int cciMaxSum(int[] a) {
		int sum=0;
		int maxSum=0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
			if(sum > 0) {
				if(sum > maxSum) {
					maxSum = sum;
				}				
			} else {
				sum = 0;
			}
		}
		return maxSum;
	}
	static int maxSumVenu(int[] a) {
		int sum=0, maxSum=0;
		for(int i=0; i<a.length;i++) {
			sum = Math.max(a[i], a[i]+sum);
			if(sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	static int maxContSum(int[] a) {
		int maxEndingHere = a[0];
		int maxSoFar = a[0];
		for(int i=0; i<a.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + a[i], a[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] a = { -2,-3,4,-1,-2,-1,5,-3 };
		System.out.println(maxContSum(a));
		System.out.println(maxSumVenu(a));
		System.out.println(cciMaxSum(a));
		System.out.println(maxProduct(a));
	}
}
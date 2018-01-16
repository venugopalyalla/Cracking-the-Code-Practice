import java.util.Arrays;

public class MinDiffOneFromEachArray {

	static int minDiff(int[] a1, int[] a2) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		int a=0,b=0, min = Integer.MAX_VALUE;
		while(a<a1.length && b < a2.length) {
			if(Math.abs(a1[a]-a2[b])<min) {
				min = Math.abs(a1[a]-a2[b]);
			}
			if(a1[a] <a2[b]) {
				a++;
			} else {
				b++;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int[] a = {1,3,15,11,2};
		int[] b = {23,127,11,19,8};
		System.out.println("Minimum difference = " + minDiff(a,b));
	}
}

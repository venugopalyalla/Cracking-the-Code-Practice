import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		Integer[] a = {5,3,8,2,1,6,9,8};
		Arrays.sort(a);
		//Arrays.sort(a, Collections.reverseOrder());
		System.out.println("Array a is : " + Arrays.toString(a));
		Integer i = new Integer(6);
		String str = i.toString();
		System.out.println(str);
/*		int j = 6;
		System.out.println(j.toString());
*/	}
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LinShift {

	static int[] linShift(int[] ip) {
		int[] res = new int[ip.length];
		Queue<Integer> pos = new LinkedList<>();
		Queue<Integer> neg = new LinkedList<>();
		for (int i : ip) {
			if (i >= 0) {
				pos.add(i);
			} else {
				neg.add(i);
			}
		}
		int negSize = neg.size();
		for (int i = 0; i < negSize; i++) {
			res[i] = neg.remove();
		}
		int posSize = pos.size();
		for (int i = 0; i < posSize; i++) {
			res[i+negSize] = pos.remove();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 5,-3,0,9,-2 };
		System.out.println(Arrays.toString(linShift(a)));
	}
}

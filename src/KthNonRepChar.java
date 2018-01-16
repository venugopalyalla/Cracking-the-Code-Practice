import java.util.Arrays;

public class KthNonRepChar {

	static final int NUM_CHAR = 256;

	static int kthNonRep(String s, int k) {
		int[] index = new int[NUM_CHAR];
		int[] count = new int[NUM_CHAR];
		int n = s.length();
		for (int i = 0; i < NUM_CHAR; i++) {
			index[i] = n;
			count[i] = 0;
		}
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			count[x]++;
			if (count[x] == 1) {
				index[x] = i;
			}
			if (count[x] == 2) {
				index[x] = n;
			}
		}
		Arrays.sort(index);
		return (index[k - 1] != n) ? index[k - 1] : -1;
	}

	public static void main(String[] args) {
		String str = "Geeksforgeeks";
		int k = 6;
		int res = kthNonRep(str, k);
		if (res != -1) {
			System.out.println(str.charAt(res));
		} else {
			System.out.println("Less than " + k + " non repeating characters in the given string");
		}
	}
}

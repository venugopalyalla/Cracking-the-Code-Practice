
public class FirstNonRepChar {
	static final int CHAR_COUNT = 256;
	static int[] getCountArray(String s, int[] count) {
		for(int i=0; i<s.length(); i++) {
			count[s.charAt(i)]++;
		}
		return count;
	}
	static char firstNonRepCh(String s) {
		int[] count = new int[CHAR_COUNT];
		count = getCountArray(s,count);
		for(int i=0; i<s.length(); i++) {
			if(count[s.charAt(i)] == 1) {
				return s.charAt(i);
			}
		}
		return ' ';
	}

	public static void main(String[] args) {
		String str = "VenugopalReddyYallaNotVeryGoodGeek";
		System.out.print(firstNonRepCh(str));
	}
}

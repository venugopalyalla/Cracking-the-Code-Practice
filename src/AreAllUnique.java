
public class AreAllUnique {

	static boolean checkIfUniq(String s) {
		int checker = 0;
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i)-'a';
			System.out.println(s.charAt(i) + " " + val + " " + (1 << val) + " " + (checker & (1 << val)));
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	public static void main(String[] args) {
		String str = "inputstring";
		System.out.println("All chars unique?\n" + checkIfUniq(str));
	}
}

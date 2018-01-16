
public class OneCharAwayStrings {

	static boolean oneEditReplace(String s1, String s2) {
		boolean foundAlready = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundAlready) {
					return false;
				}
				foundAlready = true;
			}
		}
		return true;
	}

	static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	static boolean oneEditAway(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return oneEditReplace(s1, s2);
		} else if (s1.length() + 1 == s2.length()) {
			return oneEditInsert(s1, s2);
		} else if (s1.length() - 1 == s2.length()) {
			return oneEditInsert(s2, s1);
		}
		return false;
	}

	public static void main(String[] args) {
		String str1 = "venu";
		String str2 = "ven u";
		System.out.println(oneEditAway(str1, str2));
	}
}

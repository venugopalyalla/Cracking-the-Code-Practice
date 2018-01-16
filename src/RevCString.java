
public class RevCString {

	static String revCStr(String s) {
		int j = s.length() - 1;
		char[] tmp = s.toCharArray();
		char t;
		int i=0;
		while (i < j) {
			t = tmp[i];
			tmp[i++] = tmp[j];
			tmp[j--] = t;
		}
		return new String(tmp);
	}

	public static void main(String[] args) {
		String str = "aa aa aa a a aaa a a a.";
		System.out.println(revCStr(str));
	}
}


public class StringCompressionCount {

	static String stringComp(String str) {
		StringBuffer sb = new StringBuffer();
		int count=0;
		char ch = str.charAt(0);
		for(int i=0; i<str.length();i ++) {
			if(str.charAt(i) == ch) {
				count++;
			} else {
				sb.append(ch + "" + count);
				count = 1;
			}
			ch = str.charAt(i);
		}
		sb.append(ch + ""+ count);
		return sb.length()<str.length()? sb.toString() : str;
	}

	public static void main(String[] args) {
		String str = "aaa";
		System.out.println(stringComp(str));
	}
}

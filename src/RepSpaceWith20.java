
public class RepSpaceWith20 {

	static String repWith20(String s) {
		char[] ch = s.toCharArray();
		int len = ch.length, newLength;
		int numSpaces = 0;
		for(int i=0; i<len;i++) {
			if(ch[i] == ' ') {
				numSpaces++;
			}
		}
		newLength = len + (numSpaces*2);
		
		char[] newStr = new char[newLength];
		int j=0;
		for(int i=0; i<len;i++) {
			if(ch[i] != ' ') {
				newStr[j++] = s.charAt(i);
			} else {
				newStr[j++] = '%';
				newStr[j++] = '2';
				newStr[j++] = '0';
			}
		}
		return new String(newStr);
	}
	public static void main(String[] args) {
		String str = "This is the input string with multiple spaces";
		System.out.println(repWith20(str));
	}
}

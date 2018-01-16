
public class KthCharInString {

	static String intToBin(int a) {
		StringBuffer sb = new StringBuffer();
		while(a != 0) {
			sb.append(a%2);
			a = a/2;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		int a = 1;
		String s = intToBin(a);
		System.out.println(s);
		for(int i=0; i<2; i++) {
			s = s.replace("0", "01");
			s = s.replace("1", "10");
		}
		System.out.println(s);
	}
}

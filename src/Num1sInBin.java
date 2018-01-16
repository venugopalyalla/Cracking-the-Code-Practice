
public class Num1sInBin {

	public static void main(String[] args) {
		int y = 4;
		System.out.println(y >> 2);
		System.out.println(y >>> 1);
		System.out.println(Integer.parseInt("100", 2) + Integer.parseInt("110", 2));

		int n = 100;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int d = n % 2;
			if (d == 1) {
				count++;
			}
			n = n / 2;
			sb.append(d);
		}
		String str = sb.reverse().toString();
		System.out.println(str);
		char[] ch = str.toCharArray();
		for(int i=0; i< ch.length; i++) {
			if(ch[i] == '0') {
				ch[i] = '1';
			} else {
				ch[i] = '0';
			}
		}
		String neg = new String(ch);
		System.out.println(neg);
		System.out.println(Integer.parseInt(neg,2) + Integer.parseInt("1",2));
	}
}

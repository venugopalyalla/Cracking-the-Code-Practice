
public class CompVersionNum {

	static String compVersions(String s1, String s2) {
		int i=0;
		String[] a1 = s1.split("\\.");
		String[] a2 = s2.split("\\.");
		String op1 = "Version 1 is later that version 2";
		String op2 = "Version 2 is later that version 1";
		int n1 = a1.length, n2 = a2.length;
		while(i < n1 || i < n2) {
			if(i < n1 && i < n2) {
				if(Integer.parseInt(a1[i]) < Integer.parseInt(a2[i])) {
					return op2;
				}
				if(Integer.parseInt(a2[i]) < Integer.parseInt(a1[i])) {
					return op1;
				}
			}else if(i < n1 && Integer.parseInt(a1[i]) > 0) {
				return op1;
			}else if(i < n2 && Integer.parseInt(a2[i]) > 0) {
				return op2;
			}
			i++;
		}
		return "Both versions are same";
	}

	public static void main(String[] args) {
		String v1 = "2.0";
		String v2 = "2";
		System.out.println(compVersions(v1,v2));
	}
}

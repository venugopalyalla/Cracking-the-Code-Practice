
public class GetMaxWithoutEquals {

	static int flip(int bit) {
		return 1^bit;
	}
	static int sign(int a) {
		return flip((a >> 31)&0x1);
	}
	static int getMax(int a, int b) {
		int c=a-b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int using_sa = sa^sb;
		int using_sc = flip(sa^sb);
		int k = using_sa*sa + using_sc*sc;
		int q = flip(k);
		return a*k + b*q;
	}
	public static void main(String[] args) {
		int a=-100, b=500;
		System.out.println("Max is " + getMax(a,b));
	}
}


public class MathWithAdd {

	static int negate(int i) {
		int neg=0;
		int count = 0;
		int newSign = i>0? -1:1;
		int delta = newSign;
		while(i != 0) {
			count++;
			boolean diffSigns = (i+delta>0) != (i>0);
			if(i + delta !=0 && diffSigns) {
				delta = newSign;
			}
			neg += delta;
			i += delta;
			delta += delta;
		}
		System.out.println(count);
		return neg;
	}
	public static void main(String[] args) {
		int a=58;
		System.out.println(negate(a));
	}
}

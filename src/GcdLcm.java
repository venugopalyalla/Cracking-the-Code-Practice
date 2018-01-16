
public class GcdLcm {

	static int getGcd(int x, int y) {
		int a = x>y? x: y;
		int b = x>y? y: x;
		int r = b;
		while(a%b !=0) {
			r = a%b;
			a=b;
			b=r;
		}
		return r;
	}
	static int getLcm(int x, int y) {
		int r = x>y? x : y;
		while(true) {
			if(r%x==0 && r%y==0) {
				return r;
			}
			r++;
		}
	}
	public static void main(String[] args) {
		System.out.println(getGcd(100,20));
		System.out.println(getLcm(102,20));
	}
}

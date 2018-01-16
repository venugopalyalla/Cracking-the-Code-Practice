
public class FlipToWin {

	static void printBinary(double d) {
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		while(d > 0) {
			if(d*2 >= 1) {
				sb.append('1');
				d = d*2-1;
			} else {
				sb.append('0');
				d *= 2;
			}
			if(sb.length()>32) {
				System.out.println("ERROR");
				return;
			}
		}
		System.out.println(sb.toString());
	}
	static int maxOneFlip(int n) {
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1;
		int a = n;
		while(a != 0) {
			if((a&1)==1) {
				currentLength++;
			} else {
				previousLength = (a&2)==0? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength+currentLength+1,maxLength);
			a >>= 1;
		}
		return maxLength;
	}
	public static void main(String[] args) {
		//System.out.println(maxOneFlip(3));
		printBinary(0.25);
	}
}

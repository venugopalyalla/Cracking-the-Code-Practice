
public class NumberOf2s {

	static int bruteAppr(int num) {
		int count = 0;
		for(int i=2; i<=num; i++) {
			count += count2sInNum(i);
		}
		return count;
	}
	static int count2sInNum(int n) {
		int count = 0;
		while(n>0) {
			if(n%10==2) {
				count++;
			}
			n=n/10;			
		}
		return count;
	}
	static int count2sAtDigit(int num, int d) {
		int powOf10 = (int) Math.pow(num, d);
		int nextPowOf10 = powOf10*10;
		int roundDown = num - num%nextPowOf10;
		int roundUp = num + nextPowOf10;
		int right = num%powOf10;
		int digit = (num/powOf10)%10;
		if(digit<2) {
			return roundDown/10;
		} else if(digit ==2) {
			return roundDown/10 + right + 1;
		} else {
			return roundUp/10;
		}
	}
	static int numberOf2s(int num) {
		int count = 0;
		int len = String.valueOf(num).length();
		for(int digit=0; digit < len; digit++) {
			count += count2sAtDigit(num,digit);
		}
		return count;
	}
	public static void main(String[] args) {
		int a = 22;
		System.out.println("Formula approach = " + numberOf2s(a));
		System.out.println("Brute Force approach = " + bruteAppr(a));
	}
}

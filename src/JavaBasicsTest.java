import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class JavaBasicsTest {

	static int negate(int a) {
		int neg=0;
		int newSign= a>0? -1: 1;
		int delta = newSign;
		while(a!=0) {
			boolean diffSigns = (a+delta>0)!=(a>0);
			if(a+delta != 0 && diffSigns) {
				delta = newSign;
			}
			neg += delta;
			a += delta;
			delta += delta;
		}
		return neg;
	}
	static int flip(int bit) {
		return (bit^1);
	}
	static int sign(int x) {
		return flip(x>>31)&0x1;
	}
	static int add(int a, int b) {
		if(b==0) return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum,carry);
	}
	static int numOfFactors(int num) {
		int count = 2;
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) {
				count++;
			}
		}
		return count;
	}
	static int numFactors(int num) {
		int n = 5,c=0, a = num;
		while(a > 0) {
			c += a/n;
			a = a/n;
		}
		System.out.println("while loop count = " + c);
		if(num<=0) {
			return -1;
		}
		int count=0;
		for(int i=5;num/i>0; i*= 5) {
			count += num/i;
		}
		return count;
	}
	static int lenOfInt(int n) {
		int count = 0;
		while(n>0) {
			count++;
			n=n/10;
		}
		return count;
	}
	static int swapOddEventBits(int n) {
		return (((n&0xaaaaaaaa)>>>1)|((n&0x55555555)<<1));
	}
	static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);			
		}
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
		return s;
	}
	static int flipNumBits(int a, int b) {
		int count=0;
		for(int c=a^b; c !=0; c=c&(c-1)) {
			count++;
		}
		return count;
	}
	static void sortedInsert(Stack<Integer> s, int x) {
		if(s.isEmpty() || x < s.peek()) {
			s.push(x);
			return;
		}
		int temp = s.pop();
		sortedInsert(s,x);
		s.push(temp);
	}
	static void sortStackWithoutDS(Stack<Integer> s) {
		if(s==null) {
			return;
		}
		if(!s.isEmpty()) {
			int x = s.pop();
			sortStackWithoutDS(s);
			sortedInsert(s,x);
		}
	}
	static int getPrev(int n) {
		int c=n, c1=0, c0=0;
		while((c&1)==1) {
			c1++;
			c >>= 1;
		}
		if(c==1) {
			return -1;
		}
		while(((c&1)==0) && (c != 0)) {
			c0++;
			c >>=1;
		}
		if((c1+c0==31)||(c1+c0==0)) {
			return -1;
		}
		int p=c0+c1;
		n &= ((~0)<<(p+1));
		int mask = (1<<(c1+1))-1;
		n |= mask<<(c0-1);
		return n;
	}
	static int nextBigger(int n) {
		int c=n, c1=0,c0=0;
		while(((c&1)==0)&&(c!=0)) {
			c0++;
			c >>=1;
		}
		while((c&1)==1) {
			c1++;
			c >>=1;
		}
		if((c1+c0==31)||(c1+c0==0)) {
			return -1;
		}
		int p=c1+c0;
		n |= (1<<p);
		n &= ~((1<<p)-1);
		n |= ((1<<(c1-1))-1);
		return n;
	}
	static void print0s1s(int n) {
		int c=n, zeroes=0, ones=0;
		while(c>0) {
			if((c&1)==1) {
				ones++;
			} else {
				zeroes++;
			}
			c >>= 1;
		}
		System.out.println("Number of 1s in "+n + " = " +ones);
		System.out.println("Number of 0s in "+n + " = " +zeroes);
	}
	static String sortChars(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
	static boolean searchInASortedArr(int[] a, int x, int low, int high) {
		if(low > high) {
			return false;
		}
		int mid = (low + high)/2;
		if(x>a[mid]) {
			return searchInASortedArr(a,x,mid+1,high);
		} else if(x < a[mid]) {
			return searchInASortedArr(a,x,low,mid-1);
		} else if(x == a[mid]){
			return true;
		}
		return false;
	}
	static boolean searchInSortedArray(int[] a, int x) {
		return searchInASortedArr(a,x,0,a.length-1);
	}
	static int fib(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		int a=0;
		int b=1;
		for(int i=2; i<n;i++) {
			int c = a+b;
			a = b;
			b = c;
			System.out.println("value of a is : "+a + " value of b is : "+b);
		}
		return a+b;
	}
	static int countWays(int n, int[] memo) {
		if(n<0) {
			return 0;
		} else if(n==0) {
			return 1;
		} else if(memo[n]>-1) {
			return memo[n];
		} else {
			memo[n] = countWays(n-1,memo) + countWays(n-2,memo) + countWays(n-3,memo);
			return memo[n];
		}
	}
	static int countWays(int n) {
		int[] memo = new int[n+1];
		for(int i=0; i<=n;i++) {
			memo[i]=-1;
		}
		return countWays(n,memo);
	}
	static int minProduct(int a, int b) {
		boolean bothNeg = false, oneNeg = false;
		if(a<0 && b<0) {
			bothNeg = true;
		} else if(a<0 || b<0) {
			oneNeg = true;
		}
		a = Math.abs(a);
		b = Math.abs(b);
		int smaller = a>b? b:a;
		int bigger = a<b?b:a;
		int res = minProductHelper(smaller,bigger);
		if(bothNeg) {
			return res;
		}
		if(oneNeg) {
			return res*(-1);
		}
		return res;
	}
	static int minProductHelper(int smaller, int bigger) {
		if(smaller==0) return 0;
		if(smaller==1) return bigger;
		int s = smaller >> 1;
		int halfProd = minProductHelper(s,bigger);
		if(smaller%2==0) {
			return 2*halfProd;
		} else {
			return 2*halfProd + bigger;
		}
	}
	static String insertCharAt(String s, char ch, int i) {
		String first = s.substring(0,i);
		String last = s.substring(i);
		return first+ch+last;
	}
	static ArrayList<String> getPerms(String str) {
		if(str == null) return null;
		ArrayList<String> list = new ArrayList<String>();
		if(str.length()==0) {
			list.add("");
			return list;
		}
		char first = str.charAt(0);
		String rem = str.substring(1);
		ArrayList<String> words = getPerms(rem);
		for(String word:words) {
			for(int j=0; j<=word.length(); j++) {
				String s = insertCharAt(word,first,j);
				list.add(s);
			}
		}
		return list;
	}
	static void generateParens(ArrayList<String> list, int lRem, int rRem, char[] str, int index) {
		if(lRem < 0 || rRem < lRem) {
			return;
		}
		if(lRem ==0 || rRem ==0) {
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '(';
			generateParens(list,lRem-1,rRem,str,index+1);

			str[index] = ')';
			generateParens(list,lRem,rRem-1,str,index+1);
		}
	}
	static ArrayList<String> generateParens(int count) {
		char[] str = new char[2*count];
		ArrayList<String> list = new ArrayList<String>();
		generateParens(list,count,count,str,0);
		return list;
	}
	static String testMySelf(String str) {
		if(str == null || str.isEmpty()) {
			return "";
		}
		String result = "";
		char last = str.charAt(0);
		int count = 1;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)==str.charAt(i-1)) {
				count++;
			} else {
				result += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		result += last + "" + count;
		return result.length() < str.length()? result : str;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(6);
		stack.push(1);
		stack.push(9);
		stack.push(5);
		stack.push(2);
		stack.push(10);
		stack.push(8);
		stack.push(3);
		stack.push(7);

		sortStackWithoutDS(stack);
		//System.out.println(flipNumBits(38,6));
		//print0s1s(1);
		HashMap<String,ArrayList<String>> hList = new HashMap<String,ArrayList<String>>();
		String[] test = {"test","estt","ven", "venu", "veun"};
		for(String s:test) {
			String key = sortChars(s);
			//System.out.println(key);
			if(!hList.containsKey(key)) {
				ArrayList<String> list = new ArrayList<String>();
				hList.put(key, list);
			}
			hList.get(key).add(s);
		}
		//System.out.println(hList.size());
		int[] ip = {1,2,3,4,5,6,7,9,12,15,16,19,20};
		//System.out.println(searchInSortedArray(ip,12));
		//System.out.println(countWays(4));
		//System.out.println(minProduct(-4,6));
/*		ArrayList<String> op = getPerms("VenuReddy");
		for(int i=0; i<op.size(); i++) {
			System.out.println(op.get(i));
		}
*/

/*		ArrayList<String> listOp = generateParens(3);
		for(int i=0; i< listOp.size(); i++) {
			System.out.println(listOp.get(i));
		}*/
		//System.out.println(testMySelf("aaaa"));
		System.out.println("Venu Reddy\\Venu");
		String str1 = "foo";
		String str_test = "";

		str1.concat("venu");
		StringBuilder sb = new StringBuilder("Java");
		sb.append("Coders");
		str1.concat("Java");
		String str2 = "foo";
		System.out.println(str1);
	}
}

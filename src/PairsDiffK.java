
public class PairsDiffK {

	static int countOfPairs(int[] ip, int k) {
		int count=0;
		for(int i=0; i< ip.length-1; i++) {
			for(int j=i+1; j<ip.length;j++) {
				if(Math.abs(ip[i]-ip[j]) == k) {
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] a = {8, 12, 16, 4, 0, 20};
		int k=4;
		System.out.println(countOfPairs(a,k));
	}
}

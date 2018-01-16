import java.util.HashMap;

class CountInd {
	int index, count;

	CountInd(int index) {
		this.index = index;
		this.count = 1;
	}

	void countInc() {
		this.count++;
	}
}

public class MinIndexRepElement {

	static int minRepIndex(int[] ip) {
		HashMap<Integer, CountInd> map = new HashMap<Integer, CountInd>();
		for (int i = 0; i < ip.length; i++) {
			if (!map.containsKey(ip[i])) {
				map.put(ip[i], new CountInd(i));
			} else {
				map.get(ip[i]).countInc();
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < ip.length; i++) {
			if (map.get(ip[i]).count > 1 && res > map.get(ip[i]).index) {
				res = map.get(ip[i]).index;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 1, 0, 3, 3, 5, 6, 2, 8, 9, 5 };
		System.out.println(minRepIndex(a));
	}
}

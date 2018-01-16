import java.util.HashMap;

class CountIndex {
	int count, index;
	CountIndex(int index) {
		this.count = 1;
		this.index = index;
	}
	void incCount() {
		this.count++;
	}
}

public class FirstNonRepCharHashMap {
	static char firstNonRepHash(String s) {
		HashMap<Character, CountIndex> map = new HashMap<Character, CountIndex>();
		int result = Integer.MAX_VALUE;
		for(int i=0; i<s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), new CountIndex(i));
			} else {
				map.get(s.charAt(i)).incCount();
			}
		}
		for(int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i) + " : count = " +map.get(s.charAt(i)).count + " index: "+map.get(s.charAt(i)).index);
			if((map.get(s.charAt(i)).count == 1) && result > map.get(s.charAt(i)).index) {
				return s.charAt(map.get(s.charAt(i)).index);
			}
		}
		return s.charAt(result);
	}
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(firstNonRepHash(str));
	}
}

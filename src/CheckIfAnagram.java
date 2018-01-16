import java.util.HashMap;

public class CheckIfAnagram {

	static boolean sortAndFindAnagrams(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] count = new int[256];
		int numChar = 0, totalMatched = 0;
		for(int i=0; i<s1.length();i++) {
			if(count[s1.charAt(i)]==0) numChar++;
			count[s1.charAt(i)]++;
		}
		int j;
		for(j=0; j<s2.length(); j++) {
			if(count[s2.charAt(j)] == 0) return false;
			count[s2.charAt(j)]--;
			if(count[s2.charAt(j)] == 0) totalMatched++;
			if(totalMatched == numChar) {
				return j == s2.length()-1;
			}
		}
		return true;
	}

	static boolean areAnagrams(String s1, String s2) {
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(int i=0; i<s1.length(); i++) {
			hmap.put(s1.charAt(i), hmap.getOrDefault(s1.charAt(i),0)+1);
		}
		for(int j=0; j < s2.length(); j++) {
			if(hmap.containsKey(s2.charAt(j))) {
				if(hmap.get(s2.charAt(j)) > 1) {
					int val = hmap.get(s2.charAt(j));
					hmap.put(s2.charAt(j), val-1);
				} else {
					hmap.remove(s2.charAt(j));
				}
			} else {
				return false;
			}
		}
		return (hmap.size() == 0);
	}
	public static void main(String[] args) {
		String str1 = "aabbbbsst";
		String str2 = "sbstbabba";
		System.out.println(areAnagrams(str1,str2));
		System.out.println(sortAndFindAnagrams(str1,str2));
	}
}

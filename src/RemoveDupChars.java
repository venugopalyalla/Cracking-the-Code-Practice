import java.util.LinkedHashSet;

public class RemoveDupChars {

	static void removeDupsWithoutOther(String s) {
		char[] ch = s.toCharArray();
		int res_index = 1;
		for (int i = 1; i < ch.length; i++) {
			int j;
			for (j = 0; j < res_index; j++) {
				if (ch[i] == ch[j]) {
					break;
				}
			}
			if (j == res_index) {
				ch[res_index++] = ch[i];
			}
		}
		String res = new String(ch);
		System.out.println(res.substring(0, res_index));
	}

	static void removeDupsLHS(String s) {
		LinkedHashSet<Character> hs = new LinkedHashSet<>();
		for (int i = 0; i < s.length(); i++) {
			hs.add(s.charAt(i));
		}
		for (Character ch : hs) {
			System.out.print(ch);
		}
	}

	static void removeDups(String s) {
		boolean[] visited = new boolean[256];
		char[] ch = s.toCharArray();
		visited[ch[0]] = true;
		int res_index = 1;
		for (int i = 0; i < ch.length; i++) {
			if (!visited[ch[i]]) {
				ch[res_index++] = ch[i];
				visited[ch[i]] = true;
			}
		}
		String res = new String(ch);
		System.out.println(res.substring(0, res_index));
	}

	public static void main(String[] args) {
		String s = "aaaabbbbccdbbbeeee444aaa";
		removeDups(s);
		//removeDupsLHS(s);
		removeDupsWithoutOther(s);
	}
}

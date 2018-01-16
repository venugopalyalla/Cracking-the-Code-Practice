class ResMM {
	int hits = 0;
	int pseudo_hits = 0;
	public String toString() {
		return hits + " hits and " + pseudo_hits + " pseudo hits.";
	}
}
public class MasterMind {

	public static final int MAX_CODES = 4;
	static int code(char c) {
		switch(c) {
		case('R'):
			return 0;
		case('G'):
			return 1;
		case('B'):
			return 2;
		case('Y'):
			return 3;
		default:
			return -1;
		}
	}
	static ResMM calcHitsAndPSHits(String sol, String guess) {
		if(sol.length() != guess.length()) return null;
		ResMM res = new ResMM();
		int[] freqs = new int[MAX_CODES];
		for(int i=0; i<sol.length(); i++) {
			if(guess.charAt(i) == sol.charAt(i)) {
				res.hits++;
			} else {
				int c = code(sol.charAt(i));
				freqs[c]++;
			}
		}
		for(int i=0; i<guess.length();i++) {
			int c = code(guess.charAt(i));
			if(c >=0 && freqs[c] > 0 && guess.charAt(i) != sol.charAt(i)) {
				res.pseudo_hits++;
				freqs[c]--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String solution = "GRGG";
		String guess = "GGRR";
		ResMM res = calcHitsAndPSHits(solution,guess);
		System.out.println(res.toString());
	}
}

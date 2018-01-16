import java.util.HashSet;

public class ShuffleCards {

	static int rand(int lower, int higher) {
		return lower + (int)(Math.random()*(higher-lower+1));
	}
	static int[] shuffleCardsIteratively(int[] a) {
		for(int i=0; i<a.length; i++) {
			int k = rand(0,i);
			int temp = a[k];
			a[k] = a[i];
			a[i] = temp;
		}
		return a;
	}
	public static void main(String[] args) {
		int[] cards = new int[52];
		for(int i=0; i<52; i++) {
			cards[i] = i+1;
		}
		cards = shuffleCardsIteratively(cards);
		for(int i=0; i<cards.length; i++) {
			//System.out.println(cards[i]);
		}
		HashSet set = new HashSet();
		for(int i=0; i<cards.length; i++) {
			set.add(cards[i]);
		}
		//System.out.println(set.size());
		System.out.println(Math.random());
	}
}

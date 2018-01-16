import java.util.Random;

public class Apocalypse {

	static int[] runFamilies() {
		Random random = new Random();
		int[] family = new int[2];
		int girls = 0;
		int boys = 0;
		while(girls == 0) {
			if(random.nextBoolean()) {
				girls++;
			} else {
				boys++;
			}
		}
		family[0] = girls;
		family[1] = boys;
		return family;
	}
	public static void main(String[] args) {
		int boys=0,girls=0;
		for(int i=0; i<99999; i++) {
			int[] fams = runFamilies();
			girls += fams[0];
			boys += fams[1];
		}
		int total = boys+girls;
		System.out.println(total);
		System.out.println((double)(girls*100/total));
	}
}

import java.util.Stack;

class Tower {
	int index;
	Stack<Integer> disks;
	Tower(int i) {
		index = i;
		disks = new Stack<Integer>();
	}
	public int index() {
		return index;
	}
	public void add(int d) {
		if(!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Cannot add");
		} else {
			disks.push(d);
		}
	}
	public void moveTopTo(Tower t) {
		if(!disks.isEmpty()) {
			int d = disks.pop();
			t.add(d);			
		}
	}
	public void moveDisks(int n, Tower d, Tower b) {
		if(n>0) {
			moveDisks(n-1,b,d);
			moveTopTo(d);
			b.moveDisks(n-1,d,this);
		}
	}
}
public class TowersOfHanoi {

	public static void main(String[] args) {
		int n=3;
		Tower[] towers = new Tower[n];
		for(int i=0; i<3; i++) {
			towers[i] = new Tower(i+1);
		}
		towers[0].moveDisks(n,towers[2],towers[1]);
		String s = "abcdef";
		System.out.println(s.substring(0,3));
	}
}

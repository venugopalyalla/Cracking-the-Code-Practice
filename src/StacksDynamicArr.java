class StackNd {
	int prev;
	int val;
	StackNd(int p, int v) {
		prev = p;
		val = v;
	}
}
class StackDynAr {
	int stackSize = 300;
	StackNd[] buffer = new StackNd[stackSize*3];
	int[] stackPointer = {-1,-1,-1};
	int indexUsed = 0;
	void push(int stackNum, int val) {
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]] = new StackNd(lastIndex,val);
	}
}
public class StacksDynamicArr {

	public static void main(String[] args) {
		
	}
}

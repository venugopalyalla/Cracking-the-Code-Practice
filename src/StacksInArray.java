class StacksArr {
	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = { 0, 0, 0 };

	void push(int stackNum, int value) {
		if (stackNum >= 3) {
			return;
		}
		if (stackPointer[stackNum] < stackSize) {
			int index = stackNum * stackSize + stackPointer[stackNum];
			stackPointer[stackNum]++;
			buffer[index] = value;
		} else {
			System.out.println("Stack is full!");
		}
	}

	int pop(int stackNum) {
		if(stackNum >= 3) {
			return 0;
		}
		if (stackPointer[stackNum] > 0) {
			int index = stackNum * stackSize + stackPointer[stackNum] - 1;
			stackPointer[stackNum]--;
			int value = buffer[index];
			buffer[index] = 0;
			return value;
		}
		return 0;
	}
	int peek(int stackNum) {
		return (buffer[(stackNum*stackSize)+(stackPointer[stackNum])-1]);
	}
}

public class StacksInArray {

	public static void main(String[] args) {
		StacksArr sa = new StacksArr();
		for (int i = 0; i < 26; i++) {
			//sa.push(2, i);
			sa.push(0, i);
			sa.push(1, i);
		}
		System.out.println(sa.pop(0));
		System.out.println(sa.pop(1));
		System.out.println(sa.pop(2));
		System.out.println(sa.peek(1));
	}
}

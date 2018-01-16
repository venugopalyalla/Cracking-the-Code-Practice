
public class CircularArray<T> {

	private T[] array;
	private int head=0;
	public CircularArray(int size) {
		array = (T[]) new Object[size];
	}
	private int convert(int index) {
		while(index < 0) {
			index += array.length;
		}
		return (head+index)%array.length;
	}
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	public T get(int i) {
		if(i<0 || i>array.length) {
			return null;
		}
		return array[convert(i)];
	}
	public void set(int i, T val) {
		array[convert(i)] = val;
	}
}

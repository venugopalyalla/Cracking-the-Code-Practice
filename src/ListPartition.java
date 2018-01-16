
public class ListPartition {

	static Node linkPartition(Node a, int x) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		while(a != null) {
			Node temp = a.next;
			a.next = null;
			if(a.data < x) {
				if(beforeStart == null) {
					beforeStart = a;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = a;
					beforeEnd = a;
				}
			} else {
				if(afterStart == null) {
					afterStart = a;
					afterEnd = afterStart;
				} else {
					afterEnd.next = a;
					afterEnd = a;
				}
			}
			a = temp;
		}
		if(beforeStart == null) {
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	public static void main(String[] args) {
		Node a = new Node(5);
		LinkedListImpl list = new LinkedListImpl();
		list.appendAtStart(1);
		list.append(8);
		list.append(4);
		list.append(1);
		list.append(9);
		list.append(6);
		list.append(3);
		list.append(7);
		list.append(5);
		list.append(1);
		Node res = linkPartition(list.head,6);
		while(res != null) {
			System.out.println(res.data);
			res = res.next;
		}
	}
}

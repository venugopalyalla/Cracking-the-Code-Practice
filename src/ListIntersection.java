class Result {
	int size;
	Node tail;
	Result(int size, Node tail) {
		this.size = size;
		this.tail = tail;
	}
}
public class ListIntersection {

	static Result getResult(Node a) {
		if(a==null) return null;
		int size = 1;
		while(a.next != null) {
			size++;
			a=a.next;
		}
		return new Result(size,a);
	}
	static Node shiftDiffNodes(Node node, int k) {
		while(k>0 && node != null) {
			node = node.next;
			k--;
		}
		return node;
	}
	static Node listIntersect(Node n1, Node n2) {
		if(n1==null || n2== null) return null;
		Result res1 = getResult(n1);
		Result res2 = getResult(n2);
		Node shorter = res1.size <res2.size? n1:n2;
		Node longer = res1.size <res2.size? n2:n1;
		int diff = Math.abs(res1.size-res2.size);
		longer = shiftDiffNodes(longer,diff);
		while(shorter.data != longer.data) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return shorter;
	}
	public static void main(String[] args) {
		LinkedListImpl list = new LinkedListImpl();
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);

		LinkedListImpl list2 = new LinkedListImpl();
		list2.append(8);
		list2.append(9);
		list2.append(10);
		list2.append(11);
		list2.append(12);
		list2.append(13);
		list2.append(5);
		list2.append(6);
		list2.append(7);

		Node res = listIntersect(list.head,list2.head);
		System.out.println(res.data);
	}
}

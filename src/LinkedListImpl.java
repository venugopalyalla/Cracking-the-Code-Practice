import java.util.Hashtable;
class PartialResult {
	Node result;
	int carry;
}
class Node {
	int data;
	Node next;

	Node(int i) {
		data = i;
		next = null;
	}
}

public class LinkedListImpl {
	Node head;

	void appendAtStart(int i) {
		Node node = new Node(i);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	void appendAtPos(int data, int pos) {
		if (pos <= 0) {
			System.out.println("Position should be a positive integer");
			return;
		}
		if (pos == 1) {
			appendAtStart(data);
			return;
		}
		Node node = new Node(data);
		Node n = head;
		Node prev = null;
		for (int i = 0; i < pos - 1; i++) {
			if (n != null) {
				prev = n;
				n = n.next;
			} else {
				System.out.println("Position " + pos + " does not exist in the list");
				return;
			}
		}
		prev.next = node;
		node.next = n;
	}

	void append(int i) {
		Node node = new Node(i);
		if (head == null) {
			head = node;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	void deleteHead() {
		Node n = head;
		if (n != null) {
			head = n.next;
		} else {
			System.out.println("The list is empty");
			return;
		}
	}

	void deleteLastNode() {
		Node n = head;
		Node prev = null;
		while (n.next != null) {
			prev = n;
			n = n.next;
		}
		prev.next = null;
	}

	void deleteAtPos(int pos) {
		Node n = head;
		Node prev = null;
		if (pos == 1) {
			deleteHead();
			return;
		}
		for (int i = 1; i < pos; i++) {
			prev = n;
			n = n.next;
		}
		prev.next = n.next;
	}

	void deleteDupsWithoutBuffer() {
		if(head==null) return;
		Node prev = head;
		Node curr = prev.next;
		while(curr != null) {
			Node runner = head;
			while(runner != curr) {
				if(runner.data == curr.data) {
					Node temp = curr.next;
					prev.next = temp;
					curr = temp;
					break;
				}
				runner = runner.next;
			}
			if(runner==curr) {
				prev = curr;
				curr = curr.next;
			}
		}
	}
	void deleteDups() {
		Hashtable table = new Hashtable();
		Node prev=null;
		Node n = head;
		while(n!=null) {
			if(table.containsKey(n.data)) {
				prev.next = n.next;
			} else {
				table.put(n.data, true);
				prev = n;
			}
			n = n.next;			
		}
	}

	boolean deleteThisNode(Node n) {
		if(n==null || n.next == null) {
			return false;
		}
		Node temp = n.next;
		n.data = temp.data;
		n.next = temp.next;
		return true;
	}
	Node nThFromLast(int n) {
		Node p1 = head;
		Node p2 = head;
		for(int i=0; i<n-1;i++) {
			if(p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	Node sumOfTwoLists(Node first, Node second) {
		Node res = null;
		Node prev = null;
		Node temp = null;
		int sum, carry=0;
		while(first != null || second != null) {
			sum = carry + (first != null? first.data : 0) + (second != null? second.data : 0);
			carry = (sum >= 10? 1 : 0);
			sum = sum%10;
			temp = new Node(sum);
			if(res == null) {
				res = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			if(first != null) {
				first = first.next;
			}
			if(second != null) {
				second = second.next;
			}
		}
		if(carry > 0) {
			temp.next = new Node(carry);
		}
		return res;
	}

	Node reverse(Node node) {
		Node prevNode = null;
		while(node != null) {
			Node temp = node;
			temp.next = prevNode;
			prevNode = temp;
			node = node.next;
		}
		return prevNode;
	}
	static boolean areEqual(Node n1, Node n2) {
		while(n1 != null && n2 != null) {
			if(n1.data != n2.data) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return (n1==null) && (n2==null);
	}
	static int getMiddle(Node a) {
		Node slow = a;
		Node fast = a.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	static int length(Node a) {
		Node slow = a;
		Node fast = a;
		int count = 0;
		while(fast!=null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
			count = count + 2;
		}
		if(fast != null) {
			count++;
		}
		return count;
	}
	static Node insertBefore(Node a, int val) {
		Node res = new Node(val);
		res.next = a;
		return res;
	}
	static Node padNode(Node a, int n) {
		for(int i=0; i<n; i++) {
			a = insertBefore(a,0);
		}
		return a;
	}
	static Node addList(Node n1, Node n2) {
		int len1 = length(n1);
		int len2 = length(n2);
		if(len1 < len2) {
			n1 = padNode(n1, len2-len1);
		}
		if(len2 < len1) {
			n2 = padNode(n2, len1-len2);
		}
		PartialResult result = addListFromStart(n1,n2);
		if(result.carry == 0) {
			return result.result;
		} else {
			Node carryNode = new Node(result.carry);
			Node op = insertBefore(result.result,result.carry);
			return op;
		}
	}
	static PartialResult addListFromStart(Node n1, Node n2) {
		if(n1 == null && n2 == null) {
			PartialResult result = new PartialResult();
			return result;
		}
		PartialResult result = addListFromStart(n1.next, n2.next);
		int value = result.carry + n1.data + n2.data;
		PartialResult fullResult = new PartialResult();
		fullResult.result = insertBefore(result.result, value%10);
		fullResult.carry = value/10;
		return fullResult;
	}
	public static void main(String[] args) {
		LinkedListImpl list = new LinkedListImpl();
		list.append(9);
		list.append(9);
		list.append(9);
		list.append(9);
		list.append(9);
		list.append(9);
		list.append(9);
		list.append(9);

		LinkedListImpl list2 = new LinkedListImpl();
		list2.append(9);
		list2.append(4);
		list.append(9);
		list.append(9);
		list.append(9);
		list.append(9);
		//Node rev = list.reverse(list.head);
/*		System.out.println("Middle is " + getMiddle(list.head));
		System.out.println("Length is " + length(list.head));
		//System.out.println(areEqual(list.head, rev));
		Node opNode = addList(list.head, list2.head);
		while(opNode != null) {
			System.out.println(opNode.data);
			opNode = opNode.next;
		}*/
	}
}

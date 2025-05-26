package SinglyLinkedList;

public class StackUsingLinkedList {
	private Node tail;
	private Node head;
	private int size;

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = tail.next;
		}
		
		System.out.println(this);
		size++;
	}

	public void pop() {
		if (isEmpty())
			throw new StackUnderflowException("Stack underflow");
		else {
			if(getSize()!=1)
			{
				Node temp = head;
				
				while (temp.next != tail) {
					temp = temp.next;
				}

				temp.next = null; // dereferencing last node
				tail = temp;
			}
			else
			{
				head = tail = null;
			}
		}
		System.out.println(this);

		size--;
	}
	
	@Override
	public String toString()
	{
		String s = "[";
		Node temp = head;
		while(temp!=null)
		{
			if(temp.next!=null)
				s = s + temp.data+" ,";
			else
				s = s + temp.data;
			
			temp = temp.next;
		}
		
		s = s + "]";
		
		return s;
	}

	public int peek() {
		if (isEmpty())
			throw new StackUnderflowException("Stack underflow");
		else
			return tail.data;
	}
}

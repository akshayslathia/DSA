package doublylinkedlist;

import java.util.Scanner;

public class DoublyLinkedList 
{
	private Node head;
	private Node tail;
	private int size;
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		if(isEmpty())
			head = tail = newNode;
		else 
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		
		size++;
		System.err.println(this);// to print
	}
	
	public void addFirst(int data) {
		

		Node newNode = new Node(data);
		if(isEmpty())
			head = tail = newNode;
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		
		size++;
		System.err.println(this);
	}
	
	public void addAtPos(int data,int index)
	{
		if(index>=getSize() || index<0)
			throw new IndexOutOfBoundsException("Invalid index");
		else if(index==0)
			addFirst(data);
		else
		{
			Node newNode = new Node(data);
			int count = 0;
			Node temp = head;
			while(count!=index-1)
			{
				count++;
				temp = temp.next;
			}
			
			temp.next.prev = newNode;
			newNode.next = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
			
			size++;
			System.err.println(this);
		}
		
		
		
	}
	
	public void removeFirst()
	{
		if(isEmpty())
			throw new LinkedListEmptyException("Linked list is empty");
		else if(getSize()==1)
			head = tail = null;
		else
		{
			Node temp = head.next;
			head.next.prev = null;
			head.next = null;
			head = temp;
		}
		
		size--;
		System.out.println(this);
	}
	
	
	
	public void removeAtPos(int index)
	{
		if(index<0 || index>=getSize())
			throw new IndexOutOfBoundsException("Invalid index");
		else if(index==0)
			removeFirst();
		else if(index==getSize()-1)
			removeLast();
		else
		{
			int count = 0;
			Node temp = head;
			while(count!=index)
			{
				count++;
				temp  = temp.next;
			}
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp.next = temp.prev = null;
			
			size--;
			System.out.println(this);
			
		}
		
	}
	
	public void clear()
	{
		head  = tail = null;
		System.out.println(this);
	}
	
	public void removeLast()
	{
		if(isEmpty())
			throw new LinkedListEmptyException("Linked list is empty");
		else if(getSize()==1)
			removeFirst();
		else
		{
			Node temp = tail.prev;
			tail.prev = null;
			temp.next = null;
			tail = temp;
			size--;
			System.out.println(this);
		}
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer("[");
		Node temp = head;
		while(temp!=null)
		{
			if(temp!=tail)
			{
				sb.append(temp.data);
				sb.append(" ,");
			}
			else 
			{
				sb.append(temp.data);
			}
			
			temp = temp.next;
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	public String displayReverse()
	{
		StringBuffer sb = new StringBuffer("[");
		Node temp = tail;
		while(temp!=null)
		{
			if(temp!=head)
			{
				sb.append(temp.data);
				sb.append(" ,");
			}
			else 
			{
				sb.append(temp.data);
			}
			
			temp = temp.prev;
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		DoublyLinkedList list = new DoublyLinkedList();
		while(true)
		{
			System.out.println("-----------------");
			System.out.println("1.Add Last\n2.Get Size\n3.Display\n4.Display Reverse\n5.addFirst\n6.Add At pos"
					+ "\n7.removeFirst\n8.removeLast\n9.removeFromPos\n10.clear");
			System.out.println("-----------------");
			int ch = sc.nextInt();
			if(ch==1)
			{
				System.out.print("Enter the data");
				list.addLast(sc.nextInt());
			}
			else if(ch==2)
				System.out.println(list.getSize());
			else if(ch==3)
				System.err.println(list);
			else if(ch==4)
				System.err.println(list.displayReverse());
			else if(ch==5)
			{
				System.out.print("Enter the data");
				list.addFirst(sc.nextInt());
			}
			else if(ch==6)
			{
				System.out.print("Enter data "); int data = sc.nextInt();
				System.out.print("Enter pos");int pos = sc.nextInt();
				list.addAtPos(data, pos);
			}
			else if(ch==7)
				list.removeFirst();
			else if(ch==8)
				list.removeLast();
			else if(ch==9)
			{
				System.out.print("Enter index :"); 
				list.removeAtPos(sc.nextInt());
			}
			else if(ch==10)
				list.clear();
		}
		
	}
	
	
	
}

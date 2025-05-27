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
			System.out.println("1.Add Last\n2.Get Size\n3.Display\n4.Display Reverse\n5.addFirst\n6.Add At pos");
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
		}
		
	}
	
	
	
}

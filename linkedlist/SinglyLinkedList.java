package SinglyLinkedList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SinglyLinkedList 
{
	private Node head;
	private Node tail;
	private int size;
	
	public int getSize() {
		return size;
	}

	public boolean isEmpty()
	{
		return (head==null);
	}
	
	public void addLast(int data)
	{
		Node newNode = new Node(data);
		if(isEmpty())
			head = tail = newNode;
		else 
		{
			tail.next = newNode;
			tail = newNode;
		}
		
		size++;
		System.err.println(this);
	}
	
	public void addFirst(int data)
	{
		Node newNode = new Node(data);
		if(isEmpty())
			head = tail = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
		
		size++;
		System.err.println(this);
	}
	
	public void addAtPos(int index,int data)
	{
		if(index<0 || index>=getSize())
			throw new IndexOutOfBoundsException();
		else 
		{
			if(index==0)
				addFirst(data);
			else if(index==getSize()-1)
				addLast(data);
			else
			{
				int count = 0;
				Node temp = head;
				while(count!=index-1)
				{
					temp = temp.next;
					count++;
				}
				
				Node newNode = new Node(data);
				newNode.next = temp.next;
				temp.next = newNode;
				size++;
				System.err.println(this);
			}
		}
		
		
	}
	
	public void removeLast()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		else if(getSize()==1)
			head = tail = null;
		else
		{
			Node temp = head;
			while(temp.next!=tail)
			{
				temp = temp.next; // moving the temp pointer at second last
			}
			
			temp.next = null ; // removing the last node
			tail = temp; // updating tail to loc temp
		}
		size--;// decrementing size
		System.err.println(this);
	}
	
	public void removeFirst()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		else if(getSize()==1)
			head = tail = null; // if list have only 1 node
		else
		{
			Node temp = head.next; // moving temp to head's next loc
			head.next = null; // making head's next null ( dereferencing)
			head = temp; // moving head to temp's loc
			
		}
		size--;
		System.err.println(this);
		
	}
	
	public void removeAtPos(int index)
	{
		if(isEmpty())
			throw new NoSuchElementException();
		else if(index==0)
			removeFirst();
		else if(index==getSize()-1)
			removeLast();
		else
		{
			int count = 0;
			Node temp = head;
			while(count!=index-1)
			{
				temp = temp.next;
				count++;
			}
			
			Node x = temp.next;
			temp.next = temp.next.next;
			x.next = null;
			size--;
			System.err.println(this);
		}
		
		
	}
	
	@Override
	public String toString()
	{
		String s = "[";
		Node temp = head;
		while(temp!=null)
		{
			if(temp!=tail)
				s = s + temp.data+" ,";
			else
				s = s + temp.data;
			
			temp = temp.next;
		}
		
		s = s +"]";
		
		return s;
	}
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		SinglyLinkedList list = new SinglyLinkedList();
		while(true)
		{
			System.out.println("-------------");
			System.out.println("1.isEmpty?\n2.addFirst\n3.addLast\n4.addAtPos\n5.display"
					+ "\n6.removeLast\n7.removeFirst\n8.removeAtPos");
			int ch = sc.nextInt();
			if(ch==1)
				System.out.println(list.isEmpty());
			else if(ch==2)
			{
				System.out.print("enter data :"); int data = sc.nextInt();
				list.addFirst(data);
			}
			else if(ch==3)
			{
				System.out.print("enter data :"); int data = sc.nextInt();
				list.addLast(data);
			}
			else if(ch==4)
			{
				System.out.print("enter data :"); int data = sc.nextInt();
				System.out.println("enter index :");int index = sc.nextInt();
				list.addAtPos(index, data);
			}
			else if(ch==5)
			{
				System.err.println(list);
			}
			else if(ch==6)
			{
				list.removeLast();
			}
			else if(ch==7)
			{
				list.removeFirst();
			}
			else if(ch==8)
			{
				System.out.print("Enter the index"); int index = sc.nextInt();
				list.removeAtPos(index);
			}
				
			System.out.println("-------------");
		}

	}

}

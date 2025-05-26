package SinglyLinkedList;

import java.util.Scanner;

public class StackUsingLinkedListMain {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		StackUsingLinkedList st = new StackUsingLinkedList();
		while(true)
		{
			System.out.println("-----------");
			System.out.println("1.Push\n2.Pop\n3.Peek\n4isEmpty\n5display");
			System.out.println("-----------");
			
			int ch = sc.nextInt();
			if(ch==1)
			{
				System.out.println("Enter the data");
				st.push(sc.nextInt());
			}
			else if(ch==2)
			{
				st.pop();
			}
			else if(ch==3)
			{
				System.out.println(st.peek());
			}
			else if(ch==4)
				System.out.println(st.isEmpty());
			else 
				System.out.println(st);
		}
	}

}

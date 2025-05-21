package Queue;

import java.util.Scanner;

import Stacks.StackOverflowException;
import Stacks.StackUnderflowException;

public class QueueDriver {

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		System.out.println("Enter the size of queue");
		Queue q = new Queue(sc.nextInt());
		while(flag)
		{
			System.out.println("-----------");
			System.out.println("1.Enqueue\n2.Dequeue\n3.Peek\n4.isEmpty?\n5.isFull?\n6.Display\n7.Exit");
			System.out.println("-----------");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1: System.out.print("Enter the data :"); int data = sc.nextInt();
						try
						{
							q.enqueue(data);
							System.err.println(q);
						}
						catch(QueueOverflowException e)
						{
							System.err.println(e.getMessage());
						}
						
						break;
						
				case 2 : try 
						{
							q.dequeue();
							System.err.println(q);
						}
						catch(QueueUnderflowException e)
						{
								System.err.println(e.getMessage());	
						}
				
						break;
						
				case 3 :  try 
						{
							System.out.println(q.peek());
						}
						catch(QueueUnderflowException e)
						{
								System.err.println(e.getMessage());	
						}
				
						break;
				
				case 4 : System.out.println(q.isEmpty() ? "Queue is empty" : "Queue is not empty");
						 break;
				
				case 5 : System.out.println(q.isFull() ? "Queue is full" : "Queue is not full");
				
						break;
						
				case 6 : System.err.println(q); break;
				
				case 7 : flag = false; break;
				
				default : System.err.println("Invalid option");
				
			
			}
		}

	}

}

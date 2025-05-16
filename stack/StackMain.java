package Stacks;

import java.util.Scanner;

public class StackMain 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the capacity of stack");
		Stack stack = new Stack(sc.nextInt());
		boolean flag = true;
		
		while(flag)
		{
			System.out.println("***Welcome to stacks*****");
			System.out.println("1.Push\n2.Pop\n3.Peek\n4.isEmpty?\n5.isFull?\n6.Display\n7.Exit");
			System.out.println("*********");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1: System.out.print("Enter the data :"); int data = sc.nextInt();
						try
						{
							stack.push(data);
							System.err.println(stack);
						}
						catch(StackOverflowException e)
						{
							System.err.println(e.getMessage());
						}
						
						break;
						
				case 2 : try 
						{
							stack.pop();
							System.err.println(stack);
						}
						catch(StackUnderflowException e)
						{
								System.err.println(e.getMessage());	
						}
				
						break;
						
				case 3 :  try 
						{
							System.out.println(stack.peek());
						}
						catch(StackUnderflowException e)
						{
								System.err.println(e.getMessage());	
						}
				
						break;
				
				case 4 : System.out.println(stack.isEmpty() ? "stack is empty" : "stack is not empty");
						 break;
				
				case 5 : System.out.println(stack.isFull() ? "stack is full" : "stack is not full");
				
						break;
						
				case 6 : System.err.println(stack); break;
				
				case 7 : flag = false; break;
				
				default : System.err.println("Invalid option");
				
			
			}
			
		}
		

	}

}

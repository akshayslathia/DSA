package Stacks;

public class Stack 
{
	int[] arr;
	int capacity;
	int top;
	
	Stack(int capacity)
	{
		arr = new int[capacity];
		this.capacity = capacity;
		top = -1;
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public boolean isFull()
	{
		return (top==capacity-1);
	}
	
	public void push(int data)
	{
		if(isFull())
			throw new StackOverflowException("stack overflow");
		else 
		{

			arr[++top] = data;
			System.out.println(data+" pushed into the stack");
		}
	}
	
	public void pop()
	{
		if(isEmpty())
			throw new StackUnderflowException("stack underflow");
		else 
		{
			int data = arr[top--];
			System.out.println(data+" removed from stack");
		}
	}
	
	public int peek()
	{
		if(isEmpty())
			throw new StackUnderflowException("stack underflow");
		else 
			return arr[top];
		
	}
	
	@Override
	public String toString()
	{
		String s = "[";
		for(int i=0;i<=top;i++)
		{
			if(i!=top)
				s = s + arr[i] +",";
			else
				s = s + arr[i] ;
		}
		
		s = s +"]";
		
		return s;
	}
}

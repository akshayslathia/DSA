package Queue;

public class Queue 
{
	int[] queue;
	int front,rear,capacity;
	
	Queue(int capacity)
	{
		this.capacity = capacity;
		queue = new int[capacity];
		front = rear  = -1;
	}
	
	public boolean isEmpty()
	{
		return (front==-1 || rear==-1);
	}
	
	public boolean isFull()
	{
		return (rear+1)%capacity == front;
	}
	
	public void enqueue(int data) throws QueueOverflowException
	{
		if(isFull())
			throw new QueueOverflowException("queue overflow");
		else
		{
			if(isEmpty())
				front = rear = 0;
			else 
				rear = (rear+1)%capacity;
			
			queue[rear] = data;
			System.out.println(data+" enqueued");
		}
	}
	
	public void dequeue() throws QueueUnderflowException
	{
		if(isEmpty())
			throw new QueueUnderflowException("Queue underflow");
		else
		{
			int data = queue[front];
			if(rear==front)
				rear = front = -1;
			else
				front = (front+1)%capacity;
			
			System.out.println(data+" dequeued");
			
		}
	}
	
	public int peek() throws QueueUnderflowException
	{
		if(isEmpty())
			throw new QueueUnderflowException("Queue underflow");
		else
			return queue[front];
	}

	@Override
	public String toString() {
		
		String s = "[";
		
		if(!isEmpty())
		{
			for(int i=front ;  ; i=(i+1)%capacity)
			{
				if(i!=rear)
					s = s + queue[i]+" , ";
				else
				{
					s = s + queue[i];
					break;
				}
			}
		}
		
		s = s + "]";
		
		return s;
	}
	
	
	
}

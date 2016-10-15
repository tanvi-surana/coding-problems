package queue;

public class StackQ {
//This has top() and pop() operations of the order O(n).
	QueueLL mainQueue;
	QueueLL backQueue;
	
	public StackQ()
	{
		mainQueue=new QueueLL();
		backQueue=new QueueLL();
	}
	int size()
	{
		return mainQueue.size();
	}
	
	boolean isEmpty()
	{
		if(size()==0)
		{
			return true;
		}
	  return false;	
	}
	
	void push(int new_data)
	{
		mainQueue.enqueue(new_data);
	}
	int pop()
	{
		if(isEmpty())
		{
			return -1;
		}
		while(mainQueue.size()!=1)
		{
			backQueue.enqueue(mainQueue.dequeue());	
		}
		//swap the two queues
		QueueLL temp=mainQueue;
		mainQueue=backQueue;
		mainQueue=temp;
		
		return backQueue.dequeue();
	}
	int top()
	{
		if(isEmpty())
		{
			return -1;
		}
		int topElement=mainQueue.dequeue();
		while(mainQueue.size()!=0)
		{
		//	int topElement=mainQueue.dequeue();
			backQueue.enqueue(topElement);	
		}
		//swap the two queues
		QueueLL temp=mainQueue;
		mainQueue=backQueue;
		mainQueue=temp;
		
		return topElement;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
}

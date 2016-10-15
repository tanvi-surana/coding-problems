package queue;

public class StackQEff {
	QueueLL mainQueue;
	QueueLL backQueue;
	
	public StackQEff()
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
	   backQueue.enqueue(new_data);
	   
	   while(mainQueue.size()!=0)
	   {	
		  backQueue.enqueue(mainQueue.dequeue());  
	   }
	    
	   QueueLL temp=mainQueue;
	   mainQueue=backQueue;
	   backQueue=temp;
	  System.out.println("Pushed"+new_data); 
	}
	int pop()
	{
		if(isEmpty())
		{
			return -1;
		}

	  return mainQueue.dequeue();	 
	}
	int top()
	{
		if(isEmpty())
		{
			return -1;
		}
	  int front=mainQueue.front();
	  return front;
	}
	public static void main(String[] args) {
	   // TODO Auto-generated method stub
		StackQEff s= new StackQEff();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		int x=s.pop();
		System.out.println(x);

	}

}

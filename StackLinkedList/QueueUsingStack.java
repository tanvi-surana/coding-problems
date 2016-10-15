package StackLinkedList;
//In this make dequeue efficient
public class QueueUsingStack {
    Stack mainStack;
    Stack backStack;
  public QueueUsingStack()
  {
	  mainStack=new Stack();
	  backStack=new Stack();
  }
    boolean isEmpty()
    {
    	if(mainStack.isEmpty())
    		return true;
    	return false;
    }
    void enqueue(int x)
    {
    	if(mainStack.isEmpty())
    	{
    		mainStack.push(x);
    	}
    	else
    	{
    		while(!mainStack.isEmpty())
    		{
    			int top=mainStack.pop();
    			backStack.push(top);
    		}
    		mainStack.push(x);
    		while(!backStack.isEmpty())
    		{
    			int topB=backStack.pop();
    			mainStack.push(topB);
    		}
    	}
    		
    }
    int dequeue()
    {
    	if(mainStack.isEmpty())
    	{
    		return -1;
    	}
    	int top=mainStack.pop();
    	return top;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStack s=new QueueUsingStack();
	    s.enqueue(1);
	    s.enqueue(2);
	    s.enqueue(3);
	    s.dequeue();

	}

}

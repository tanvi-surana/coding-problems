package StackLinkedList;

public class QueueUsingStackEn {

	Stack mainStack;
	Stack backStack;
	public QueueUsingStackEn() {
		// TODO Auto-generated constructor stub
		mainStack=new Stack();
		backStack=new Stack();
	}
	void enqueue(int x)
	{
		mainStack.push(x);
	}
	int dequeue()
	{
		int deElement;
		if(mainStack.isEmpty())
		{
			return -1;
		}
		else
		{
			while(mainStack.size()!=1)
		 {
			int x=mainStack.pop();
			 backStack.push(x);
	   	 }
		  deElement=mainStack.pop();
		 while(!backStack.isEmpty())
		 {
			int x=backStack.pop();
			mainStack.push(x);
		 }
		}
	return deElement;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
	}

}

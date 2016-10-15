package queue;

public class ReverseQueue {

	  public static void reverseRecursive(QueueLL q1,QueueLL q2)
	  {
		  //base case
		  if(q1.isEmpty())
		  {
			  return;
		  }
		  //get front element
		  int front=q1.dequeue();
		  
		  reverseRecursive(q1, q2);
		  
		  while(!q1.isEmpty())
		  {
			   q2.enqueue(q1.dequeue());
		  }
		  
		  q1.enqueue(front);
		  
		  while(!q2.isEmpty())
		  {
			  q1.enqueue(q2.dequeue());
		  }
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

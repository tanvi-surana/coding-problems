package QueueGeneric;


public class QueueLL<V> {
	
	node<V> head;
	node<V> tail;
	int count=0;
	public int size()
	{
		return count;
	}
	
	public boolean isEmpty()
	{
		if(head==null||tail==null)
		{
			return true;
		}
	  return false;	 
	}
	public void enqueue(V newData)
	{
		node<V> new_node=new node<V>();
		new_node.data=newData;
		if(head==null)
		{
			new_node.next=null;
			head=new_node;
			tail=new_node;
		}
		else
		{
			tail.next=new_node;
			tail = new_node;
			new_node.next=null;
		}
	//	System.out.println("enqueued "+newData);
		count++;
	}
	public V dequeue()
	{
		V front;
		if(isEmpty())
		{
			return null;
		}
	    front=head.data;
		head=head.next;
		count--;
	    if(count==0)
	    {
	    	tail=null;
	    }
	//	System.out.println("dequeued "+front);
		return front;
	}
	public V front()
	{
		V front=head.data;
		return front;
	}
	
/*	public void printQueue(Queue head)
	{
		boolean first=true;
		if(first==true)
		{
			System.out.println(head.data);
			first=false;
		}
		else
		{
			
			System.out.println("-->"+head.);		
		}
	}
*/
}

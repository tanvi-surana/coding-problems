package queue;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      QueueLL q= new QueueLL();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      System.out.println(q.front());     
      q.dequeue();	
      System.out.println(q.size());
	}

}

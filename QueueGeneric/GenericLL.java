package QueueGeneric;

import java.util.Scanner;

import Linked_List.node;

public class GenericLL {
	public static node takeInput()
	{
		Scanner console=new Scanner(System.in);
		 System.out.println("Enter the first element");
		 int nxtNodeData=console.nextInt();
		 node head=null;
		 node tail=null;
		 while(nxtNodeData!=-1)
		 {
			 node new_node=new node();
			 new_node.data=nxtNodeData;
			 new_node.next=null;
			 if(head==null)
			 {
				 head=new_node;
				 tail=new_node;
			 }
			 else
			 {
				 tail.next=new_node;
				 tail=new_node;
			 }
			 System.out.println("Enter the next element");
			 nxtNodeData=console.nextInt();
		 }		
		//	console.close();
			return head;
	}

	public static void printLinkedList(node head)
	{
		node temp=head;
		System.out.println("Printing");
		boolean first=true;
		while(temp!=null)
		{
			if(first)
			{
				System.out.print(temp.data);
				first=false;
			}
			else
			System.out.print("-->"+temp.data);
			temp=temp.next;
		}
		
		//findSum
	}
	
	public static node insert(node head,node toBeAdded,int position)
	{
		node temp=head;
		node head1=head;
	    int i=0;
	if(position==0)
	{
		toBeAdded.next=head1;
		head1=toBeAdded;
	}
	else
	{
		while(i!=position)
	    {
	    	temp=temp.next;
	    	i++;
	    }
	    toBeAdded.next=temp.next;
	    temp.next=toBeAdded;
	}
	return head1;
  }

	public static node delete(node head,int data)
	{
		if(head==null)
		{
			return null;
		}
		if(head.data==data)
		{
			return head.next;
		}
		node temp=head.next;
		node prev=head;
		while(temp !=null && temp.data!=data)
		{
			temp=temp.next;
			prev=prev.next;
		}
		if(temp==null)
		{
			return head;
		}

		prev.next=temp.next;
		return head;
   }
}
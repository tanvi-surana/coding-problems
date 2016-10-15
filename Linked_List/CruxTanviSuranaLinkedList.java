package Linked_List;

import java.util.Scanner;

public class CruxTanviSuranaLinkedList {
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
	

//wap to find 5th element from the end.
	public static void print5thFromEnd(node head)
	{
		node slower=head;
		node faster=head;
		for(int i=0;i<5;i++)
		{
			faster=faster.next;
		}
		while(faster.next!=null)
		{
			faster=faster.next;
			slower=faster.next;
		}
		System.out.println(slower.data);
	}
	
	//Reverse a linked list recurssively.
	public static void reverseRecursive(node head)
	{
	//	node current=head;
		if(head==null)
		{
			return;
		}
	    reverseRecursive(head.next);
	    System.out.print(head.data+" "); 
	}
	//Reverse a linked list iteratively
	
	public static node reverseIterative(node head)
	{
		if(head==null)
		{
			return head;
		}
		node current=head;
		node previous=null;
		node temp=null;
		while(current!=null)
		{
			 temp=current.next;
			current.next=previous;
			previous=current;
			current=temp;
		}
	return previous;	
    
	}
	//Eliminate duplicate data from a sorted linked list.
	public static node elminateDuplicates(node head)
	{
		node current=head;
		node next=head.next;
		while(next!=null)
		{
			if(current.data==next.data)
			{
				node temp=next.next;
				current.next=temp;
			}
			current=current.next;
			next=next.next;
		}
	return head;	
	}
	//Find mid point of a linked list;
	public static node findMidLinkList(node head)
	{
		node slow_ptr=head;
		node fast_ptr=head.next;
		while(fast_ptr!=null&&fast_ptr.next!=null)
		{
			slow_ptr=slow_ptr.next;
			fast_ptr=fast_ptr.next.next;
		}
		
	//	System.out.println("The mid element is "+slow_ptr.data);
	 return slow_ptr;
	}
	
	//merge two sorted linked list into one.
	public static node mergeSortedLinkList(node head,node head1)
	{
		node result=new node();
		if(head==null)
		{
			return head1;
		}
		if(head1==null)
		{
			return head;
		}
		node a=head;
		node b=head1;
		if(a.data>b.data)
		{
			result=b;
			result.next= mergeSortedLinkList(a, b.next);
		}
		if(a.data<b.data)
		{
			result=a;
			result.next= mergeSortedLinkList(a.next,b);
		}
	return result;	
	}
   
/*	public static void divideLLMergeSort(node head,node a,node b)
	{
		node slow_ptr=head;
		node fast_ptr=head;
		while(fast_ptr!=null&&fast_ptr.next!=null)
		{
			slow_ptr=slow_ptr.next;
			fast_ptr=fast_ptr.next.next;
		}
		a=head;
		b=slow_ptr;
		b.next=null;
		
	}
*/	
	
	public static node mergeSort(node head)
	{
		node c=head;
	     //
		if(c==null||c.next==null)
		{
			return c;
		}
	     c=findMidLinkList(head);
		node cNext=c.next;
		c.next=null;
		mergeSort(c);
		mergeSort(cNext);
		return mergeSortedLinkList(c,cNext);	
	}
	//Implement bubble sort on a linked list using recursion
	
	public static void bubbleSortRecurscive(node head)
	{
		
	}
	
	//Check if a linked list is a palindrome
	public static boolean checkIfPalindrome(node head)
	{
        boolean x;
		node reverse=head;
		node current=head;
		node new_list=reverseIterative(reverse);
		System.out.println("The reversed list is:");
		printLinkedList(new_list);
		while(current!=null&& new_list!=null)
		{
			 if(current.data!=new_list.data)
			 {
				 return false;
				 
			 }
			 else
			 {	 
			 current=current.next;
			 new_list=new_list.next; 
		
	         }
		}	 
		
		return true;
	}
	
	//Without using an additional linked list arrange all elements such that all even are placed after odd.
		
	public static node evenOddSequence(node head)
	{
		node head1=null;
		node head2=null;
		node headR=head;
		node headEven=null;
		node headOdd=null;
		while(headR!=null)
		{
			if(headR.data%2==0)
			{
				if(head1==null)
				{
					headEven=headR;
					head1=headR;
				}
				else 
				   head1.next=headR;
				   head1=headR;
			}
			
			else
			{
				if(head2==null)
				{
					head2=headR;
					headOdd=headR;
				}
				else
				head2.next=headR;
				head2=headR;
			}
			 headR=headR.next;
		}
		
		head2.next=headEven;
		head1.next=null;
		return headOdd;
	}
	public static node swapElements(node head, int first, int second)
	{
	   node previous1=head,previous2=head,current1=head,current2=head;
	  if(first==second)
	  {
		  return head;
	  }
	  
	   int i=0,j=0;
	   while(i!=first)
	   {
		   previous1=current1;
		   current1=current1.next;
		   i++;
	   }
	   while(j!=second)
	   {
		   previous2=current2;
		   current2=current2.next;
		   j++;
	   }
	   //Adjacent nodes inn a linked list.
	  /* if(first-second==1)
	   {
		   node temp1=current1;
		   node temp2=current2;
		   
	   }*/
	   //code to swap
	   
	   node temp=previous2.next;
	   previous2.next=current1.next;
	   current1.next=temp;
	   
	   previous1.next=previous2;
	   previous2.next=current1;
	   
		return head;
	}

	public static node appendElements(node head, int n){
	 	
		node slower=head;
		node faster=head;
		node temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}	
		for(int i=0;i<n;i++)
		{
			faster=faster.next;
			if(faster.next==null)
				return null;
		}
		
		while(faster.next!=null)
		{
			faster=faster.next;
			slower=faster.next;
		}
		 slower=slower.next; 
		 faster.next = head;                
         head = slower.next;
         slower.next = null;
   return head;
}
	
	 
	public static node kReverse(node head, int k)
	{
		node startS=head;
		node startK=head;
		node startFinal=head;
		node tailS=head;
		node tailK=head;
		int i=0,j=0;
		while(i!=2*k)
		{
			tailK=startFinal;
			startFinal=startFinal.next;
			i++;
		}
		while(j!=k)
		{
			tailS=startK;
			startK=startK.next;
			j++;
		}
		tailK.next=null;
		tailS.next=null;
		node list1=reverseIterative(startS);
		node list2=reverseIterative(startK);
		node list3=startFinal;
		//merge list1 and list2
    	node listIntermediate=list1;
    	node listIntermediateTail=list1;
    	while(listIntermediateTail.next!=null)
    	{
    		listIntermediateTail=listIntermediateTail.next;
    	}
    	listIntermediateTail.next=list2;
    	
    	while(listIntermediateTail.next!=null)
    	{
    		listIntermediateTail=listIntermediateTail.next;
    	}
    	listIntermediateTail.next=list3;
		return listIntermediate;
	}
	public static void main(String[] args)
	{
		node head=takeInput();
		printLinkedList(head);
	//	node head1=takeInput();
	//	printLinkedList(head);
	//	node t=new node();
	//	t.data=15;
	//	insert(head,t,1);
	//	reverseRecursive(head);
	//	reverseIterative(head);
	//	printLinkedList(head);
//      node a=findMidLinkList(head);
//      System.out.println();
//     System.out.println(a.data);
	//	elminateDuplicates(head);
    //  node head2=mergeSortedLinkList(head, head1);
     // mergeSort(head);	
	 //	printLinkedList(head);
	//boolean x=checkIfPalindrome(head);
	//System.out.println(x);
	//node node1=evenOddSequence(head);
	//printLinkedList(node1);
	//swapElements(head, 2, 5);
	//printLinkedList(head);
	//node x=appendElements(head, 2);
	//printLinkedList(head);
		node x=kReverse(head, 3);
     	printLinkedList(x);
//	node result=evenOddSequence(head);
//	printLinkedList(result);
	}
}

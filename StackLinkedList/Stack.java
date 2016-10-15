package StackLinkedList;

import Linked_List.node;

public class Stack {

	node head=null;
    int count=0;
	int size()
	{
		return count;
	}
	public boolean isEmpty()
	{
		if(head==null)
		{
			return true;
		}
	  return false;
	}
	
	public void push(int data)
	{
		node new_node=new node();
		new_node.data=data;
		if(head==null)
		{
			new_node.next=null;
			head=new_node;
		}
		else
		{
			new_node.next=head;
			head=new_node;
		}
		System.out.println(new_node.data);
		count++;
	}
	
	public int top()
	{
		if(head==null)
		{
			return -1;
		}
	  return head.data;
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			return -1;
		}
	   int x=head.data;
	   head=head.next;
	   count--;
	   System.out.println(x);
	   return x;
	}
}

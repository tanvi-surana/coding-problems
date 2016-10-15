package treesMw;

import java.util.ArrayList;
import java.util.Scanner;

public class Trees {

	public static Node<Integer> takeInput()
	{
		Scanner console=new Scanner(System.in);
		System.out.println("Enter the root data");
		int rootData=console.nextInt();
		
		 Node<Integer> root= new Node<Integer>();
		 root.data=rootData;
		//Create a queue and push the data into the queue. ;)
		 
		 GenericsQueues<Node<Integer>> inputQueue= new GenericsQueues<Node<Integer>>();
		 inputQueue.enqueue(root);
		 
		while(!inputQueue.isEmpty())
		{
			Node<Integer> currentNode=inputQueue.dequeue();
			System.out.println("Enter the number of children of"+currentNode.data);
		    int currentChildren=console.nextInt();
			
			for(int i=0;i<currentChildren;i++)
			{
				Node<Integer> newChild=new Node<Integer>();
				System.out.println("Enter next child for"+ currentNode.data);
				 int newChildData=console.nextInt();
				 newChild.data=newChildData;
				 
				 currentNode.children.add(newChild);
				 inputQueue.enqueue(newChild);
			}
		}
		return root;
	}
}

package trees;

import java.util.Scanner;

import StackLinkedList.Stack;


public class Tree {

	public static void printTree(Node<Integer> root) {
		if (root == null) {
			return;
		}
		
		String rootString = root.data + ":"; 
		
		for (int i = 0; i < root.children.size(); i++) {
			rootString += root.children.get(i).data + ", "; 
		}
		
		System.out.println(rootString);
		
		for (int i = 0; i < root.children.size(); i++) {
			printTree(root.children.get(i)); 
		}
	}
	
	public static Node<Integer> takeIntegerInput() {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter root");
		int rootData = console.nextInt();
		
		Node<Integer> root = new Node<Integer>();
		root.data = rootData;
		
		GenericsQueues<Node<Integer>> inputQueue = new GenericsQueues<Node<Integer>>();
		inputQueue.enqueue(root);
		
		while (!inputQueue.isEmpty()) {
			Node<Integer> currentNode = inputQueue.dequeue();
			System.out.println("Enter number of children for " + currentNode.data);
			int numChildren = console.nextInt();
			
			for (int i =0; i < numChildren; i++) {
				System.out.println("Enter next Child for " + currentNode.data);
				int nextChild = console.nextInt();
				Node<Integer> newNode = new Node<Integer>();
				newNode.data = nextChild;
				
				currentNode.children.add(newNode);
				inputQueue.enqueue(newNode);
			}
			
		}
		return root;
	}
	
	public static int height(Node<Integer> root) {
		if (root.children.size() == 0) {
			return 1;
		}
		int max = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int currentChildHeight = height(root.children.get(i)); 
			if (currentChildHeight > max) {
				max = currentChildHeight;
			}
		}
		//+1 as even a single node has a height 1
		return max + 1;
	}
	
	public static int maxNode(Node<Integer> root)
	{
		//base case
		if(root.children.size()==0)
		{
			return root.data;
		}
        //recursive calls
		int max=root.data;
		for (int i = 0; i < root.children.size(); i++) {
			int currentChildData = maxNode(root.children.get(i)); 
			if (currentChildData > max) {
				max = currentChildData;
			}
		}
		
	return max;	
	}
	
   public static int secMaxNode(Node<Integer> root)
   {
	   if(root==null)
		   return 0;
	   int max=maxNode(root);
	   int secMax=root.data;
	   
	    for(int i=0;i<root.children.size();i++)
	    { 
	    	int currentChildData=secMaxNode(root.children.get(i));
	    	if(currentChildData>secMax&&currentChildData!=max)
	    	{
	    		secMax=currentChildData;	
	    	}
	    	 	
	    }
	   return secMax;
	   
   }
		
	
	public static void printLevelKHelper(Node<Integer> root, int k){
		if(k==1){
			System.out.println(root.data);
		}
		
		for (int i = 0; i < root.children.size(); i++) {
		 printLevelKHelper(root.children.get(i),k-1);
		 }
	}
	 
 
	 
	public static int nodesGreaterThanNum(Node<Integer> root,int num)
	{
		int count=0;
		if(root.data>num)
		{
			count=1;
		}		 
		for (int i = 0; i < root.children.size(); i++) 
			{
				count+=nodesGreaterThanNum(root.children.get(i), num);
			}
		return count;
	}
	
	//find the node for which sum of the data of all children and the node itself is maximum
	public static Node<Integer> sumOfChildrenGreatest(Node<Integer> root)
	{
		Node<Integer> max_node=root;
		if(root.children.size()==0)
		{
			return root;
		}
		int max=root.data;
		 
		for(int i=0;i<root.children.size();i++)
		{
			max+=root.children.get(i).data;
		}
		Node<Integer> new_node;
		for(int i=0;i<root.children.size();i++)
		{ 
			new_node=sumOfChildrenGreatest(root.children.get(i));
		    int sum2=new_node.data; 
			for(int j=0;j<new_node.children.size();j++)
			{ 
			     sum2+=new_node.children.get(j).data;
			}
		    
			if(sum2>max)
			{
				max=sum2;
				max_node=new_node;
			}
		}	
	  return max_node;
	}
// 
//	public static Node<Integer> postOrderTraversal(Node<Integer> root)
//	{
//		if(root==null)
//		{
//			return null;
//		}
//
//		for(int i=0;i<root.children.size();i++)
//		{
//			Node<Integer> new_node= postOrderTraversal(root);
//			
//			for(int j=new_node.children.size();j>0 ;j--)
//			{
//				System.out.println(root.children.get(j).data);
//			}		
//		
//		}
//		 
//		
//	return root;	
//	}
	 
   public static void printPostOrder(Node<Integer> root)
   {
	   if(root==null)
	   {
		   return;
	   }
	   
	   for(int i=0;i<root.children.size();i++)
	   {
		   printPostOrder(root.children.get(i));
	   }
	   
	   for(int i=0;i<root.children.size();i++)
	   {
		   System.out.println(root.children.get(i).data);
	   }
	   

   }

	public static void levelOrderTraversal(Node<Integer> root)
	{
		int h=height(root);
		
		for(int i=0;i<=h;i++)
		{
			printLevelKHelper(root, i);
		}
	}
	
	public static void main(String args[]) {
		Node<Integer> root = takeIntegerInput();
		//printTree(root);
		//System.out.println(height(root));
         //  printLevelKHelper(root, 3); 	
		//System.out.println("maxValue "+maxNode(root));
		//System.out.println("Nodes greater than root are "+nodesGreaterThanNum(root,2));
		//Node<Integer> new_node=new Node<Integer>();
		//new_node=sumOfChildrenGreatest(root);
		//System.out.println("The node is"+new_node.data);
        //  levelOrderTraversal(root);
		printPostOrder(root);
		System.out.print("The value is" +secMaxNode(root));
	}
	
}

package trees;

import java.util.ArrayList;
import java.util.Scanner;


public class BinaryTree {

	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		
		String rootString = root.data + ":"; 
		
		if (root.left != null) {
			rootString += root.left.data + ", ";
		} else {
			rootString += "-1 , ";
		}
		
		
		if (root.right != null) {
			rootString += root.right.data + ", ";
		} else {
			rootString += "-1 , ";
		}
		
		System.out.println(rootString);
		
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeIntegerInput() {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter root");
		int rootData = console.nextInt();
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
		root.data = rootData;
		
		GenericsQueues<BinaryTreeNode<Integer>> inputQueue = new GenericsQueues<BinaryTreeNode<Integer>>();
		inputQueue.enqueue(root);
		
		while (!inputQueue.isEmpty()) {
			BinaryTreeNode<Integer> currentNode = inputQueue.dequeue();
			System.out.println("Enter left child for " + currentNode.data);
			int next = console.nextInt();
			if (next != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
				leftChild.data = next;
				currentNode.left = leftChild;
				inputQueue.enqueue(leftChild);
			}
			
			System.out.println("Enter right child for " + currentNode.data);
			next = console.nextInt();
			if (next != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
				rightChild.data = next;
				currentNode.right = rightChild;
				inputQueue.enqueue(rightChild);
			}
			
		}
		return root;
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		// diameter if root is included
		int diameter1 = height(root.left) + height(root.right);
		
		// left subtree diameter
		int diameter2 = diameter(root.left);
		
		// right subtree diameter
		int diameter3 = diameter(root.right);
		
		return Math.max(Math.max(diameter1, diameter2), diameter3);
	}
	
	public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root,int toBeFound)
	{
		//BinaryTreeNode<Integer> find_node; 		
		if(root==null)
		{
			return null;
		}	
		if(root.data==toBeFound)
		{
			return root;
		}
		BinaryTreeNode<Integer> leftResult= findNode(root.left, toBeFound);
		BinaryTreeNode<Integer> RightResult=findNode(root.right, toBeFound);
        if(leftResult!=null&&leftResult.data==toBeFound)
        {
        	return leftResult;
        }
	    if(RightResult!=null&&RightResult.data==toBeFound)
	    {
	    	return RightResult;
	    }
	return null;	 
		
	}
	
	public static BinaryTreeNode<Integer> mirrorBinaryTree(BinaryTreeNode<Integer> root)
	{
		 if(root==null)
			 return null;
		 else{
			 mirrorBinaryTree(root.left);
			 mirrorBinaryTree(root.right);
			 
			 BinaryTreeNode<Integer> temp= root.left;
			 root.left=root.right;
			 root.right=temp;
			 
		 }
		return root; 
	}
	
	public static BinaryTreeNode<Integer> formBinaryTreeHelper(int[] inorder,int[] postorder,int inStart,int inEnd,int postStart,int postEnd)
	 {
		    BinaryTreeNode<Integer> rootNode= new BinaryTreeNode<Integer>(); 
	         if(inStart>inEnd)
	         {
	        	 return null;
	         }
	         int root=postorder[postEnd];
	         int inRootIndex=-1;
	         //find the inorder rootIndex
	         for(int i=inStart;i<=inEnd;i++)
	         {
	        	 if(root==inorder[i])
	        	 {
	        		 inRootIndex=i;
	        	 }
	         }
	         int postOrderLength=inRootIndex-inStart;
	         BinaryTreeNode<Integer> leftNode=formBinaryTreeHelper(inorder, postorder, inStart,inRootIndex-1, postStart, postEnd-1);
	         BinaryTreeNode<Integer> rightNode=formBinaryTreeHelper(inorder, postorder,inRootIndex+1, inEnd, postStart, postEnd);
	         
	         rootNode.left=leftNode;
	         rootNode.right=rightNode;
	         return rootNode;
	 }
	
	public static BinaryTreeNode<Integer> formBinaryTree(int[] inorder,int[] postorder)
	{
		if(inorder.length!=postorder.length)
			return null;
		return formBinaryTreeHelper(inorder, postorder,0,inorder.length,0,postorder.length);
	}
   public static void inOrderTraversal(BinaryTreeNode<Integer> root)
  {
	 if(root==null)
	 {
		 return;
	 }
	 inOrderTraversal(root.left);
	 System.out.println(root.data);
	 inOrderTraversal(root.right);
  }
	

   
   public static int findSumTree(BinaryTreeNode<Integer> root)
   {
	    if(root==null)
	    	return 0;
	     
	   return root.data+findSumTree(root.right)+findSumTree(root.left);
   }
   
//   Given a Binary tree check if it is balanced i.e. depth of the left and right subtrees of every
//   node differ by 1 or less.
   
   public static boolean checkIfBalanced(BinaryTreeNode<Integer> root)
   {
	   if(root==null)
		   return true;
	   int heightLeft=height(root.left);
	   int heightRight=height(root.right);
	    
	   if(heightLeft-heightRight!=1&&heightLeft-heightRight!=-1&&heightLeft-heightRight!=0)
	    {
		   return false;  
	    }
	   return true;   
   }
//   Given two binary trees, return true if they are structurally identical they are made of
//   nodes with the same values arranged in the same way.   

   public static boolean checkIfIdentical(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2)
   {
	   if(root1==null&&root2==null)
		   return true;
	   if(root1==null||root2==null)
	        return false;
	   return (root1.data==root2.data)&&checkIfIdentical(root1.left, root2.left)&&checkIfIdentical(root1.right, root2.right);
	     
   }
   public static void printKLevel(BinaryTreeNode<Integer> root,int k)
   {
	   if(root==null)
		   return;
	   if(k==1)
	   {
		   System.out.print(root.data+" ");
	   }
	   
		   printKLevel(root.left, k-1);
		   printKLevel(root.right, k-1);
	   
   }
   
   public static void printKLevelRtoL(BinaryTreeNode<Integer> root,int k)
   {
	   if(root==null)
		   return;
	   if(k==1)
	   {
		   System.out.print(root.data+" ");
	   }
	   
	       printKLevel(root.right, k-1);
		   printKLevel(root.left, k-1);
   }  
   public static void levelOrderTraversal(BinaryTreeNode<Integer> root)
   {
	  if(root==null)
		  return;
	   for(int i=0;i<=height(root);i++)
	   {
		   printKLevel(root, i);
		   System.out.println();
	   }
	  
   }
   
//   Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from
//   right to left and so on. This means odd levels should get printed from left to right and even
//   levels should be printed from right to left. Each level should be printed at a new line.
   public static void printZigZag(BinaryTreeNode<Integer> root)
   {
	   if(root==null)
		   return;
	   for(int i=0;i<=height(root);i++)
	   {
		   if(i%2!=0)
			   printKLevel(root, i);
		   else
			   printKLevelRtoL(root, i);
		   System.out.println();
			   
	   }
   }
   
   public static void prettyPrintTree(BinaryTreeNode<Integer> root)
   {
	  if(root==null)
		  return;
	  for(int i=0;i<height(root);i++)
	  {
		  prettyPrintTree(root.left);		  
	  }
   }
//   Given a binary tree and a number n. Find next larger element in a Binary Tree i.e find a
//   node with value just greater than n.
  /* public static BinaryTreeNode<Integer> nextGreaterElement(BinaryTreeNode<Integer> root,int k)
 //use a stack 
   {
	   if(root==null)
		   return null;
	   int max1,max2;
	   BinaryTreeNode<Integer> rightData;
	   BinaryTreeNode<Integer> leftData=nextGreaterElement(root.left, k);
	   if(nextGreaterElement(root.right, k).data>k)
	   {
		   rightData=root.right;
		   max1=root.right.data;
	   }
	   if(nextGreaterElement(root.left,k).data> k)
	   {
		   leftData=root.left;  
		   max2=root.left.data;
	   } 
	   
	     
   }*/
   
 //find the lowest common ancestor, given two nodes
   
   public BinaryTreeNode<Integer> lowestCommonAncestor(
		   BinaryTreeNode<Integer> root,
		   BinaryTreeNode<Integer> node1,
		   BinaryTreeNode<Integer> node2)
   {
       ArrayList<BinaryTreeNode<Integer>> list1 = null;
       ArrayList<BinaryTreeNode<Integer>> list2 = null;
	   if(!findAncestors(root,list1,node1)||!findAncestors(root,list2,node2))
		   return null;
	   for(int i=0;i<list1.size()&&i<list2.size();i++)
	   {
		   if(list1.get(i)!=list2.get(i))
			   break;
		    return list1.get(i-1);
	   }
	   return null;
   }
   
   public static boolean findAncestors(BinaryTreeNode<Integer> root,ArrayList<BinaryTreeNode<Integer>> list,
		   BinaryTreeNode<Integer> toBeFound){
	   
	   if(root==null)
		   return false;
	   
//	   ArrayList<BinaryTreeNode<Integer>> list=new ArrayList<BinaryTreeNode<Integer>>();
	   list.add(toBeFound);
	   
	   if(root.data==toBeFound.data)
		   return true;
	   
	   if(findAncestors(root.left,list, toBeFound)||findAncestors(root.right, list, toBeFound))
	   {
		  list.add(root);
		  return true; 
	   }
 
	   return false;	   
   }
   
//   public static ArrayList<BinaryTreeNode<Integer>> findAncestors(BinaryTreeNode<Integer> root,
//		   BinaryTreeNode<Integer> toBeFound)
//   {
//	   if(root==null)
//	   {
//		   return null;
//	   }
//	   
//	   ArrayList<BinaryTreeNode<Integer>> listOfAncestors = new ArrayList<BinaryTreeNode<Integer>>();
//	   
//          
//	   
//	   if(root==toBeFound)
//	   {
//		   listOfAncestors.add(root);
//		   return listOfAncestors;
//	   }
//	   
//	   if(findAncestors(root.left, toBeFound)!=null&& root==toBeFound)
//	   {
//		   listOfAncestors.add(root);
//		   return listOfAncestors;
//		   
//	   }
//	   if(findAncestors(root.right, toBeFound)!=null&& root==toBeFound)
//	   {
//		   listOfAncestors.add(root);
//		   return listOfAncestors;
//		   
//	   }
//	  return listOfAncestors; 
//   }
   
//   public static ArrayList<BinaryTreeNode<Integer>> findCommonAncestors(
//		   ArrayList<BinaryTreeNode<Integer>> list1,
//		   ArrayList<BinaryTreeNode<Integer>> list2)
// {
//
////	   ArrayList<BinaryTreeNode<Integer>> newList=new ArrayList<BinaryTreeNode<Integer>>();
//	   HashMap<BinaryTreeNode<Integer>,Boolean> newList=new HashMap<BinaryTreeNode<Integer>, Boolean>();
//	   for(int i=0;i<list1.size();i++)
//	   {
//		   newList.put(list1.get(i),true);
//        
//	   }
//	   for(int i=0;i<list1.size();i++)
//	   {
//		 if(newList.containsKey(list2.get(i)))
//		   newList.put(list2.get(i),true);    
//	   }
//	            
//	  Set<BinaryTreeNode<Integer>> finalList= newList.keySet();
//	  ArrayList<BinaryTreeNode<Integer>> output = new ArrayList<BinaryTreeNode<Integer>>();
//	  for (BinaryTreeNode<Integer> node: finalList) {
//		   output.add(node);
//	  }
//	  return output ;
// }
   public static void createLevelLinkedList(BinaryTreeNode<Integer> root)
   {
	   
   }
   
   public static BinaryTreeNode<Integer> createBinaryTreeSortedArray(int input[],int startIndex,int endIndex)
   {
	   if(startIndex>endIndex)
		   return null;
	   BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>();
	   int mid=(endIndex+startIndex)/2;
	   root.data=input[mid];
	   root.left=createBinaryTreeSortedArray(input,startIndex,mid-1);
	   root.right=createBinaryTreeSortedArray(input,mid+1,endIndex);
	   
	  return root; 
   }
   
  public static BinaryTreeNode<Integer> deleteLeaves(BinaryTreeNode<Integer> root)
  {
//	  if(root==null)
//		  return null;
	  if(root.right==null&&root.left==null)
	  {
		  root=null;
	  }
	  if(root.left!=null)
	  {  
		  deleteLeaves(root.left);
	  
	  }
	  if(root.right!=null)
	  { 
		  deleteLeaves(root.right);
	  }
	   
	 return root; 
  }

  public static int binaryTreeHeight(BinaryTreeNode<Integer> root)
  {
	  if(root==null)
		  return 0;
	  
	  return 1+Math.max(binaryTreeHeight(root.left), binaryTreeHeight(root.right));
  }
  
  public static int numberOfLeaves(BinaryTreeNode<Integer> root)
  {
	  if(root==null)
		  return 0;
	  if(root.left==null&&root.right==null)
		  return 1;
	  return numberOfLeaves(root.left)+numberOfLeaves(root.right);
  }
  public static void doubleTree(BinaryTreeNode<Integer> root)
  {
	 BinaryTreeNode<Integer> oldLeft;
	  if(root==null)
		  return;
	  doubleTree(root.left);
	  doubleTree(root.right);
	  
	//  BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>();
	  if(root.left.left!=null)
	  {	  
	   oldLeft=root.left;
	   root.left=newNode(root.left);
	   root.left.left=oldLeft;
	  }
  }
  public static BinaryTreeNode<Integer> newNode(BinaryTreeNode<Integer> root)
  {
	  BinaryTreeNode<Integer> newNode=new BinaryTreeNode<Integer>();
	  newNode=root;
	  newNode.left=null;
	  newNode.right=null;
			 
	return newNode;		  
  }
  
  public static void printNodeWithoutSibling(BinaryTreeNode<Integer> root)
  {
	  if(root==null)
		  return;
	  if(root.right==null&&root.left==null)
		  System.out.println(root.data);
	  printNodeWithoutSibling(root.left);
	  printNodeWithoutSibling(root.right);
	  
  }
 
  //Given a binary search tree and an integer value, print all the ancestors of the node with
  // the integer value.
  public static boolean printAncestors(BinaryTreeNode<Integer> root,int k)
  {
    // ArrayList<BinaryTreeNode<Integer>> list=new ArrayList<BinaryTreeNode<Integer>>();
	  if(root==null)
	  {
		   return false;
	  }
	  if(root.data==k)
	  {
		  return true;
	  }
	  if(printAncestors(root.left, k)||printAncestors(root.right, k))
	  {
	            System.out.println(root.data);
	            return true;
	  }  
	  
	  return false;
  }
  
  //Date--03/11/2014
  public static BinaryTreeNode<Integer> removeLeaves2(BinaryTreeNode<Integer> root)
  {
		 if(root.right==null&&root.left==null)
	  
	  {
		  root=null;
		  return null;
	  }
	  else 
	  { 
		 root.right= removeLeaves2(root.right);
		 root.left= removeLeaves2(root.left);
	  }
	  
	  return root;
  }
  
  public static boolean checkChildrenSumProp(BinaryTreeNode<Integer> root)
  {
	  int rootRight=0,rootLeft=0;
	  if(root==null)
		  return true;
	  if(root.left!=null)
		  rootLeft=root.left.data;
	  if(root.right.data!=null)
		  rootRight=root.right.data;
	  if(root.data==rootLeft+rootRight&&checkChildrenSumProp(root.right)&&checkChildrenSumProp(root.left))
           return true; 
	  return false;
  }
  
  public static BinaryTreeNode<Integer> findSecondLargest(BinaryTreeNode<Integer> root)
  { 
	  int largest=0;
	  int secondL=0;
	  if(root==null)
		  return null;
	  
	  return null;
  }
  public static BinaryTreeNode<Integer> mirrorBinaryTree1(BinaryTreeNode<Integer> root)
	{
		 if(root==null)
			 return null;
		 else{
 			 mirrorBinaryTree(root.right);
 			 BinaryTreeNode<Integer> temp= root.left;
			 root.left=root.right;
			 root.right=temp;
 			 mirrorBinaryTree(root.left);

			 
		 }
		return root; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Scanner console=new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeIntegerInput();
		//BinaryTreeNode<Integer> root1 = takeIntegerInput();
		printTree(root);
		//System.out.println("diameter: " + diameter(root));
		//BinaryTreeNode<Integer> node = mirrorBinaryTree(root);
		//printTree(node);
		//System.out.println("findNode"+node);
		//System.out.println("The sum is"+findSumTree(root));
		//System.out.println("Balanced tree "+checkIfBalanced(root));
		//System.out.println("The trees are identical "+checkIfIdentical(root, root1));
		//levelOrderTraversal(root);
		// printKLevel(root, 3);
		// System.out.println();
		//levelOrderTraversal(root);
		//printKLevelRtoL(root,3);
		//printZigZag(root);
//		System.out.println("Enter the number of elements");
//		int n=console.nextInt();
//		int input[]=new int[n];
//	    System.out.println("Enter the array");
//		for(int i=0;i<input.length;i++)
//		{
//			input[i]=console.nextInt();
//		}
//		BinaryTreeNode<Integer> node=createBinaryTreeSortedArray(input,0,input.length-1);
//		printTree(node);
//		printTree(root);
//		doubleTree(root);
//		printTree(root);
//		ving (root);
//	 printAncestors(root,8);
//		removeLeaves2(root);
//		System.out.println("After removing the leaves");
//		printTree(root);
//		BinaryTreeNode<Integer> node=findSecondLargest(root);
//		System.out.println("Second"+node.data);
		//System.out.println("Check "+checkChildrenSumProp(root));
		mirrorBinaryTree1(root);
		printTree(root);
	}
}

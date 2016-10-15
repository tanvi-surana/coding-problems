package StackLinkedList;

public class ReverseStackRecursive {
	  
     
	 public static void recursiveReverse(Stack s1,Stack s2)
	 {
		 //base case
		 if(s1.size()==0)
		 {
			 return;
		 }
		 //get top element
		 int top=s1.pop();
		 //recursive call
		 recursiveReverse(s1, s2);
		 //induction step

		 while(!s1.isEmpty())
		 {
	     	 s2.push(s1.pop());
		 }
	     
	    s1.push(top);
		 
	    while(!s2.isEmpty())
		 {
	     	 s1.push(s2.pop());
		 }
	 }
	 public static void main(String args[])
	 {
		 Stack s1=new Stack();
		 Stack s2=new Stack();
		 s1.push(1);
		 s1.push(2);
		 s1.push(3);
		 recursiveReverse(s1, s2);
		 
	 }

}

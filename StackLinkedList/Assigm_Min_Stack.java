package StackLinkedList;

public class Assigm_Min_Stack {

	Stack mainStack;
	Stack auxStack;
	public Assigm_Min_Stack()
	{
		mainStack=new Stack();
		auxStack=new Stack();
		
	}
	void push(int x)
	{
		if(mainStack.isEmpty())
		{
			mainStack.push(x);
			auxStack.push(x);
		}
		else
		{
			mainStack.push(x);
		int y=auxStack.pop();
		if(x>y)
			auxStack.push(y);
		else
			auxStack.push(x);
		}
	}
	int pop()
	{
		int x=mainStack.pop();
		auxStack.pop();
		return x;
	}
	int getMinimum()
	{
		int x=auxStack.pop();
		auxStack.push(x);
        return x; 	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Assigm_Min_Stack s=new Assigm_Min_Stack();
     s.push(5);
     s.push(2);
     s.push(3);
     int min=s.getMinimum();
     System.out.println("The minimum element is"+min);
	}

}

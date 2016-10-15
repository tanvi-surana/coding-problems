package Stack;

import java.util.ArrayList;

public class Stack {
   //access methods
	
    ArrayList<Integer> data;
    public Stack()
    {
    	data = new ArrayList<Integer>(); 	
    }
 
	int size()
	{
		return data.size();
	}
	
	boolean isEmpty()
	{
		if(size()==0)
		return true;
	  return false;
	}
	public void push(int nextElement)
	{
		data.add(nextElement);
	}
	
	public int top() throws StackEmptyException
	{
		if(isEmpty())
		{
			StackEmptyException e= new StackEmptyException();
			throw e;
			//return -1;
		}
		int top=data.get(data.size()-1);
		data.remove(data.size()-1);
		return top;
	}
}

#include<iostream>
#include<stack>
using namespace std;
//Complexity enQueue O(1),deQueue O(N),front O(N)
class Queue
{
  stack<int> s1;
  stack<int> s2;  
  public:
	 void enQueue(int data);
	 void deQueue();
     void front(); 
	
};

void Queue::enQueue(int data)
{
	s1.push(data);
}
void Queue::deQueue()
{
	if(s1.empty()&& s2.empty())
	{
		cout<<"Queue is empty(Both the stacks are empty)"<<endl;
        return;
	}
	else if(!s2.empty())
	{
         cout<<"On deQueue the element is"<<s2.top()<<endl;
         s2.pop();  
	} 
	else if(s2.empty())
	{
		while(!s1.empty())
		{
			s2.push(s1.top());
			s1.pop();
		}
		cout<<"On deQueue the element is"<<s2.top()<<endl;
         s2.pop();  
	}
}
void Queue::front()
{
   if(s1.empty()&& s2.empty())
	{
		cout<<"Queue is empty(Both the stacks are empty)"<<endl;
        return;
	}
	else if(!s2.empty())
	{
         cout<<"The front element is"<<s2.top()<<endl;
         //s2.pop();  
	} 
	else if(s2.empty())
	{
		while(!s1.empty())
		{
			s2.push(s1.top());
			//s1.pop();
		}
		cout<<"The front element is"<<s2.top()<<endl;
         
	}	
}
int main()
{
	Queue Q;
	Q.enQueue(1);
	Q.enQueue(2);
	Q.deQueue();
	Q.enQueue(3);
	Q.enQueue(4);
	Q.deQueue();
	Q.deQueue();

}
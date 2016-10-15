package Stack;

public class stack_queue_assignment {
   
   //Array implementation
	public static void stock_span_array(int input[],int n,int S[])
	{
		S[0]=1;
		for(int i=1;i<n;i++)
		{
			for(int j=i-1;j>0&&(input[i])>=input[j];j--)
			{
				S[i]++;
			}
		}
	}
	//Stack Implementation
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

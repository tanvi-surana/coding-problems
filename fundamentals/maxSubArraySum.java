package fundamentals;

public class maxSubArraySum {
	
	public static int maxSum1(int[] input)
	{
		int maxSum=0,sum=0;
		for(int i=0;i<input.length;i++)
		{
			if(sum > 0)
				sum+=input[i];
			else
				sum = input[i];
			
			if(sum>maxSum)
			{	
				maxSum=sum;
			}
		}
		return maxSum;
	}
	
 public static void main(String args[])
 {
	 int[] input={0,1,-2,-3,5,8};
	 System.out.println(maxSum1(input));
 }

}

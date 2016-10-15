package fundamentals;
//26/10/14
//Mixed problems slide 19
public class maxSumWalk {

	public static int intersectionPoints(int[] input1,int[] input2)
	{
		int i=0,j=0;
		int sum1=0,sum2=0,sum=0,start1=0,start2=0;
		while(i<=input1.length&&j<=input2.length)
		{
			if(input1[i]<input2[j])
				{
				    i++;
				}
		    if(input1[i]>input2[j])
			 {
				j++;
			 }	
			 if(input1[i]==input2[j])
			{

				for(int m=start1;m<i;m++)
				{
				    sum1+=input1[m];	
				}
				for(int m=start2;m<j;j++)
				{
					sum2+=input2[m];
				}
				
				if(sum1<sum2)
					sum+=sum2;
					else{
						sum+=sum1;
					}	
				i++;
				j++;
				start1=i+1;
				start2=j+1;
			}
			if(i>input1.length||j>input2.length)
				break;
			 
		}
		return sum;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] input1={2,4,6,8,10,12,13,16};
     int[] input2={1,4,7,8,11,13,19,20};
    System.out.println(intersectionPoints(input1, input2));  
	}

}

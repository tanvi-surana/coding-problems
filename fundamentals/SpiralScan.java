package fundamentals;

import java.util.Scanner;

public class SpiralScan {
	 
	 public static void main(int input[][])
	 {
		 
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner console =new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int numRows=console.nextInt();
		System.out.println("Enter the number of columns");
		int numColumns=console.nextInt();
		int input[][]=new int[numRows][numColumns];
		for(int i=0;i<numRows;i++)
		{
			for(int j=0;j<numColumns;j++)
			{
				input[i][j]=console.nextInt();
			}
		}
	}

}

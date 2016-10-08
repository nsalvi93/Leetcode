/*
 * Program that was asked in Google interview. But there is a better version of it in 
 * Google questions project folder. 
 * 
 * */

public class IntegerManipulation 
{
	public static void main(String args[])
	{
		int number = 3412;
		
		String numberString = String.valueOf(number);
		
		int leastNumber = Integer.MAX_VALUE;
		
		for(int i=0; i< numberString.length()-1; i++)
		{
			StringBuilder sb = new StringBuilder();
			int j;
			for( j=0; j<i; j++)
			{
				sb.append(numberString.charAt(j));
				System.out.println("First for "+ sb.toString());
			}
			if(Integer.parseInt(String.valueOf(numberString.charAt(i))) > Integer.parseInt(String.valueOf(numberString.charAt(i+1))))
			{
				sb.append(numberString.charAt(i));
				j=i+1;
				System.out.println("if "+ sb.toString());
			}
			else
			{
				sb.append(numberString.charAt(i+1));
				j=i+1;
				System.out.println("else "+ sb.toString());
			}
			for(j=j+1; j< numberString.length(); j++ )
			{
				//System.out.println("value of j "+ j);
				sb.append(numberString.charAt(j));
				System.out.println("Second for "+ sb.toString());
			}
			
			if(Integer.parseInt(sb.toString()) < leastNumber)
			{
				leastNumber = Integer.parseInt(sb.toString());
				System.out.println("comparison "+ sb.toString());
				
			}
		}
		System.out.println(leastNumber);
	}
}

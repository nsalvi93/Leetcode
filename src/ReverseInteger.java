/*Reversing an integer while taking care of overflow
 * condition
 * 
 * */
public class ReverseInteger 
{
	public static void main(String args[])
	{
		ReverseInteger object = new ReverseInteger();
		object.reverseInt(-123);
	}
	public void reverseInt(int n)
	{
		int number =0;
		boolean isNegative = n<0 ? true : false;
		n = Math.abs(n);
		while(n!=0)
		{
			if (number > ((Integer.MAX_VALUE - (n%10)) / 10)){System.out.println(0); return;}
			number = number * 10 + (n%10);
			n = n/10;
		}
		if(isNegative){System.out.println(-number);}
		else{System.out.println(number);}	
		

	}
}

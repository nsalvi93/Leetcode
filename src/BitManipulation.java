/*Contains many methods useful for bit manipulation
 * 1. for getting bit at a particular place
 * 2. for setting bit at a particular place
 * 3. for clearing bit at a particular place
 * 4. for calculating bit difference between two numbers
 * 
 * 
 * */

/**
 * Certain operations to know of:
 * 1. ^ : XOR
 * 2. | : OR
 * 3. & : AND
 * 4. ~ : Interchanges the 1s and 0s (transpose)
 * 5. >> or << : arithmetic right shift or left shift. Shifts all bits to right/ left and fills vacant bits with 
 * 				 the signed bit (0 if +ve and 1 if -ve). Essentially a << 1 (No. of places) is as good as a*2 and 1 >> a = a/2
 * 6. >>> or <<< : logical right shift or left shift. Shifts all bits to right/ left and fills vacant bits with
 * 				   with 0.	
 * **/

public class BitManipulation 
{
	public static void main(String args[])
	{
		BitManipulation object = new BitManipulation();
		//System.out.println(object.getBit(00,2));
		//System.out.println(object.setBit(00,3));
		//System.out.println(Integer.toBinaryString(object.clearBit(6,2)));
		int[] array = {1, 2};

		for(int i=1; i<=3; i++)
		{
			System.out.println("Anding "+ Integer.toBinaryString(3) + " with " + Integer.toBinaryString(1<<i));
			System.out.println(Integer.toBinaryString(3 & 1<<i) );
		}

		//object.differentBits(array);

		//System.out.println(Integer.toBinaryString(2));
		//System.out.println(4 << 2);
	}

	/*Get bit at a particular place*/

	public boolean getBit(int num, int i)
	{
		System.out.println(1 << i);
		System.out.println(num & (1 << i));
		return ((num & (1 << i)) !=0);
	}

	/*Set bit at a particular place*/

	public int setBit(int num, int i)
	{
		return num | (1 << i);
	}

	/*Clear bit at a particular place*/

	public int clearBit(int num, int i)
	{

		//System.out.println(Integer.toBinaryString(beforeNegation));
		int mask = ~(1 << i);
		//System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}

	/*Calculate difference in bits of two numbers*/

	public void differentBits(int[] array)
	{
		int count =0;
		for(int i=0; i< array.length; i++)
		{
			for(int j=0; j< array.length; j++)
			{
				int xor = array[i] ^ array[j];
				for(int k=0; k< 32; k++)
				{
					if((xor & (1 << k))!=0)
					{
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	/***
	 * Figuring out 1 bits in an integer
	 * */


}

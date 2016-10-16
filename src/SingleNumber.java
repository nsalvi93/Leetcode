import java.util.Random;

public class SingleNumber 
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,3,2,7};
		single_number(array);
	}
	public static void single_number(int[] nums)
	{
		int diff = 0;
		for (int num : nums) 
		{
			System.out.println(num + " "+ diff);
			diff ^= num;
			System.out.println(diff);
		}
		 diff &= -diff;
		 System.out.println(diff + "***");
	}
}

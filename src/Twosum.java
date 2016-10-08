import java.util.*;

public class Twosum 
{
	public static void main(String[] args)
	{
		Twosum object = new Twosum(); int target = 100;
		int[] numbers = {5,25,75}; 
		
		System.out.println(Arrays.toString(object.twoSum(numbers, target)));
	}
	
	public int[] twoSum(int[] numbers, int target) 
    {
		int[] return_array = new int[2]; int i=0; int j = numbers.length-1;
		
			while(i<j)
			{
			
				if(numbers[j] + numbers[i] == target)
				{
					return_array[0] = j+1; return_array[1] = i+1;
					return return_array;
				}
				else if(numbers[j] + numbers[i] > target)
				{
					j--;
				}
				else if(numbers[j] + numbers[i] < target)
				{
					i++;
				}
			}
		
		return return_array;
            
    }
	
}

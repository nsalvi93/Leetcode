/*Problems included:
 * 1. string reverse
 * 2. Counting bits
 * 3. Reconstructing Queue
 * 
 * */
import java.util.*;
public class ReverseString 
{
	public static void main(String[] args)
	{
		//reverse_string("hellol");
		//countBits(5);
		int[][] array = new int[][]
				{{7,0},{4,4},{7,1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(array);
		
	}
	public static void reverse_string(String s)
	{
		char[] array = s.toCharArray(); StringBuffer sb = new StringBuffer();
		if(array.length==0)
		{
			return;
		}
		for(int i=0; i< array.length/2; i++)
		{
			char temp = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = temp;
		}
		for(char c : array)
		{
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
	public static int[] countBits(int num) 
	{
		int[] array = new int[num+1]; int count=0;
		for(int i=0; i< num+1; i++)
		{
			count = return_count(i);
			array[i] = count;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	private static int return_count(int i) 
	{
		int count=0;
		while(i!=0)
		{
			if(i%2 == 1)
			{
				count++;
			}
			i= i/2;
		}
		return count;
	}
	public static int[][] reconstructQueue(int[][] people) 
	{
		List<int[]> sorted_arrays = new LinkedList<>();
		Comparator<int[]> compare_array = new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) 
			{
				if(o1[0] > o2[0])
				{
					return -1;
				}
				else if(o1[0] == o2[0] && o1[1] > o2[1] )
				{
					return 1;
				}
				else return 1;
			}};
		Arrays.sort(people, compare_array);
		for(int[] cur : people)
		{
			System.out.println(Arrays.toString(cur));
		}
		for(int[] cur : people)
		{
			sorted_arrays.add(cur[1], cur);
		}
		/*for(int[] array : sorted_arrays)
		{
			System.out.println(Arrays.toString(array));
		}*/
		return sorted_arrays.toArray(new int [people.length][]);
	}
}

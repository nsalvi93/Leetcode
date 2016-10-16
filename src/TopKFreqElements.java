import java.util.*;
public class TopKFreqElements 
{
	public static void main(String[] args)
	{
		int[] array = {4,4, 1,2,3};
		List<Integer> temp_list = topKFrequent(array, 2);
		System.out.println(temp_list.toString());
	}
	public static List<Integer> topKFrequent(int[] nums, int k) 
	{
		Map<Integer, Integer> int_map = new LinkedHashMap<>();
		List<Integer> return_list = new ArrayList<>();
		for(int i=0; i< nums.length; i++)
		{
			if(int_map.containsKey(nums[i]))
			{ 
				int value = int_map.get(nums[i]);
				int_map.put(nums[i], ++value );	
			}
			else 
			{	
				int_map.put(nums[i], 1);
			}
		}
		
		System.out.println(int_map.toString());
		
		Comparator<Integer> compare = new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2) 
			{
				if(int_map.get(o1) > int_map.get(o2))
				{
					return -1;
				}
				else if(int_map.get(o1) == int_map.get(o2))
				{
					if(o1 > o2)
					{
						return 1;
					}
					else if (o1 < o2)
					{
						return -1;
					}
					else return 0;
				}
				else return 1;
			}
		};
		PriorityQueue<Integer> p_queue = new PriorityQueue(compare);
		for(int num : nums)
		{
			p_queue.add(num);
		}
		while(!p_queue.isEmpty())
		{
			return_list.add(p_queue.poll());
		}
		return return_list;
	}
}

import java.util.*;


public class island_problem 
{
	public static void main(String[] args)
	{
		int[][] array = new int[][] {{1, 1, 0, 0, 0},
            						 {0, 1, 0, 0, 1},
            						 {1, 0, 0, 1, 1},
            						 {0, 0, 0, 0, 0},
            						 {1, 0, 1, 0, 1}
           };

			island_problem object = new island_problem();
			object.method_call(array);
	}

	public void method_call(int[][] array) 
	{
		Stack<Integer[]> island_stack = new Stack<>(); int island_count =0;
		boolean [][] check_array = new boolean[array.length][array[0].length];
		/*for(int i=0; i< check_array.length; i++)
		{
			System.out.println(Arrays.toString(check_array[i]));
		}*/

		for(int i=0; i< array.length; i++)
		{
			for(int j=0; j< array[i].length; j++)
			{
				if(array[i][j] == 1 && check_array[i][j] == false)
				{
					island_count++;
					System.out.println("Found at "+ i +" "+ j);
					Integer[] temp = {i,j};
					island_stack.push(temp);
					while(island_stack.isEmpty()!= true)
					{
						Integer[] temp_array = island_stack.pop();
						if(temp_array[0]< array.length-1 || temp_array[1]< array[temp_array[1]].length-1 )
						{
							//System.out.println("Entered for "+ temp_array[0] + " " + temp_array[1]);
							if(temp_array[0]< array.length-1 && array[temp_array[0]+1][temp_array[1]] == 1)
							{
								Integer[] temp_array1 = {temp_array[0]+1, temp_array[1]}; 
								check_array[temp_array[0]+1] [temp_array[1]] = true;
								island_stack.push(temp_array1);
							}
							if(temp_array[1]< array[temp_array[1]].length-1 && array[temp_array[0]][temp_array[1]+1] == 1)
							{
								Integer[] temp_array1 = {temp_array[0]+1, temp_array[1]}; 
								check_array[temp_array[0]] [temp_array[1]+1] = true;
								island_stack.push(temp_array1);
							}
						}
						
					}
				}
				else continue;
			}
		}
			System.out.println(island_count);
	}
}

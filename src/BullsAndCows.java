import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BullsAndCows 
{
	public static void main(String[] args)
	{
		BullsAndCows object = new BullsAndCows();
		String return_string = object.method("1", "0");
		System.out.println(return_string);
	}

	public String method(String secret, String guess) 
	{
		int bulls =0; int cows =0;
		char[] guess_array = guess.toCharArray();
		StringBuffer buffer = new StringBuffer();
		List<Character> char_list = new ArrayList<>();
		List<Character> guess_char_list = new ArrayList<>();
		char[] secret_array = secret.toCharArray();
		
		for(int i =0; i< secret_array.length; i++)
		{
			char_list.add(secret_array[i]);
			guess_char_list.add(guess_array[i]);
		}

		for(int i=0; i< guess_array.length; i++)
		{
			if(secret_array[i] == guess_array[i])
			{
				char_list.remove(Character.valueOf(guess_array[i]));
				guess_char_list.remove(Character.valueOf(guess_array[i]));
				bulls++;
			}
		}

		for(Character guess_char : guess_char_list )
		{
			if(char_list.contains(guess_char)) 
			{
				cows++; char_list.remove(Character.valueOf(guess_char));
			}
		}
		return buffer.append(bulls+ "A" + cows+ "B").toString();
	}
}

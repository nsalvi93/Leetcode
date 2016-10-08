/*Below program has the following methods:  ****STRING MANIPULATION *****
 * 
 * 1. proper spacing w.r.t words and special characters:
 * eg: Input: "   Hello Geeks . Welcome   to  GeeksforGeeks   .    "  Output: Hello Geeks. Welcome to GeeksforGeeks.   
 * 
 * 2. Longest substring with non repeated characters
 * 
 * 3. All possible permutations possible for a string
 * 
 * 4. Ascii to int (converting number string to int) 
 * 
 * 5. First non-repeating character occurrence in a string
 * 
 * 6. Longest substring with atleast with characters repeating atleast k no. of times  //Not getting
 * 
 * */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
public class stringManipulation {
	public static void main(String args[])
	{
		stringManipulation object = new stringManipulation();
		//int count = object.lengthOfLongestSubstring("iabcdij");
		//System.out.println(count);
		//object.specialCharacters("   Hello Geeks . Welcome   to  GeeksforGeeks   .    ");
		//object.permutaitons("strings");
		//object.askiiToInt("123");
		object.nonRepeatingCharacter("cc");
		object.atleastKFreq("ababacb", 3);
	}
	/*proper spacing w.r.t. special characters and words*/
	public void specialCharacters(String s)
	{
		String[] array = s.split("\\s+");
		System.out.println(Arrays.toString(array));
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< array.length; i++)
		{
			if(array[i].isEmpty())
			{
				System.out.println("Entered");
				continue;
			}
			System.out.println("String under consideration "+ array[i]);
			if(array[i].charAt(0) < 'Z' && array[i].charAt(0) > 'A' || array[i].charAt(0) < 'z' && array[i].charAt(0) > 'a')
			{
				sb.append(" ");
				sb.append(array[i]);
				System.out.println("StringBuffer is "+sb.toString());
			}
			else
			{
				sb.append(array[i]);
			}
		}
		//System.out.println(sb.toString());
	}
	public static int lengthOfLongestSubstring(String s) {
		if(s==null)
			return 0;
		char[] arr = s.toCharArray();
		int pre = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
				System.out.println("in if "+map.toString());
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				System.out.println(map.toString());
				map.clear();
			}
		}
		return Math.max(pre, map.size());
	}
	public void permutaitons(String s)
	{
		char[] array = s.toCharArray();
		Set<String> strings = new HashSet<>();
		for(int i=0; i< array.length-1; i++)
		{
			for(int j= i+1; j< array.length; j++)
			{
				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				//System.out.println(Arrays.toString(array));
				strings.add(String.valueOf(array));
			}
		}
		System.out.println(strings.toString());
	}
	public void askiiToInt(String s)
	{
		int [] array = new int[s.length()];
		int number =0;
		for(int i=0; i< s.length(); i++)
		{
			array[i] = s.charAt(i) - '0';
			number = number * 10 + array[i];
		}
		System.out.println(number);
	}
	/*First non-repeating character occurrence in a string*/
	public void nonRepeatingCharacter(String s)
	{
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		Character unique = null;
		char[] stringArray = s.toCharArray();
		int repeat =0;
		for(int i=0; i< stringArray.length; i++ )
		{
			if(!charMap.keySet().contains(stringArray[i]))
			{
				charMap.put(stringArray[i], 1);
			}
			else
			{
				Integer value = charMap.get(stringArray[i]);
				value++;
				charMap.put(stringArray[i], value);
			}
		}
		//System.out.println(charMap.toString());
		for(Character i : charMap.keySet())
		{
			int value = charMap.get(i);
			if(value == 1)
			{
				unique = i;
				//System.out.println("found unique "+ unique);
				break;
			}
		}
		for(int i=0; i< stringArray.length; i++ )
		{
			if(unique!= null && stringArray[i] == unique)
			{
				System.out.println(i);
				break;
			}
		}
	}

	/* 6th question */

	public void atleastKFreq(String s, int k)
	{
		Map<Character, Integer> charFreqMap = new LinkedHashMap<>();
		char[] charArray = s.toCharArray();
		int startIndex =0,endIndex=0, max=0, charFreq=0, thresh=0;
		int maxUniqueCount = charArray.length/k;
		System.out.println("String is "+ s);
		System.out.println("Total uniques expected "+ maxUniqueCount);
		for(int i=0; i< charArray.length; i++)
		{
			if(!charFreqMap.containsKey(charArray[i]))
			{
				charFreqMap.put(charArray[i], 1);
				maxUniqueCount--;
				if(maxUniqueCount< 0)
				{
					charFreqMap.clear();
					maxUniqueCount = (charArray.length - i)/k + 1;
					thresh = i;
				}
				System.out.println("Found unique "+ charArray[i] + " now unique count is "+ maxUniqueCount );
			}
			else
			{
				charFreq = charFreqMap.get(charArray[i]);
				charFreq++; charFreqMap.put(charArray[i], charFreq);
				if(charFreqMap.get(charArray[i])>= k)
				{
					System.out.println("Found atleast k freq char "+ charArray[i]);
					startIndex =i-1;
					endIndex=0;
					while(startIndex>= thresh)
					{
							//System.out.println(charArray[startIndex]);
							if(charFreqMap.get(charArray[startIndex]) < k)
							{
								System.out.println("breaking ****");
								//endIndex =0;
								break;
							}
							startIndex--;
							System.out.println("increasing index +++++");
							endIndex++;
						
					}

				}
				
			}
			max = Math.max(max, endIndex);
			System.out.println("Max is "+ max + " and endIndex is "+ endIndex);
		}

		System.out.println(max+1);
	}
}

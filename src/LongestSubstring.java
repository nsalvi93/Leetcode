import java.util.ArrayList;
import java.util.List;
//longest substring without repeating characters
public class LongestSubstring 
{
	public static void main(String args[])
	{
		LongestSubstring object = new LongestSubstring();
		int longestStringlength = object.lengthOfLongestSubstring("dvdf");
		System.out.println(longestStringlength);
	}
	 public int lengthOfLongestSubstring(String s) 
	 {
		 int maxLength =0;
		 for(int i=0; i< s.length() && (s.length()-i) > maxLength; i++ )
		 {
			 List<Character> strings = new ArrayList<>();
			 StringBuilder sb = new StringBuilder();
			 strings.add(s.charAt(i));
			 sb.append(s.charAt(i));
			 System.out.println("StringBuffer is "+ sb.toString());
			 System.out.println("List is "+ strings.toString());
			 for(int j=i+1; j<s.length(); j++ )
			 {
				 if(strings.contains(s.charAt(j)))
				 {
					  break;
				 }
				 else
				 {
					 sb.append(s.charAt(j));
					 strings.add(s.charAt(j));
					 System.out.println("StringBuffer is in append "+ sb.toString());
				 }
			 }
			 if(sb.length() > maxLength)
			 {
				 maxLength = sb.length();
				 System.out.println("sb.length is "+ sb.length());
				 //i= sb.length()-i;
				 System.out.println("****"+ i);
			 }
		 }
		 return maxLength;
	 }
}

import java.util.List;

class Node
{
	char value;
	Node parent;
	List<Node> child_list = null;
	public Node(char value, Node parent)
	{
		this.value = value;
		this.parent = parent;
	}
	
	public void get_child(Node child)
	{
		this.child_list.add(child);
	}
}

public class LongestCommonPrefix 
{
	public static void main(String[] args)
	{
		LongestCommonPrefix object = new LongestCommonPrefix();
		String word = "geeks";
		char[] array = word.toCharArray();
		object.method(array);
	}

	public void method(char[] array) 
	{
		//Node root= null;
		for(int i=1; i< array.length; i++)
		{
			Node node = new Node(array[i], new Node(array[i-1], null));
			
		}
		
	}
}

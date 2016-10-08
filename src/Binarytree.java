import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode 
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Binarytree 
{
	static Queue<TreeNode> node_valuelist = new LinkedList<>();
	static Queue<Integer> node_valuelist1 = new LinkedList<>();
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		/*root.right.left = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(3);
		
		root.left.left.right.left = new TreeNode(9);
		root.left.left.right.right = new TreeNode(10);*/
		//rightSideView(root);
		add_in_Q(root);
		System.out.println(node_valuelist.toString());
		rightSideView(root);
		
	}


	public static void add_in_Q(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			node_valuelist.add(root);
			add_in_Q(root.right);
			add_in_Q(root.left);
		}
	}

	public static List<Integer> rightSideView(TreeNode root) 
	{
		int count =0; List<Integer> node_intlist = new ArrayList<>();
		while(node_valuelist.isEmpty()!= true)
		{
			TreeNode node = node_valuelist.poll();
			node_intlist.add(node.val);
			count++;
			if(node.right!= null )
			{
				continue;
			}
			else
			{
				while(count!= 0 && node_valuelist.peek()!= node.left)
				{
					//System.out.println("En");
					node_valuelist.poll();
					count--;
				}
				
			}
			
			
		}
		System.out.println(node_intlist.toString());
		return null;
	}
}

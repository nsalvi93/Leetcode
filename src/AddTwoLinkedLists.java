/*Program for summing up two linkedLists by taking into account carryovers 
 * eg: 1 -> 5 -> 2  + 2 -> 5 -> 2 should give:  3 -> 0 -> 5
 * 
 * 
 * */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) 
	{ val = x; }
}
public class AddTwoLinkedLists 
{
	public static void main(String args[])
	{
		AddTwoLinkedLists object = new AddTwoLinkedLists();
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(3);
		//list1.next.next.next = new ListNode(3);


		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(4);
		//list2.next.next.next = new ListNode(9);


		ListNode head =object.addTwoNumbers(list1, list2);
		object.printList(head);
		//object.printList(list2);



	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		ListNode head = null;
		ListNode current = null;
		int carryOver = 0, totalValue=0;
		if(l1 == null || l2 == null)
		{
			return null;
		}

		while(l1!= null || l2!= null )
		{
			if(l1 == null  )
			{
				totalValue = l2.val+carryOver;
				l2=l2.next;
				carryOver=0;
				if(totalValue/10 > 0 )
				{
					carryOver = totalValue/10;
					totalValue = totalValue % 10;
				}

			}
			else if(l2 == null)
			{
				totalValue = l1.val+carryOver;
				l1=l1.next;
				carryOver=0;
				if(totalValue/10 > 0 )
				{
					carryOver = totalValue/10;
					totalValue = totalValue % 10;
				}

			}

			else 
			{
				totalValue = l1.val + l2.val + carryOver;
				carryOver=0;
				if(totalValue/10 > 0 )
				{
					carryOver = totalValue/10;
					totalValue = totalValue % 10;
				}
				l2=l2.next;
				l1=l1.next;
			}
			if(head == null){head = new ListNode(totalValue); current = head;}
			else
			{
				ListNode newNode = new ListNode(totalValue); 
				current.next = newNode;
				current = current.next;
			}




		}
		if(carryOver!=0 )
		{
			totalValue = carryOver;
			ListNode newNode = new ListNode(totalValue); 
			current.next = newNode;
			current = current.next;

		}


		/*while(l1!= null && l2!= null)
		{
			//System.out.println("Entered with l1 value "+ l1.val + " and l2 value as "+ l2.val);
			totalValue = l1.val + l2.val + carryOver;
			if(totalValue/10 > 0 )
			{
				carryOver = totalValue/10;
				totalValue = totalValue % 10;
			}
			if(head == null){head = new ListNode(totalValue);current = head;}
			else
			{
				ListNode newNode = new ListNode(totalValue); 
				current.next = newNode;
				current = current.next;
			}

			if(l1.next== null && l2.next!= null)
			{
				//System.out.println("Entered if with l2 value "+ l2.next.val);
				current.next = l2.next;
				current.next.val = current.next.val + carryOver;
				break;
			}
			else if(l2.next== null && l1.next!= null)
			{
				//System.out.println("Entered if with l1 value "+ l1.next.val);
				current.next = l1.next;
				current.next.val = current.next.val + carryOver;
				break;
			}
			l1=l1.next;
			l2=l2.next;

		}*/
		return head;
	}
	public void printList(ListNode node)
	{
		while(node!= null)
		{
			System.out.println(node.val);
			node = node.next;
		}

	}
}

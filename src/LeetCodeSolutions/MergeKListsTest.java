package LeetCodeSolutions;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MergeKListsTest {

	@Test
	public void testMergeKLists() {
		MergeKLists merge = new MergeKLists();
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		
		ListNode test1 = new ListNode(0);
		
		ListNode test2 = new ListNode(0);
		
		ListNode cur1 = test1, cur2 = test2;
		
		for(int i = 0; i < 10; i ++){
			cur1.next = new ListNode(i + 3);
			cur1 = cur1.next;
			cur2.next = new ListNode(i + 5);
			cur2 = cur2.next;
		}
		
		lists.add(test1.next);
		lists.add(test2.next);
		
		ListNode head = merge.mergeKLists(lists);
		
		int lastVal = Integer.MIN_VALUE;
		
		for(ListNode node = head; node != null; node = node.next){
			assertTrue(node.val >= lastVal);
			lastVal = node.val;
		}
	}

}

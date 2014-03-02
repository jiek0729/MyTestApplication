package LeetCodeSolutions;

import java.util.*;

public class MergeKLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Create dummy head list node.
        ListNode head = new ListNode(0);
        
        // Instantiate priority queue as min heap.
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size() + 1,
        new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });
        
        // Initializes min heap with lists.
        for(ListNode node : lists){
        	if(node != null){
        		queue.add(node);
        	}
        }
        
        ListNode cur = head;
        
        ListNode node = null;
        
        // Merge.
        while((node = queue.poll()) != null){
            
            cur.next = node;
            
            if(node.next != null){
                queue.offer(node.next);
            }
            
            cur = cur.next;
        }
        
        return head.next;
    }
}

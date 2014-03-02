package LeetCodeSolutions;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = null;
        
        Queue<LinkedList<ListNode>> cache = new LinkedList<LinkedList<ListNode>>();
        
        ListNode runner = head;
        
        while(runner != null){
            LinkedList<ListNode> stack = new LinkedList<ListNode>();
            
            for(int i = 0; i < k && runner != null; i++){
                stack.addLast(runner);
                runner = runner.next;
            }
            
            cache.offer(stack);
        }
        
        while(cache.size() > 0){
            LinkedList<ListNode> stack = cache.poll();
            
            if(ret == null){
                ret = stack.removeLast();
                runner = ret;
            }
            
            while(stack.size() > 0){
                runner.next = stack.removeLast();
                runner = runner.next;
            }
        }
        
        return ret;
    }
    
    public static void main(String[] args){
    	ReverseNodesInKGroup s = new ReverseNodesInKGroup();
    	
    	ListNode node = new ListNode(1);
    	node.next = new ListNode(2);
    	node.next.next = new ListNode(3);
    	
    	ListNode n = s.reverseKGroup(node, 2);
    	
    	System.out.println(n.val + " " + n.next.val + " " + n.next.next.val);
    }
}

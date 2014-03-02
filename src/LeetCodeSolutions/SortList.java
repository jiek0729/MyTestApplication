package LeetCodeSolutions;

public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode node){
    	SortList.PrintListNode(node);
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode r1 = node, r2 = node.next;
        
        while(r2 != null && r2.next != null){
        	System.out.println("enter loop");
            r1 = r1.next;
            r2 = r2.next.next;
        }
        
        ListNode mid = r1.next;
        r1.next = null;
        
        node = mergeSort(node);
        mid = mergeSort(mid);
        
        return merge(node, mid);
    }
    
    private ListNode merge(ListNode n1, ListNode n2){
        if(n2 == null || n1 == n2){
            return n1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                runner.next = n1;
                n1 = n1.next;
            }else{
                runner.next = n2;
                n2 = n2.next;
            }
            
            runner = runner.next;
        }
        
        if(n1 != null){
            runner.next = n1;
        }else{
            runner.next = n2;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args){
    	ListNode node1 = new ListNode(2);
    	ListNode node2 = new ListNode(1);
    	node1.next = node2;
    	
    	SortList sl = new SortList();
    	ListNode node = sl.sortList(node1);
    	
    	SortList.PrintListNode(node);
    }
    
    public static void PrintListNode(ListNode node){
    	ListNode runner = node;
    	
    	while(runner != null){
    		System.out.print(runner.val + " -> ");
    		runner = runner.next;
    	}
    	
    	System.out.println();
    }
}

package LeetCodeSolutions;

import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
//		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
//		
//		for(int i = 1; i <= n - 1; i++){
//			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
//			for(int j = i + 1; j <= n; j++){
//				ArrayList<Integer> list = new ArrayList<Integer>();
//				list.add(j);
//				
//				temp.add(list);
//			}
//			
//			for(ArrayList<Integer> list : temp){
//				list.add(0, i);
//			}
//			
//			ret.addAll(temp);
//		}
//
//		return ret;
		
        return combine(1, n - k + 1, n);
    }
    
    private ArrayList<ArrayList<Integer>> combine(int s, int e, int n){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if(e > n){
        	ret.add(new ArrayList<Integer>());
        	
        	return ret;
        }
        
        for(int i = s; i <= e; i++){
        	
        	ArrayList<ArrayList<Integer>> temp = combine(i + 1, e + 1, n);
        	
        	for(ArrayList<Integer> list : temp){
            	list.add(0, i);
            }
        	
        	ret.addAll(temp);
        }
        
        return ret;
    }
    
    public static void main(String[] args){
    	Combinations c = new Combinations();
    	
    	ArrayList<ArrayList<Integer>> result = c.combine(4, 2);
    	
    	for(ArrayList<Integer> l : result){
    		CombinationSumTwo.printList(l);
    	}
    }
}

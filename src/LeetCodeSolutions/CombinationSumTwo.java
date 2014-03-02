package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumTwo {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(num.length < 1){
            return result;
        }
        
        Arrays.sort(num);
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for(int i = 0; i < num.length; i++){
            int need = target - num[i];
            int curSum = 0;
            list.clear();
            
            int j = 0;
            while(j <= i){
            	
                if(curSum < need){
                	if(curSum == Integer.MIN_VALUE){
                		curSum = 0;
                	}
                	
                	curSum += num[j];
                	
                    list.addLast(num[j]);
                    j++;
                }else{
                    if(curSum == need){
                        found(result, list, num[i]);
                    }
                    
                    if(list.size() <= 1){
                        break;
                    }
                    
                    curSum -= list.removeFirst();
                }
            }
        }
        
        return result;
    }
    
    private void found(ArrayList<ArrayList<Integer>> list, LinkedList<Integer> l, int last){
        ArrayList<Integer> temp = new ArrayList<Integer>(l);
        temp.add(last);
        list.add(temp);
    }
    
    private void makeUnique(ArrayList<ArrayList<Integer>> all) {
        // check if the adjacent index of all is the same
    	
        for(int i =0;i<all.size()-1;i++){
            ArrayList<Integer> curAl = all.get(i);
            for(int j = i+1;j<all.size();j++){
            ArrayList<Integer> nextAl = all.get(j);
            //check the same
            if(isSameList(curAl,nextAl)){
                all.remove(j);
                j--;
            }
        }
        }
    }
 
    private boolean isSameList(ArrayList<Integer> list1,
            ArrayList<Integer> list2) {
        // check if the two list is the same
        if(list1.size() != list2.size()){
            return false;
        }
        for(int i =0;i<list1.size();i++){
            if(list1.get(i)!= list2.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
    	int[] num = {4,1,1,4,4,4,4,2,3,5};
    	
    	int target = 10;
    	
    	CombinationSumTwo cst = new CombinationSumTwo();
    	
    	ArrayList<ArrayList<Integer>> result = cst.combinationSum2(num, target);
    	
    	for(int i = 0; i < result.size(); i++){
    		printList(result.get(i));
    	}
    }
    
    public static <E> void printList(List<E> list){
    	for(int i = 0; i < list.size(); i++){
    		System.out.print(list.get(i));
    	}
    	
    	System.out.println();
    }
}

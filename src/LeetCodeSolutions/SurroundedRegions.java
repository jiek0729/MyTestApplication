package LeetCodeSolutions;

import java.util.*;

public class SurroundedRegions {
	/* This is a short comments */
	public void solve(char[][] board) {
        HashMap<Index, Boolean> currTrav = new HashMap<Index, Boolean>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    currTrav.clear();
                    Index o = new Index(i, j);
                    currTrav.put(o, true);
                    if(check(board, o, currTrav)){
                        for(Index ind : currTrav.keySet()){
                            board[ind.getX()][ind.getY()] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    private boolean check(char[][] board, Index curr, HashMap<Index, Boolean> traved){
        boolean res = true;
        
        for(Index ind : curr.getNear()){
        	if(outOfRange(ind, board[0].length, board.length)){
        		return false;
        	}
        	else if(board[ind.getX()][ind.getY()] == 'O' && !traved.containsKey(ind)){
                traved.put(ind, true);
                res = res && check(board, ind, traved);
                if(res == false){
                	return false;
                }
            }
        }
        
        return res;
    }
    
    private boolean outOfRange(Index ind, int width, int height){
        return ind.getY() < 0 || ind.getY() > width - 1
        || ind.getX() < 0 || ind.getX() > height - 1;
    }
    
    public class Index
    {
        private int x;
        private int y;
        
        public Index(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return this.x;
        }
        
        public int getY(){
            return this.y;
        }
        
        public Index getTop(){
            return new Index(this.x - 1, this.y);
        }
        
        public Index getBelow(){
            return new Index(this.x + 1, this.y);
        }
        
        public Index getLeft(){
            return new Index(this.x, this.y - 1);
        }
        
        public Index getRight(){
            return new Index(this.x, this.y + 1);
        }
        
        public ArrayList<Index> getNear(){
            ArrayList<Index> res = new ArrayList<Index>();
        
            res.add(this.getTop());
            res.add(this.getLeft());
            res.add(this.getBelow());
            res.add(this.getRight());
            
            return res;
        }
        
        @Override
        public boolean equals(Object o){
            if(o instanceof Index){
                return ((Index)o).getX() == this.x && ((Index)o).getY() == this.y;
            }
            
            return false;
        }
        
        @Override
        public int hashCode(){
            return this.x << 16 + this.y;
        }
    }
    
    public static void main(String[] args){
    	char[][] board = {
    			"XOXOXO".toCharArray(),
    			"OXOXOX".toCharArray(),
    			"XOXOXO".toCharArray(),
    			"OXOXOX".toCharArray(),
    			};
    	
    	SurroundedRegions s = new SurroundedRegions();
    	
    	s.solve(board);
    	
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			System.out.print(board[i][j] + " ");
    		}
    		
    		System.out.println();
    	}
    }
}

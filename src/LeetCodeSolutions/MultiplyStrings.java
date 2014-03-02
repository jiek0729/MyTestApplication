package LeetCodeSolutions;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        
        int[] d = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < num1.length(); i++){
            int d1 = num1.charAt(i) - '0';
            
            for(int j = 0; j < num2.length(); j++){
                int d2 = num2.charAt(j) - '0';
                
                d[i + j] += d1 * d2;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < d.length; i++){
            int carry = d[i] / 10;
            
            sb.append(d[i] % 10);
            
            if(i < d.length - 1){
                d[i + 1] += carry;
            }
        }
        
        sb = sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args){
    	MultiplyStrings s = new MultiplyStrings();
    	
    	System.out.println(s.multiply("47721000541511454000", "54884321897654189789715879"));
    }
}

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> order= new Stack<>();

        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='('){
                order.push(result.length());

            }else if(s.charAt(i)==')'){
                int l = order.pop();

                String temp = result.substring(l);
                result.delete(l,result.length());
                result.append(new StringBuilder(temp).reverse());
                

            }else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
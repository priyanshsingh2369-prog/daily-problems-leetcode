class Solution {
    public String removeStars(String s) {
        Stack<Character> chr = new Stack<>();
        
        for (char ch :s.toCharArray()){
            if(ch=='*'){
                chr.pop();
            }

            else{
                chr.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : chr){
            ans.append(ch);
        }
        return ans.toString();
    }
}
class Solution {
    public boolean closeStrings(String word1, String word2) {
        // if(word1.length()!= word2.length() )return false; 
        // int [ ] freq1 = new int[26];
        // int [] freq2 = new int[26];
        // for(int i = 0; i <word1.length();i++){
        //        freq1[word1.charAt(i)- 'a']++;
        //         freq2[word2.cahrAt(i)- 'a']++;
        //     }
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char a : word1.toCharArray()){
            map1.put(a,map1.getOrDefault(a,0)+1);
        }
        for(char a : word2.toCharArray()){
            map2.put(a,map2.getOrDefault(a,0)+1);
        }
        for(char ch : word1.toCharArray()){
            if(!map2.containsKey(ch)){
                return false;
            }
        }
        
        List<Integer> ans1 = new ArrayList<>(map1.values());
        List<Integer> ans2 = new ArrayList<>(map2.values());
        
        Collections.sort(ans1);
        Collections.sort(ans2);


        return ans1.equals(ans2) ;
    }
}
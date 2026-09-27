import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        // Store knowledge in HashMap
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                int j = i + 1;

                // Find closing ')'
                while (s.charAt(j) != ')') {
                    j++;
                }

                // Get key between brackets
                String key = s.substring(i + 1, j);

                // Add value or ?
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append("?");
                }

                // Move i to ')'
                i = j;

            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
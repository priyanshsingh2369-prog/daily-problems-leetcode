class Solution {
    public int compress(char[] chars) {
        int writeindex = 0;
        int readindex = 0;

        while(readindex < chars.length){
            char currchar = chars[readindex];
            int count = 0;

            while (readindex < chars.length && chars[readindex] == currchar){
                readindex++;
                count ++;

            }
            chars[writeindex++]= currchar;

            if(count >1){
                for(char num : Integer.toString(count).toCharArray()){
                    chars[writeindex++] = num;
                }
            }
            

        }
        return writeindex;

    }
}
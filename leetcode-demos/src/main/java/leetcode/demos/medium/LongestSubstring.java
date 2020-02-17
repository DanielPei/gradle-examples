package leetcode.demos.medium;

import java.util.HashMap;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/17 11:28
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s){
        /**
         * Get the length of longest substring without repeating chars.
         */
        int len = 0;

        if( s == null || s.length()==0){
            return len;
        }

        int lengthOfStr = s.length();
        System.out.println("Length of original string is : " + lengthOfStr);

        HashMap<Character, Integer> charLastIndexMap = new HashMap<>();

        for (int i = 0, j=0; i < lengthOfStr; i++) {

            if(charLastIndexMap.containsKey(s.charAt(i))){
                j = Math.max(j, charLastIndexMap.get(s.charAt(i)));
            }

            len = Math.max(i-j +1, len);
            charLastIndexMap.put(s.charAt(i), i+1);
        }

        return len;
    }

}

package leetcode.demos.medium;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/18 22:45
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Get the longest substring reads the same backward as forward
 */
public class LongestPalindromicSubstring {

    /**
     * Assume the maximum length for s is 1,000.
     * <p>
     * s = "abcbe"
     * output = "bcb"
     * len(s) = n;
     * <p>
     * let len(output) = m, the index of first char in output in string s is i.
     * => half_len_output = (m+1)/2,  output[0,half_len_output-1] = inverse( output[half_len_output,m-1])
     * <p>
     * if m is even, s[i] = s[i+1], s[i-1] = s[i+2];
     * else if m is odd, s[i-1] = s[i+1], s[i-2] = s[i+2];
     * <p>
     * for i in [0,n-1]:
     * HashMap<string, int> char_map;
     * char_curr = s[i];
     * <p>
     * if( ! char_map.containsKey( char_curr) ) {
     * char_map.put( char_curr) =
     * }
     * <p>
     * a : [ 0 ],
     * b : [ 1, 3 ],
     * c : [ 2 ],
     * e : [ 4 ]
     * => if all chars' show times is 1, the result will be any char in string s.
     * <p>
     * ? what about starting from the most frequent chars?
     *
     * @param s
     * @return
     */
    public String solution(String s) {
        // Time limit exceeded!
        // Failed to  "C" * 200
        if (s == null || s.length() == 0) {
            return "";
        }
        HashMap<Character, ArrayList<Integer>> charMap = new HashMap<>();

        int leftIndex = 0, rightIndex = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            char current_char = s.charAt(i);

            if (charMap.containsKey(current_char)) {
                ArrayList<Integer> charPositions = charMap.get(current_char);
                Integer[] charPositionsArray = new Integer[charPositions.size()];
                charPositions.toArray(charPositionsArray);

                for (int j = 0; j < charPositionsArray.length; j++) {
                    int minPosition = charPositionsArray[j];
                    int distance = i - minPosition;

                    if (distance % 2 == 0) {
                        int len = searchAround(s, i - distance / 2, i - distance / 2);
                        if (len > (rightIndex - leftIndex + 1)) {
                            leftIndex = (i - distance / 2) - len / 2;
                            rightIndex = (i - distance / 2) + len / 2;
                        }
                    } else {
                        // i = 2, min = 1, dist = 1,
                        // 1,2
                        int len = searchAround(s, i - (distance + 1) / 2, i - (distance + 1) / 2 + 1);
                        if (len > (rightIndex - leftIndex + 1)) {
                            leftIndex = (i - distance / 2) - len / 2;
                            rightIndex = (i - distance / 2) + len / 2 - 1;
                        }
                    }
                }

                charPositions.add(i);
                charMap.put(current_char, charPositions);
            } else {
                ArrayList<Integer> charPositions = new ArrayList<>();
                charPositions.add(i);
                charMap.put(current_char, charPositions);
            }
        }

        String output = s.substring(leftIndex, rightIndex + 1);
        return output;
    }

    /**
     * Time cost : O(n^2)
     * Space cost : O(1)
     * @param s
     * @return
     */
    public String optimizedSolution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len_1 = searchAround(s, i, i);
            int len_2 = searchAround(s, i, i + 1);
            int len = Math.max(len_1, len_2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // TODO : Manacher's Algorithm which time cost is only O(n)!

    public int searchAround(String s, int start, int end) {
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}

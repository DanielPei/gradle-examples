package leetcode.demos.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/17 11:58
 */
public class LongestSubstringTest {
    @Test
    public void testLengthOfLongestSubstring() {
        LongestSubstring ls = new LongestSubstring();

        assertEquals("LengthOfLongestSubstring should be 0 ! ", 0, ls.lengthOfLongestSubstring(""));
        assertEquals("LengthOfLongestSubstring should be 3 ! ", 3, ls.lengthOfLongestSubstring("abc"));
        assertEquals("LengthOfLongestSubstring should be 3 ! ", 3, ls.lengthOfLongestSubstring("abcabcabc"));
        assertEquals("LengthOfLongestSubstring should be 6 ! ", 6, ls.lengthOfLongestSubstring("abcaefg"));
    }
}

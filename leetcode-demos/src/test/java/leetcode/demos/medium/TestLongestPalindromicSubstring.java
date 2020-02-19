package leetcode.demos.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/19 22:32
 */
public class TestLongestPalindromicSubstring {
    LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

    public static HashMap<String, String> str_expected;

    static {
        str_expected = new HashMap<>();
        str_expected.put("cbbd", "bb");
        str_expected.put("babad", "bab");
        str_expected.put("cccccccccc", "cccccccccc");
        str_expected.put("", "");
        str_expected.put(null, "");
    }


    @Test
    public void testOptimized() {
        for (Map.Entry<String, String> entry: str_expected.entrySet()) {
            Assert.assertEquals(entry.getValue(), lps.optimizedSolution(entry.getKey()));
        }
    }

    @Test
    public void testSolution() {
        for (Map.Entry<String, String> entry: str_expected.entrySet()) {
            Assert.assertEquals(entry.getValue(), lps.solution(entry.getKey()));
        }
    }
}

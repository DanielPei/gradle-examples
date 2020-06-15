package leetcode.demos.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/21 09:07
 */
public class TestReverseInteger {
    public ReverseInteger ri = new ReverseInteger();
    public static HashMap<Integer, Integer> cases = new HashMap<>();

    static {
        cases.put(0, 0);
        cases.put(1534236469, 0);
        cases.put(-2147483648, 0);
        cases.put(123, 321);
        cases.put(-235, -532);
    }

    @Test
    public void testSolution() {
        for (Map.Entry<Integer, Integer> entry : cases.entrySet()) {
            assertEquals(entry.getValue().toString(), Integer.toString(ri.optimize(entry.getKey())));
        }
    }
}

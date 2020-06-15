package leetcode.demos.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/20 22:28
 */
class Case {
    public String src;
    public Integer rows;
    public String output;

    public Case(String src, Integer rows, String output) {
        this.src = src;
        this.rows = rows;
        this.output = output;
    }
}

public class TestZigZagConversion {
    public ZigZagConversion zzc = new ZigZagConversion();
    public static List<Case> caseList = new ArrayList<>();

    static {
        caseList.add(new Case("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"));
        caseList.add(new Case("PAYPALISHIRING", 1, "PAYPALISHIRING"));
        caseList.add(new Case("", 1, ""));
        caseList.add(new Case(null, 1, null));
    }

    @Test
    public void testSolution() {
        for (Case c : caseList) {
            Assert.assertEquals(c.output, zzc.solution(c.src, c.rows));
        }
    }
}

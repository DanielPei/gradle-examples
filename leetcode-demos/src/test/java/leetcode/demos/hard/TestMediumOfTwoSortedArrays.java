package leetcode.demos.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/17 19:15
 */
public class TestMediumOfTwoSortedArrays {

    @Test
    public void testMediumOfTwoSortedArrays() {
        MediumOfTwoSortedArrays motsa = new MediumOfTwoSortedArrays();

        double actual = motsa.mediumOfTwoSortedArrays(new int[]{1, 3, 5}, new int[]{});
        Assert.assertEquals(3.0, actual, 0.0);

        actual = motsa.mediumOfTwoSortedArrays(new int[]{1, 3, 5}, new int[]{4, 5});
        Assert.assertEquals(4.0, actual, 0.0);

        actual = motsa.mediumOfTwoSortedArrays(new int[]{1, 3, 5}, new int[]{7, 9, 10});
        Assert.assertEquals(6.0, actual, 0.0);

    }

    @Test
    public void testOptimizedSolution(){
        MediumOfTwoSortedArrays motsa = new MediumOfTwoSortedArrays();

        double actual = motsa.optimizedSolution(new int[]{1, 3, 5}, new int[]{});
        Assert.assertEquals(3.0, actual, 0.0);

        actual = motsa.optimizedSolution(new int[]{1, 3, 5}, new int[]{4, 5});
        Assert.assertEquals(4.0, actual, 0.0);

        actual = motsa.optimizedSolution(new int[]{1, 3, 5}, new int[]{7, 9, 10});
        Assert.assertEquals(6.0, actual, 0.0);
    }
}

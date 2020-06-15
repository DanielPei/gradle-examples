package leetcode.demos.medium;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/19 23:52
 */

import java.util.ArrayList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * <p>
     * => 0     4       8       12      # 4     a(i+1) = a(i) + 2 *(r - 1)
     * => 1  3  5   7   9   11          # 2     b(i+1) = b(i) + 2 *(r - 1) - 2
     * => 2     6       10              # 4     c(i+1) = a(i) + 2 *(r - 1)
     * <p>
     * => 0       8
     * => 1     7 9
     * => 2   6   10
     * => 3 5     11 13
     * => 4       12
     *
     * @param s
     * @param numRows
     * @return
     */
    public String solution(String s, int numRows) {
        if (numRows == 1 || s == null) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        ArrayList<StringBuilder> row_indexes_map = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            row_indexes_map.add(new StringBuilder());
        }

        int row_id = 0;
        int delta = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            row_indexes_map.get(row_id).append(c);
            row_id = row_id + delta;

            if (row_id == -1 || row_id == numRows) {
                delta = delta * (-1);
                row_id += delta * 2;
            }

        }

        for (StringBuilder row : row_indexes_map) {
            result.append(row);
        }
        return result.toString();
    }

    /**
     * PAYPALISHIRING
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.solution(s, 3));
    }
}

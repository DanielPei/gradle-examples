package leetcode.demos.hard;

import java.util.ArrayList;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/17 12:17
 */
public class MediumOfTwoSortedArrays {

    public double optimizedSolution(int[] sorted_num_array_left, int[] sorted_num_array_right) {
        /**
         * Split all numbers into two parts holds same count numbers( or just have 1 diff).
         *
         * time cost : O(log(m+n))
         * space cost : O(1)
         *
         * - Left : sorted_num_array_left[ 0, i-1]  + sorted_num_array_right[0,j-1]
         * - Right : sorted_num_array_left[ i, n-1] + sorted_num_array_right[ j, m-1]
         *
         * i + j = ( n - i ) + (m - j )  or (n-i) + (m-j) +1;
         *
         * => j = ( n + m + i ) / 2 + i
         * - to make sure j is positive, we need m >= n as i is in range [0,n];
         *
         * search for the final i in [0, n], until we get :
         * 1. sorted_num_array_left[i-1] <  sorted_num_array_right[j];
         * 2. sorted_num_array_right[j-1] < sorted_num_array_left[i];
         * 3. edge value :
         *  - i = 0, j = m; => sorted_num_array_left[i-1] does not exist.
         *  - i = n, j = 0; => sorted_num_array_right[j-1] does not exist.
         *
         * During the loop, we may encounter these situations :
         * 1. sorted_num_array_left[i-1] > sorted_num_array_right[j] => we need to decrease i;
         * 2. sorted_num_array_left[i] < sorted_num_array_right[j-1] => we need to increase i;
         *
         * Finally,
         * if (n + m) is odd:
         *      medium = max( sorted_num_array_left[i-1], sorted_num_array_right[j-1])  ;
         * else:
         *      medium =
         *          ( max( sorted_num_array_left[i-1], sorted_num_array_right[j-1])
         *          + min( sorted_num_array_left[i], sorted_num_array_right[j])
         *          ) / 2
         *
         */
        double result = 0.0;

        int n = sorted_num_array_left.length, m = sorted_num_array_right.length;

        if (n > m) {
            int[] tmp_array = sorted_num_array_left;
            sorted_num_array_left = sorted_num_array_right;
            sorted_num_array_right = tmp_array;

            int tmp = n;
            n = m;
            m = tmp;
        }

        int iMin = 0, iMax = n, midLen = (n + m + 1) / 2;

        while (iMin <= iMax){
            int i = (iMax + iMin) / 2;
            int j = midLen - i;
            if( i > iMin && sorted_num_array_left[i-1] > sorted_num_array_right[j] ){
                iMax = i -1;
            }else if( i < iMax && sorted_num_array_left[i] < sorted_num_array_right[j-1]){
                iMin = i+1;
            }else{
                int maxLeft;
                if(i == 0){
                    maxLeft = sorted_num_array_right[j-1];
                }else if(j==0){
                    maxLeft = sorted_num_array_left[i-1];
                }else{
                    maxLeft = Math.max(sorted_num_array_left[i-1],sorted_num_array_right[j-1]);
                }
                if( (m + n ) % 2 == 1){
                    return maxLeft;
                }

                int maxRight = 0;
                if(i == n){
                    maxRight = sorted_num_array_right[j];
                }else if (j == m){
                    maxRight = sorted_num_array_left[i];
                }else{
                    maxRight = Math.min(sorted_num_array_left[i], sorted_num_array_right[j]);
                }
                return (maxLeft + maxRight)/2.0;
            }
        }

        return result;
    }

    public double mediumOfTwoSortedArrays(int[] nums1, int[] nums2) {
        /**
         * Combine two ordered arrays into one ordered array.
         *
         * Time cost : O(m+n)
         * Space cost : O(m+n)
         */
        double result = 0.0d;

        int len_left = nums1.length;
        int len_right = nums2.length;

        int total_len = len_left + len_right;
        int[] ordered_whole_array = new int[total_len];

        ArrayList<Integer> medium_index = new ArrayList<>();

        if (total_len % 2 == 0) {
            medium_index.add(total_len / 2);
            medium_index.add(total_len / 2 - 1);
        } else {
            medium_index.add((total_len + 1) / 2 - 1);
        }

        if (len_left == 0) {
            ordered_whole_array = nums2;
        } else if (len_right == 0) {
            ordered_whole_array = nums1;
        } else {
            int index_left = 0, index_right = 0, whole_index = 0;

            while (index_left < len_left && index_right < len_right) {
                if (nums1[index_left] < nums2[index_right]) {
                    ordered_whole_array[whole_index] = nums1[index_left];
                    index_left++;
                    if (index_left == len_left) {
                        for (int i = index_right; i < len_right; i++) {
                            ordered_whole_array[++whole_index] = nums2[i];
                        }
                        break;
                    }
                } else {
                    ordered_whole_array[whole_index] = nums2[index_right];
                    index_right++;
                    if (index_right == len_right) {
                        for (int i = index_left; i < len_left; i++) {
                            ordered_whole_array[++whole_index] = nums1[i];
                        }
                        break;
                    }
                }
                whole_index++;
            }
        }
        for (int i : ordered_whole_array) {
            System.out.println(i);
        }

        for (Integer i : medium_index) {
            System.out.println("Medium index: " + i.toString());
            result += ordered_whole_array[i];
        }
        result /= medium_index.size();

        return result;
    }

}

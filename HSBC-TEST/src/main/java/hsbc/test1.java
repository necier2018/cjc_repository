package hsbc;

import java.util.*;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some
 * or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */
public class test1 {

    public int increasingArrayCount(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        HashSet<Integer> set = new HashSet<Integer>(list);
        if (set.size() <= 1) {
            return 1;
        }
        List<Integer> result = new ArrayList<Integer>();
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
                result.add(temp);
            }else {
                temp = arr[i];
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        int [] arr = {10,9,2,5,3,7,101,18};
        test1 test1 = new test1();
        int i = test1.increasingArrayCount(arr);
        System.out.println(i);
    }
}

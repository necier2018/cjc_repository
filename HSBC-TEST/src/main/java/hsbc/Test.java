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
public class Test {

    public static List<String> processString1(String s) {
        List<String> result = new ArrayList<String>();
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < s.length(); ) {
                int j = i;
                char current = s.charAt(i);
                // 找到连续相同字符的结束位置
                while (j < s.length() && s.charAt(j) == current) {
                    j++;
                }
                int count = j - i;
                if (count >= 3) {
                    // 删除连续字符并生成新字符串
                    s = s.substring(0, i) + s.substring(j);
                    result.add(s);
                    changed = true;
                    break; // 每次只处理第一个连续段
                } else {
                    i = j; // 移动到下一个不同字符
                }
            }
        } while (changed);
        return result;
    }


    public static List<String> processString2(String s) {
        List<String> result = new ArrayList<>();
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < s.length(); ) {
                int j = i;
                char current = s.charAt(i);
                while (j < s.length() && s.charAt(j) == current) {
                    j++;
                }
                int count = j - i;
                if (count >= 3) {
                    String originalSegment = s.substring(i, j);
                    String replacementStr;
                    if (current == 'a') {
                        replacementStr = "";
                    } else {
                        replacementStr = String.valueOf((char) (current - 1));
                    }
                    String newStr = s.substring(0, i) + replacementStr + s.substring(j);
                    // 构建步骤描述
                    String step;
                    if (replacementStr.isEmpty()) {
                        step = "-> " + newStr + ", " + originalSegment + " is removed";
                    } else {
                        step = "-> " + newStr + ", " + originalSegment + " is replaced by " + replacementStr;
                    }
                    result.add(step);
                    s = newStr;
                    changed = true;
                    break; // 每次处理第一个连续段后重新扫描
                } else {
                    i = j;
                }
            }
        } while (changed);
        return result;
    }


    public static void main(String[] args) {
        String input = "aabcccbbad";
        //List<String> steps = processString1(input);
        List<String> steps = processString2(input);
        System.out.println("输入: " + input);
        System.out.println("输出:");
        for (String step : steps) {
            System.out.println("-> " + step);
        }
    }
}

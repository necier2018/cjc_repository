package hsbc;

import java.util.*;

public class Test {

    /**
     * Stage1
     * @param s
     * @return
     */
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

    /**
     * Stage2
     * @param s
     * @return
     */
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

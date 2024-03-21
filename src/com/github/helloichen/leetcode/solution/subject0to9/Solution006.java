package com.github.helloichen.leetcode.solution.subject0to9;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/">6. Z 字形变换</a>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * @author iChen
 */
public class Solution006 {
    /**
     * 这就需要我们转变思路，我们需要一层一层的剥开这个字符串。如果横着剥开，那就是数学法，找通项公式，如果竖着按列剥开，事情就简单了很多，我们在按列读取的时候，可以为每一行维护一个字符串，读到哪一行就在后面append字串。
     * 判断在哪一行append字串的方式也很简单，我们设置两个边界，在增长到或者减小到某个边界的时候，读取行的顺序进行反转，不断地从上到下，再从下到上读取，直到取完所有字串。
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1 || s.length() < numRows) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        // 行数
        int layer = 0;
        // 是否反像
        boolean turn = false;
        for (int i = 0; i < s.length(); i++) {
            if (!turn) {
                stringBuilders[layer++].append(s.charAt(i));
            } else {
                stringBuilders[layer--].append(s.charAt(i));
            }
            if (layer == -1 || layer == numRows) {
                layer = layer == -1 ? 1 : layer - 2;
                turn = !turn;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : stringBuilders) {
            result.append(sb.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        Solution006 solution006 = new Solution006();
        String convert = solution006.convert(str, 4);
        System.out.println(convert);
        System.out.println("PINALSIGYAHRPI".equals(convert));
    }
}

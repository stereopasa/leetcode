package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * <br>P    A   H   N
 * <br>A P  L S I I G
 * <br>Y    I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * See <a href="https://leetcode.com/problems/zigzag-conversion/">https://leetcode.com/problems/zigzag-conversion/</a>
 */
public class ZigZagConversion
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }


    /**
     * <pre>n=numRows
     * <pre>Δ=2n-2    1                           2n-1                         4n-3
     * <pre>Δ=        2                     2n-2  2n                    4n-4   4n-2
     * <pre>Δ=        3               2n-3        2n+1              4n-5       .
     * <pre>Δ=        .           .               .               .            .
     * <pre>Δ=        .       n+2                 .           3n               .
     * <pre>Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
     * <pre>Δ=2n-2    n                           3n-2                         5n-4
     */
    private static class Solution
    {
        public String convert(String s, int numRows)
        {
            StringBuilder sb = new StringBuilder();
            if (numRows == 1)
                return s;
            int step1, step2;
            int len = s.length();
            for (int i = 0; i < numRows; ++i)
            {
                step1 = (numRows - i - 1) * 2;
                step2 = (i) * 2;
                int pos = i;
                if (pos < len)
                    sb.append(s.charAt(pos));
                while (true)
                {
                    pos += step1;
                    if (pos >= len)
                        break;
                    if (step1 > 0)
                        sb.append(s.charAt(pos));
                    pos += step2;
                    if (pos >= len)
                        break;
                    if (step2 > 0)
                        sb.append(s.charAt(pos));
                }
            }
            return sb.toString();
        }

        public String convertWrong(String s, int numRows)
        {
            String result = null;

            List<Character> chars = s.chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toList());

            System.out.println(chars);

            List<LinkedList<Character>> list = new ArrayList<>();
            int start = 0;
            while (start < s.length())
            {
                int end = start + (list.size() % 2 == 0 ? numRows : 1);
                end = end < s.length() ? end : s.length();
                list.add(
                        new LinkedList<>(
                                chars.subList(start, end)
                        )
                );
                start = end;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++)
            {
                for (LinkedList<Character> sublist : list)
                {

                }
            }

            System.out.println(list);

//            List<LinkedList<Character>> list = new ArrayList<>();
//
//            int start, end;
//
//            start = 0;
//            end = start + (list.size() % 2 == 0 ? numRows : 1);
//            list.add(Arrays.copyOfRange())

            return result;
        }
    }
}

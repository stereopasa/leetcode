package medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * See <a href="https://leetcode.com/problems/integer-to-roman/">https://leetcode.com/problems/integer-to-roman/</a>
 */
public class IntegerToRoman
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        System.out.printf("%-4d >>  %s%n", 1, s.intToRoman(1));
        System.out.printf("%-4d >>  %s%n", 3, s.intToRoman(3));
        System.out.printf("%-4d >>  %s%n", 4, s.intToRoman(4));
        System.out.printf("%-4d >>  %s%n", 5, s.intToRoman(5));
        System.out.printf("%-4d >>  %s%n", 90, s.intToRoman(90));
        System.out.printf("%-4d >>  %s%n", 100, s.intToRoman(100));
        System.out.printf("%-4d >>  %s%n", 3999, s.intToRoman(3999));


        System.out.printf("%-4d >>  %s%n", 1, s.intToRoman4(1));
        System.out.printf("%-4d >>  %s%n", 3, s.intToRoman4(3));
        System.out.printf("%-4d >>  %s%n", 4, s.intToRoman4(4));
        System.out.printf("%-4d >>  %s%n", 5, s.intToRoman4(5));
        System.out.printf("%-4d >>  %s%n", 90, s.intToRoman4(90));
        System.out.printf("%-4d >>  %s%n", 100, s.intToRoman4(100));
        System.out.printf("%-4d >>  %s%n", 3999, s.intToRoman4(3999));
    }

    private static class Solution
    {
        // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
        static Map<Integer, Character> map = new LinkedHashMap<>();

        static
        {
            map.put(1000, 'M');
            map.put(500, 'D');
            map.put(100, 'C');
            map.put(50, 'L');
            map.put(10, 'X');
            map.put(5, 'V');
            map.put(1, 'I');
        }


        /**
         * does not work
         * @param num
         * @return
         */
        public String intToRoman(int num)
        {
            StringBuilder sb = new StringBuilder();
            while (num > 0)
            {
                int prev = 0;
                for (Integer current : map.keySet())
                {
                    if (current < prev && (prev - current) <= num)
                    {
                        num -= (prev - current);
                        sb.append("" + map.get(current) + map.get(prev));
                        break;
                    } else if (current <= num)
                    {
                        num -= current;
                        sb.append(map.get(current));
                        break;
                    } else
                    {
                        prev = current;
                    }
                }
            }
            return sb.toString();
        }

        public static String intToRoman2(int num)
        {
            String M[] = {"", "M", "MM", "MMM"};
            String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
        }

        public static String intToRoman3(int num)
        {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < values.length; i++)
            {
                while (num >= values[i])
                {
                    num -= values[i];
                    sb.append(strs[i]);
                }
            }
            return sb.toString();
        }

        public static String intToRoman4(int num)
        {
            StringBuilder result = new StringBuilder();
            int base[] = {1000, 500, 100, 50, 10, 5, 1, 0};
            char baseC[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
            int basen = 0;
            while (num > 0)
            {
                if (basen % 2 == 0 && num / base[basen] == 4)
                {
                    result.append(baseC[basen]);
                    result.append(baseC[basen - 1]);
                    num -= base[basen] * 4;
                } else if (num >= base[basen])
                {
                    result.append(baseC[basen]);
                    num -= base[basen];
                } else if (basen % 2 == 0 && num / base[basen + 2] == 9)
                {
                    result.append(baseC[basen + 2]);
                    result.append(baseC[basen]);
                    num -= base[basen + 2] * 9;
                } else
                {
                    basen++;
                }
            }
            return result.toString();
        }
    }
}

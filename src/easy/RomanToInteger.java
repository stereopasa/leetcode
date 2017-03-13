package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * See <a href="https://leetcode.com/problems/roman-to-integer/">https://leetcode.com/problems/roman-to-integer/</a>
 */
public class RomanToInteger
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.printf("%s >>  %-4d%n", "MMMCMXCIX", s.romanToInt("MMMCMXCIX"));
        System.out.printf("%s >>  %-4d%n", "I", s.romanToInt("I"));
        System.out.printf("%s >>  %-4d%n", "V", s.romanToInt("V"));
        System.out.printf("%s >>  %-4d%n", "DCXXI", s.romanToInt("DCXXI"));
    }

    // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
    private static class Solution
    {
        static Map<Character, Integer> map = new HashMap<>();

        static
        {
            map.put('M', 1000);
            map.put('D', 500);
            map.put('C', 100);
            map.put('L', 50);
            map.put('X', 10);
            map.put('V', 5);
            map.put('I', 1);
        }

        public int romanToInt(String s)
        {
            int res = 0;
            int len = s.length();
            for (int i = 0; i < len; i++)
            {
                char ch = s.charAt(i);
                if (i + 1 < len && map.get(s.charAt(i + 1)) > map.get(ch))
                {
                    res += map.get(s.charAt(i + 1)) - map.get(ch);
                    i++;
                } else
                {
                    res += map.get(ch);
                }
            }
            return res;
        }

        public int romanToInt2(String s)
        {
            int res = 0;
            for (int i = s.length() - 1; i >= 0; i--)
            {
                char c = s.charAt(i);
                switch (c)
                {
                    case 'I':
                        res += (res >= 5 ? -1 : 1);
                        break;
                    case 'V':
                        res += 5;
                        break;
                    case 'X':
                        res += 10 * (res >= 50 ? -1 : 1);
                        break;
                    case 'L':
                        res += 50;
                        break;
                    case 'C':
                        res += 100 * (res >= 500 ? -1 : 1);
                        break;
                    case 'D':
                        res += 500;
                        break;
                    case 'M':
                        res += 1000;
                        break;
                }
            }
            return res;
        }

        public int romanToInt3(String s)
        {
            //：Ⅰ（1）Ⅴ（5）Ⅹ（10）L（50）C（100）D（500）M（1000）
            //eg：Ⅲ=3,Ⅳ=4,Ⅵ=6,ⅩⅨ=19,ⅩⅩ=20,ⅩLⅤ=45,MCMⅩⅩC=1980
            //"DCXXI"

            if (s == null || s.length() == 0) return 0;
            int len = s.length();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int result = map.get(s.charAt(len - 1));
            int pivot = result;
            for (int i = len - 2; i >= 0; i--)
            {
                int curr = map.get(s.charAt(i));
                if (curr >= pivot)
                {
                    result += curr;
                } else
                {
                    result -= curr;
                }
                pivot = curr;
            }
            return result;
        }
    }
}

package easy;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * See <a href="https://leetcode.com/problems/string-to-integer-atoi/">https://leetcode.com/problems/string-to-integer-atoi/</a>
 */
public class StringToInteger
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-123"));
        System.out.println(s.myAtoi("+"));
        System.out.println(s.myAtoi("+-2"));
        System.out.println(s.myAtoi("+2"));
        System.out.println(s.myAtoi("    010"));
        System.out.println(s.myAtoi("  -0012a42"));
    }

    private static class Solution
    {
        public int myAtoi(String str)
        {
            if (str == null || str.length() == 0)
                return 0;
            int i = 0, len = str.length();
            int num = 0, sign = 1, bound = Integer.MAX_VALUE / 10;

            // 1. Remove whitespace
            while (i < len && str.charAt(i) == ' ')
                i++;

            // 2. Handle signs
            if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            {
                sign = str.charAt(i++) == '-' ? -1 : 1;
            }

            // 3. Convert number
            while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {
                int digit = str.charAt(i++) - '0';
                boolean overlow = (num == bound && digit >= 8) || num > bound;
                if (overlow)
                    return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                num = num * 10 + digit;
            }

            return sign * num;
        }

        public int myAtoiNaive(String str)
        {
            int res = 0;
//            char[] chars = str.trim().toCharArray();
            char[] chars = str.toCharArray();
            int sign = 1;
            for (int i = 0; i < chars.length; i++)
            {
                char ch = chars[i];
                int d = Character.digit(ch, 10);

                if (res == 0 && ch == ' ')
                    continue;
                else if (res == 0 && (ch == '-' || ch == '+'))
                {
                    sign = ch == '-' ? -1 : 1;
                    continue;
                }

                if (d != -1)
                {
                    if (d == 0 && res == 0)
                        continue;
                    res = res * 10 + d;
                } else if (res > 0)
                    break;
            }

            return sign * res;
        }
    }
}

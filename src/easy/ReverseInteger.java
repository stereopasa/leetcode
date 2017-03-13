package easy;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * See <a href="https://leetcode.com/problems/reverse-integer/">https://leetcode.com/problems/reverse-integer/</a>
 */
public class ReverseInteger
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int e1 = 123;
        int e2 = -123;

        System.out.printf("%+03d\t%+05d\n", e1, s.reverse(e1));
        System.out.printf("%+03d\t%+05d\n", e2, s.reverse(e2));
        System.out.printf("%+03d\t%+05d\n", Integer.MAX_VALUE / 10, s.reverse(Integer.MAX_VALUE / 10));

    }

    private static class Solution
    {
        public int reverse(int x)
        {
            int res = 0;
            while (x != 0)
            {
                int tmpRes = res * 10 + (x % 10);
                if ((tmpRes - x % 10) / 10 != res)
                    return 0;
                res = tmpRes;
                x /= 10;
            }
            return res;
        }
    }

    static String intToString(int number, int groupSize)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 15; i >= 0; i--)
        {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0)
                result.append(" ");
        }
        return result.toString();
    }
}

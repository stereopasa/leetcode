package easy;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * <br/>
 * Given a = 1 and b = 2, return 3.
 * <p>
 * See <a href="https://leetcode.com/problems/sum-of-two-integers/">https://leetcode.com/problems/sum-of-two-integers/</a>
 */
public class SumOfTwoIntegers
{
    // https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
    public static void main(String[] args)
    {
        Solution s = new Solution();

        System.out.println("10:\t\t" + intToString(10, 4));
        System.out.println("15:\t\t" + intToString(15, 4));
        System.out.println(s.getSum(10, 15));
    }

    private static class Solution
    {
        public int getSum(int a, int b)
        {
            System.out.println("***");
            if (b == 0)
                return a;
            int carry = (a & b) << 1;
            System.out.println("carry:\t" + intToString(carry, 4));

            int sum = a ^ b;
            System.out.println("sum:\t" + intToString(sum, 4));

            return getSum(sum, carry);
        }
    }

    private static String intToString(int number, int groupSize)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 15; i >= 0; i--)
        {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0)
                result.append(" ");
        }
//        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }
}

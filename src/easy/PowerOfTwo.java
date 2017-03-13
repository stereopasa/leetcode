package easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * See <a href="https://leetcode.com/problems/power-of-two/">https://leetcode.com/problems/power-of-two/</a>
 */
public class PowerOfTwo
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int intToCheck = 8;
        System.out.println(s.isPowerOfTwo(intToCheck));
    }

    private static class Solution
    {
        public boolean isPowerOfTwo(int n)
        {
            return (Math.log10(n) / Math.log10(2)) % 1 == 0;
//            return Integer.toString(n, 2).matches("^10*$");
        }
    }
}

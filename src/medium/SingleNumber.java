package medium;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * See <a href="link">text</a>
 */
public class SingleNumber
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        int a = 10;
        int b = 15;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }

    private static class Solution
    {
        public int singleNumber(int[] nums)
        {
            int res = 0;
            for (int num : nums)
                res ^= num;

            return res;
        }
    }
}

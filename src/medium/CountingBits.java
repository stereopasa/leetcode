package medium;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * <p>
 * See <a href="https://leetcode.com/problems/counting-bits/">https://leetcode.com/problems/counting-bits/</a>
 */
public class CountingBits
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(20)));
    }

    private static class Solution
    {
        public int[] countBits(int num)
        {
            int[] result = new int[num + 1];

            int p = 1; //p tracks the index for number x
            int pow = 1;
            for (int i = 1; i <= num; i++)
            {
                if (i == pow)
                {
                    result[i] = 1;
                    pow <<= 1;
                    p = 1;
                } else
                {
                    result[i] = result[p] + 1;
                    p++;
                }
            }
            return result;
        }


    }
}

package easy;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * <b>Example:</b>
 * <pre>Given input array nums = [3,2,2,3], val = 3</pre>
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * See <a href="https://leetcode.com/problems/remove-element/">https://leetcode.com/problems/remove-element/</a>
 */
public class RemoveElement
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        int[] e1 = {3, 2, 2, 3};

        System.out.printf("%d %s -> %d %s", 3, Arrays.toString(e1), s.removeElement(e1, 3), Arrays.toString(e1));
    }

    private static class Solution
    {
        public int removeElement(int[] nums, int val)
        {
            int res = 0;
            for (int i = 0; i < nums.length; i++)
            {
                if (nums[i] != val)
                {
                    nums[res++] = nums[i];
                }
            }

            return res;
        }

        public int removeElement2(int[] nums, int val)
        {
            int i = 0;
            int n = nums.length;
            while (i < n)
            {
                if (nums[i] == val)
                {
                    nums[i] = nums[n - 1];
                    // reduce array size by one
                    n--;
                } else
                {
                    i++;
                }
            }
            return n;
        }
    }
}

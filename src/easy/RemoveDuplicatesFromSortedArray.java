package easy;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * <pre>Given input array nums = [1,1,2],</pre>
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 * See <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">https://leetcode.com/problems/remove-duplicates-from-sorted-array/</a>
 */
public class RemoveDuplicatesFromSortedArray
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] e1 = {1, 1, 2};
        System.out.printf("%d %s%n", s.removeDuplicates(e1), Arrays.toString(e1));
        System.out.printf("%d %s%n", s.removeDuplicates2(e1), Arrays.toString(e1));
    }

    private static class Solution
    {
        public int removeDuplicates(int[] nums)
        {
            int res = 0;
            for (int i = 0; i < nums.length; i++)
            {
                while (i + 1 < nums.length && nums[i] == nums[i + 1])
                {
                    i++;
                }
                nums[res++] = nums[i];
            }
            return res;
        }

        public int removeDuplicates2(int nums[])
        {
            int n = nums.length;

            if (n < 2)
                return n;

            int id = 1;
            for (int i = 1; i < n; ++i)
                if (nums[i] != nums[i - 1])
                    nums[id++] = nums[i];
            return id;
        }

        public int removeDuplicatesExample(int nums[])
        {
            if (nums.length == 0)
                return 0;

            int i = 0;
            for (int j = 1; j < nums.length; j++)
            {
                if (nums[j] != nums[i])
                {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}

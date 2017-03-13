package easy;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * <b>Note:</b>
 * <pre>
 *     - You must do this in-place without making a copy of the array.
 *     - Minimize the total number of operations.
 * </pre>
 * <p>
 * See <a href="https://leetcode.com/problems/move-zeroes/">https://leetcode.com/problems/move-zeroes/</a>
 */
public class MoveZeroes
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        print(s, new int[]{0, 1, 0, 3, 12});
        print(s, new int[]{2, 1});


    }

    static void print(Solution s, int[] array)
    {
        int[] arraycopy = Arrays.copyOf(array, array.length);
        s.moveZeroes(arraycopy);
        System.out.printf("%s -> %s%n", Arrays.toString(array), Arrays.toString(arraycopy));
    }


    private static class Solution
    {
        public void moveZeroes(int[] nums)
        {
            for (int slow = 0, fast = 0; fast < nums.length; fast++)
            {
                if (nums[fast] != 0)
                {
                    swap(nums, slow++, fast);

//                    if (fast != slow)
//                        swap(nums, slow, fast);
//
//                    slow++;
                }
            }
        }

        void swap(int[] array, int i, int j)
        {
            if (i != j)
            {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
    }
}

package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] e1 = {0, 1, 3};
        int[] e2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11};

        long before = System.currentTimeMillis();
        System.out.println(s.missingNumber(e1));
        System.out.println("time: " + (System.currentTimeMillis() - before));


        before = System.currentTimeMillis();
        System.out.println(s.missingNumber(e2));
        System.out.println("time: " + (System.currentTimeMillis() - before));
    }

    private static class Solution
    {
        public int missingNumber(int[] nums)
        {
            int sum1 = Arrays.stream(nums).sum();
            int sum2 = IntStream.rangeClosed(0, nums.length).sum();
            return sum2 - sum1;
        }
    }
}

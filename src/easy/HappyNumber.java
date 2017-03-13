package easy;

import java.util.stream.IntStream;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 1^2 + 9^2 = 82<br>
 * 8^2 + 2^2 = 68<br>
 * 6^2 + 8^2 = 100<br>
 * 1^2 + 0^2 + 0^2 = 1<br>
 * <p>
 * See <a href="https://leetcode.com/problems/happy-number/">https://leetcode.com/problems/happy-number/</a>
 */
public class HappyNumber
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
//        System.out.println(s.isHappyNaive(19));
//        System.out.println(s.isHappyNaive(82));
//        System.out.println(s.isHappyNaive(81));
//        System.out.println(s.isHappyNaive(7));
        IntStream.rangeClosed(0, 1000).forEach(value -> {
            System.out.printf("%2d %b\n", value, s.isHappyNaive(value));
        });
    }

    private static class Solution
    {
        public boolean isHappyNaive(int n)
        {
            int threshold = 15;
            int counter = 0;
            int target = n;
            while (target != 1 && counter < threshold)
            {
                int sum = 0;
                while (target != 0)
                {
                    int lastDigit = target % 10;
                    sum += lastDigit * lastDigit;
                    target /= 10;
                }
                target = sum;
                counter++;
//                System.out.println(sum);
            }

            return target == 1;
        }
    }
}

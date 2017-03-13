package easy;

import java.util.stream.IntStream;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * <p>
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * See <a href="link">text</a>
 */
public class AddDigits
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        System.out.println(s.addDigitsLoopAndRecursion(38));
        System.out.println(s.addDigitsLoop(38));
        System.out.println(s.addDigits(38));

        IntStream.rangeClosed(0, 120).forEach(value -> {
            System.out.printf("%3d \t %3d %3d\n", value, s.addDigitsLoop(value), s.addDigits(value));
            if (value > 0 && (value) % 10 == 0)
                System.out.println();
        });
    }

    private static class Solution
    {
        public int addDigits(int num)
        {
            return (num - 1) % 9 + 1;
        }

        public int addDigitsLoop(int num)
        {
            while (num >= 10)
                num = (num / 10) + (num % 10);
            return num;

            //156 -> 15 + 6 = 21 -> 1 + 2;
        }

        public int addDigitsLoopAndRecursion(int num)
        {
            int sum = 0;
            while (num != 0)
            {
                sum += num % 10;
                num /= 10;
            }

            if (sum < 10)
                return sum;
            else
                return addDigitsLoopAndRecursion(sum);
        }
    }
}

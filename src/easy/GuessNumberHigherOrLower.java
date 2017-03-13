package easy;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * <p>
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * <p>
 * Return 6.
 * <p>
 * See <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">https://leetcode.com/problems/guess-number-higher-or-lower/</a>
 */
public class GuessNumberHigherOrLower
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        int n = Integer.MAX_VALUE;

        double rand = Math.random();
        s.unknownNumber = (int) (rand * n) + 1;

        long start = System.currentTimeMillis();
        System.out.println(s.guessNumber(n));
        System.out.println((System.currentTimeMillis() - start) + " millis");
    }

    /*
        The guess API is defined in the parent class GuessGame.
        @param num, your guess
        @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
        int guess(int num);
    */
    private static class Solution
    {
        static int unknownNumber;

        public int guessNumber(int n)
        {
            if (n < 2)
                return n;

            int left = 1;
            int right = n;
            while (left <= right)
            {
                int guessNumber = left + (right - left) / 2;
                int guessResult =  guess(guessNumber);
                if (guessResult > 0)
                    left = guessNumber + 1;
                else if (guessResult < 0)
                    right = guessNumber;
                else
                    return guessNumber;
            }
            return -1;
        }

        private int guess(int number)
        {
            return unknownNumber < number ? -1 : unknownNumber > number ? 1 : 0;
        }
    }
}

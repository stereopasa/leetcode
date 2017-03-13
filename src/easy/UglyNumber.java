package easy;

import java.util.*;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * See <a href="https://leetcode.com/problems/ugly-number/">https://leetcode.com/problems/ugly-number/</a>
 */
public class UglyNumber
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.isUgly(6));
        System.out.println(s.isUgly(8));
        System.out.println(s.isUgly(14));

        System.out.println(s.primeFactors(905391974));
    }

    private static class Solution
    {
        public boolean isUgly(int num)
        {
            Integer[] uglyFractors = {2, 3, 5};
            Set<Integer> uglySet = new HashSet<>(Arrays.asList(uglyFractors));

            if (num == 1)
                return true;

            for (int factor : primeFactors(num))
                if (!uglySet.contains(factor))
                    return false;

            return true;

        }

        //      This method calculate prime factor and add it to primeFactor list
        public static List<Integer> primeFactors(int numbers)
        {
            int n = numbers;
            List<Integer> factors = new ArrayList<Integer>();
            for (int i = 2; i <= n / i; i++)
            {
                while (n % i == 0)
                {
                    factors.add(i);
                    n /= i;
                }
            }
            if (n > 1)
            {
                factors.add(n);
            }
            return factors;
        }
    }
}

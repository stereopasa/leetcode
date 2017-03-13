package easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * See <a href="https://leetcode.com/problems/palindrome-number/">https://leetcode.com/problems/palindrome-number/</a>
 */
public class PalindromeNumber
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.printf("%-5d %b%n", 1, s.isPalindrome(1));
        System.out.printf("%-5d %b%n", 10, s.isPalindrome(10));
        System.out.printf("%-5d %b%n", 121, s.isPalindrome2(121));
    }

    private static class Solution
    {
        public boolean isPalindrome(int x)
        {
            String str = Integer.toString(x);

            if (str.length() < 2)
                return true;

            int left = 0;
            int right = str.length() - 1;

            while (left < right)
            {
                if (str.charAt(left++) != str.charAt(right--))
                    return false;
            }

            return true;
        }

        public boolean isPalindrome2(int x)
        {
            if (x < 0 || (x != 0 && x % 10 == 0)) return false;
            int rev = 0;
            while (x > rev)
            {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            return (x == rev || x == rev / 10);
        }
    }
}

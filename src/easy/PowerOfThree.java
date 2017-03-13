package easy;

public class PowerOfThree
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int intToCheck = 5;
        System.out.printf("is it %d a power of 3? %b", intToCheck, s.isPowerOfThree(intToCheck));
    }

    private static class Solution
    {
        public boolean isPowerOfThree(int n)
        {
//            return Integer.toString(n, 3).matches("^10*$");
            return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        }
    }
}

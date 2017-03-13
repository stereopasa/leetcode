package easy;

public class NumberOf1Bits
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(100));
        System.out.println(s.hammingWeight(11));
        System.out.println(s.hammingWeight(2));
        System.out.println(s.hammingWeight(2_147_483_648L));
    }

    private static class Solution
    {
        // you need to treat n as an unsigned value
        public int hammingWeight(long n)
        {
            int count = 0;
            for (int i = 0; i < 32; ++i)
            {
                if (((n >>> i) & 1) == 1)
                {
                    ++count;
                }
            }
            return count;
        }

    }
}

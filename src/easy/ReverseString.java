package easy;

public class ReverseString
{
    public static void main(String[] args)
    {
//        Given s = "hello", return "olleh"
        String e1 = "hello";

        Solution s = new Solution();
        System.out.println(s.reverseString(e1));

    }

    private static class Solution
    {
        public String reverseString(String s)
        {
            char[] res = new char[s.length()];
            for (int i = 0; i < s.length(); i++)
            {
                res[i] = s.charAt(s.length() - i - 1);
            }

            return new String(res);
        }
    }
}

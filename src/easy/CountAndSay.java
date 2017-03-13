package easy;

import java.util.Arrays;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <pre>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * </pre>
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 * <p>
 * See <a href="https://leetcode.com/problems/count-and-say/">https://leetcode.com/problems/count-and-say/</a>
 */
public class CountAndSay
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.countAndSay(9));
        System.out.println(s.countAndSayMine(9));
        System.out.println(s.countAndSay(2));
    }

    private static class Solution
    {
        public String countAndSayMine(int n)
        {
            StringBuilder result = new StringBuilder();

            StringBuilder currentSequence = new StringBuilder("1");

            result.append(currentSequence);

            for (int i = 1; i < n; i++)
            {
                int counter = 0;
                char digit = currentSequence.charAt(0);
                String tmp = new String(currentSequence);
                currentSequence.setLength(0);
                for (int j = 0; j < tmp.length(); j++)
                {
                    char last = tmp.charAt(j);
                    if (last != digit)
                    {
                        currentSequence.append(counter).append(digit);
                        counter = 0;
                    }
                    digit = last;
                    counter++;
                }
                currentSequence.append(counter).append(digit);
                result.append(", ").append(currentSequence);
            }

            return currentSequence.toString();
        }

        public String countAndSay(int n) {
            StringBuilder curr=new StringBuilder("1");
            StringBuilder prev;
            int count;
            char say;
            for (int i=1;i<n;i++){
                prev=curr;
                curr=new StringBuilder();
                count=1;
                say=prev.charAt(0);

                for (int j=1,len=prev.length();j<len;j++){
                    if (prev.charAt(j)!=say){
                        curr.append(count).append(say);
                        count=1;
                        say=prev.charAt(j);
                    }
                    else count++;
                }
                curr.append(count).append(say);
            }
            return curr.toString();

        }
    }
}

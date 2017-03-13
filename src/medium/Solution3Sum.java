package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3Sum
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] input = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(input));

        int[] input2 = {-1, -1, -1, 5, 4, 1, 1, 2};
        System.out.println(s.threeSum(input2));
    }

    /**
     * For example, given array S = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    private static class Solution
    {
        public List<List<Integer>> threeSum(int[] num)
        {
            List<List<Integer>> result = new ArrayList<>();
            if (num.length < 3)
            {
                return result;
            }

            Arrays.sort(num);

            for (int i = 0; i < num.length - 2; i++)
            {
                if (i != 0 && num[i] == num[i - 1])
                {
                    continue;
                }
                int left = i + 1;
                int right = num.length - 1;

                while (left < right)
                {
                    int sum = num[i] + num[left] + num[right];
                    if (sum < 0)
                    {
                        left++;
                    } else if (sum > 0)
                    {
                        right--;
                    } else
                    {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[left]);
                        temp.add(num[right]);
                        result.add(temp);
                        do
                        {
                            left++;
                        } while (left < right && num[left] == num[left - 1]);
                        do
                        {
                            right--;
                        } while (right > left && num[right] == num[right + 1]);
                    }
                }
            }
            return result;
        }

    }
}

package easy;

import java.util.Arrays;

public class TwoSum
{
    public static void main(String[] args)
    {
//        Given nums = [2, 7, 11, 15], target = 9,
//
//            Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

        Solution s = new Solution();

        int[] e = {2, 7, 11, 15};

        System.out.println(
                Arrays.toString(s.twoSum(e, 9))
        );
    }

    private static class Solution
    {
        public int[] twoSum(int[] nums, int target)
        {
//            List<Integer> list = Arrays.stream(nums)
//                    .boxed()
//                    .collect(Collectors.toList());
//
//            for (Integer element : list)
//            {
//                int idx1 = list.indexOf(element);
//                if (list.contains(target - element))
//                {
//                    int[] res = new int[2];
//                    res[0] = list.indexOf(element);
//                    res[1] = list.indexOf(target - element);
//                    return res;
//                }
//            }

            for (int i = 0; i < nums.length; i++)
            {
                for (int j = 0; j < nums.length; j++)
                {
                    if (j != i && nums[i] + nums[j] == target)
                    {
                        int[] result = {i, j};
                        return result;
                    }
                }
            }

            return null;
        }
    }
}

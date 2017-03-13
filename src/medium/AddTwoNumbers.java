package medium;

import utils.ListUtils.ListNodeBuilder;

import static utils.ListUtils.ListNode;
import static utils.ListUtils.print;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <br/><br/>
 * See <a href="https://leetcode.com/problems/add-two-numbers/">https://leetcode.com/problems/add-two-numbers/</a>
 */

public class AddTwoNumbers
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        ListNode a = new ListNodeBuilder().add(2).add(4).add(3).build();
        ListNode b = new ListNodeBuilder().add(5).add(6).add(4).build();

        print(a);
        print(b);

        a = new ListNode(9);
        b = new ListNodeBuilder().add(1).add(9).add(9).add(9).add(9).add(9).add(9).add(9).add(9).add(9).build();

        print(a);
        print(b);
        print(s.addTwoNumbers(a, b));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private static class Solution
    {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2)
        {
            ListNode head = null;
            ListNode iter = null;

            int carry = 0;

            do
            {
                int sum = 0;
                if (l1 != null)
                {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null)
                {
                    sum += l2.val;
                    l2 = l2.next;
                }

                int value = sum + carry;

                ListNode newNode = new ListNode(value % 10);
                if (head == null)
                {
                    iter = head = newNode;
                } else
                {
                    iter.next = newNode;
                    iter = iter.next;
                }

                carry = value / 10;
            } while (l1 != null || l2 != null || carry > 0);

            return head;
        }
    }
}

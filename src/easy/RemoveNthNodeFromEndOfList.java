package easy;

import utils.ListUtils;
import utils.ListUtils.ListNodeBuilder;

import java.util.ArrayList;
import java.util.List;

import static utils.ListUtils.ListNode;
import static utils.ListUtils.print;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <pre>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * </pre>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <b>Note:</b>
 * Given n will always be valid.
 * <p>
 * Try to do this in one pass.
 * <p>
 * See <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">https://leetcode.com/problems/remove-nth-node-from-end-of-list/</a>
 */
public class RemoveNthNodeFromEndOfList
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        ListNode head = new ListNodeBuilder().add(1).add(2).add(3).add(4).add(5).build();

        print(head);

        s.removeNthFromEnd2(head, 2);

        print(head);

        head = new ListNode(1);
        head = s.removeNthFromEnd(head, 1);
        print(head);

        head = new ListNodeBuilder().add(1).add(2).build();
        print(head);
        s.removeNthFromEnd(head, 2);
        print(head);
    }

    private static class Solution
    {
        public ListNode removeNthFromEnd(ListNode head, int n)
        {
            ListNode iter = head;
            List<ListNode> list = new ArrayList<>();
            while (iter != null)
            {
                list.add(iter);
                iter = iter.next;
            }
            int len = list.size();
            if (len < 2)
                return null;

            ListNode prev = len - n >= 0 ? list.get(len - n) : null;
            ListNode next = len - n + 2 < len ? list.get(len - n + 2) : null;

            prev.next = next;

            return head;
        }

        /**
         * A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward, to maintain a gap of n between the two pointers and then move both at the same speed. Finally, when the fast pointer reaches the end, the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.
         * <p>
         * Since the question gives that n is valid, not too many checks have to be put in place. Otherwise, this would be necessary.
         *
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd2(ListNode head, int n)
        {

            ListNode start = new ListNode(0);
            ListNode slow = start, fast = start;
            slow.next = head;

            //Move fast in front so that the gap between slow and fast becomes n
            for (int i = 1; i <= n + 1; i++)
            {
                fast = fast.next;
            }
            //Move fast to the end, maintaining the gap
            while (fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
            //Skip the desired node
            slow.next = slow.next.next;
            return start.next;
        }
    }
}
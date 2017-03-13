package utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils
{
    public static class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int x)
        {
            val = x;
        }
    }

    public static class ListNodeBuilder
    {
        private List<ListNode> values = new ArrayList<>();

        public ListNodeBuilder add(int value)
        {
            values.add(new ListNode(value));
            return this;
        }

        public ListNode build()
        {
            ListNode head = new ListNode(-1);
            ListNode runner = head;
            for (ListNode node : values)
            {
                runner.next = new ListNode(node.val);
                runner = runner.next;
            }

            return head.next;
        }

    }

    public static void print(ListNode node)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null)
        {
            sb.append(node.val);
            node = node.next;

            if (node != null)
                sb.append(" -> ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}

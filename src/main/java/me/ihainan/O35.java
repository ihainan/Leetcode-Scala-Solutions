package me.ihainan;

import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class O35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new java.util.HashMap<>();
        Node dummy = new Node(0);
        Node p = dummy, q = head;
        while (q != null) {
            Node c = new Node(q.val);
            map.put(q, c);
            p.next = c;
            p = c;
            q = q.next;
        }

        p = dummy.next;
        q = head;
        while (q != null) {
            if (q.random == null) p.random = null;
            else p.random = map.get(q.random);
            p = p.next;
            q = q.next;
        }

        return dummy.next;
    }
}
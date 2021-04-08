package me.ihainan;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class O68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        else if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
        else if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}
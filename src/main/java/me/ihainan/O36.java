package me.ihainan;

/*
// Definition for a TreeNode.
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val,TreeNode _left,TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class O36 {
    static class HeadAndTail {
        TreeNode head;
        TreeNode tail;

        public HeadAndTail(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        HeadAndTail hAndT = visit(root);
        if (hAndT == null) return null;
        else {
            hAndT.tail.right = hAndT.head;
            hAndT.head.left = hAndT.tail;
            return hAndT.head;
        }
    }

    public HeadAndTail visit(TreeNode root) {
        if (root == null) return null;
        HeadAndTail left = visit(root.left);
        HeadAndTail right = visit(root.right);
        TreeNode head = null, tail = null;
        root.left = null;
        root.right = null;
        if (left == null) {
            head = root;
        } else {
            head = left.head;
            left.tail.right = root;
            root.left = left.tail;
        }

        if (right == null) {
            tail = root;
        } else {
            tail = right.tail;
            root.right = right.head;
            right.head.left = root;
        }

        return new HeadAndTail(head, tail);
    }

}
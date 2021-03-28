package me.ihainan;

public class TreeNode {
    int value;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int _value) {
        this.value = _value;
    }

    public TreeNode(int _value, TreeNode left, TreeNode right) {
        this.value = _value;
        this.left = left;
        this.right = right;
    }
}

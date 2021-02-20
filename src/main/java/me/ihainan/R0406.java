package me.ihainan;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class R0406 {
  private boolean flag = false;
  private TreeNode ans = null;

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    flag = false;
    ans = null;
    solve(root, p);
    return ans;
  }

  public void solve(TreeNode root, TreeNode p) {
    if (root != null && ans == null) {
      solve(root.left, p);
      if (flag && ans == null) ans = root;
      else if (p == root) flag = true;
      solve(root.right, p);
    }
  }
}
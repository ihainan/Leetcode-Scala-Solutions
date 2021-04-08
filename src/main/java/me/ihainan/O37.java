package me.ihainan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class O37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) return "";
        else {
            queue.addFirst(root);
            while (queue.size() != 0) {
                TreeNode node = queue.removeLast();
                if (node == null) list.add(Integer.MIN_VALUE);
                else {
                    list.add(node.val);
                    queue.addFirst(node.left);
                    queue.addFirst(node.right);
                }
            }
            String listStr = list.toString();
            return listStr.substring(1, listStr.length() - 1);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if ("".equals(data)) return null;
        else {
            String[] strArr = data.split(", ");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < arr.length; i += 1) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            Deque<TreeNode> queue = new LinkedList<TreeNode>();
            TreeNode root = buildNode(arr[0]);
            int i = 0;
            queue.addFirst(root);
            while (queue.size() != 0) {
                TreeNode node = queue.removeLast();
                i += 1;
                node.left = buildNode(arr[i]);
                i += 1;
                node.right = buildNode(arr[i]);
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
            }
            return root;
        }
    }

    public TreeNode buildNode(int v) {
        if (v == Integer.MIN_VALUE) return null;
        else return new TreeNode(v);
    }
}
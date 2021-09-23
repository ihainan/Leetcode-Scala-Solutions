package me.ihainan

object O26 {
  def isSubStructure(A: TreeNode, B: TreeNode): Boolean = {
    if (A == null || B == null) false
    else contains(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
  }

  def contains(A: TreeNode, B: TreeNode): Boolean = {
    if (B == null) true
    else if (A == null || A.value != B.value) false
    else contains(A.left, B.left) && contains(A.right, B.right)
  }
}
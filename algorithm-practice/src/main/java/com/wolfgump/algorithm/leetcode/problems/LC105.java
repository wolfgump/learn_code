package com.wolfgump.algorithm.leetcode.problems;

/**
 * @author ShiTao.Gan
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 *

 **/
public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder, int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>preEnd){
            return null;
        }
        int rootValue=preorder[preStart];
        int index=-1;
        for(int i=0;i<=inEnd;i++){
            if(inorder[i]==rootValue){
                index=i;
                break;
            }
        }
        int leftSize=index-inStart;
        TreeNode node=new TreeNode(preorder[preStart]);
        node.left=build(preorder,inorder,preStart+1,preStart+leftSize,inStart,index-1);
        node.right=build(preorder,inorder,preStart+leftSize+1,preEnd,index+1,inEnd);
        return node;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
        LC105 lc105=new LC105();
        int[] preOrder={3,9,20,15,7};
        int[] inOrder={9,3,15,20,7};
        TreeNode node=lc105.buildTree(preOrder,inOrder);
    }
}

package com.wolfgump.algorithm.leetcode.problems;

/**
 * @author ShiTao.Gan
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *
 **/
public class LC106 {
    public TreeNode buildTree(int[] inorder,int[] posOrder) {
        return build(inorder,posOrder,0,inorder.length-1,0,posOrder.length-1);
    }
    private TreeNode build(int[] inorder, int[] posOrder,int inStart,int inEnd,int postStart,int postEnd){
        if(inStart>inEnd||postStart>postEnd){
            return null;
        }
        int rootValue=posOrder[postEnd];
        int index=-1;
        for(int i=0;i<=inEnd;i++){
            if(inorder[i]==rootValue){
                index=i;
                break;
            }
        }
        int leftSize=index-inStart;
        TreeNode node=new TreeNode(posOrder[postEnd]);
        node.left=build(inorder,posOrder,inStart,index-1,postStart,postStart+leftSize-1);
        node.right=build(inorder,posOrder,index+1,inEnd,postStart+leftSize,postEnd-1);
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
        LC106 lc106=new LC106();
        int[] postOrder={9,15,7,20,3};
        int[] inOrder={9,3,15,20,7};
        TreeNode node=lc106.buildTree(inOrder,postOrder);
    }
}

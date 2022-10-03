/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i< inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        
        TreeNode root = constructTree(inOrder,0,inOrder.length - 1,
                                     postOrder,0,postOrder.length - 1, map);
        
        return root;
        
    }
    
    public TreeNode constructTree(int[] inOrder, int inStart, int inEnd, 
                                 int[] postOrder, int postStart, int postEnd,Map<Integer,Integer> map){
        
        if(postStart > postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postOrder[postEnd]);
        
        int inRoot = map.get(postOrder[postEnd]);
        int numsLeft = inRoot - inStart;
        
        root.left = constructTree(inOrder, inStart, inRoot - 1,
                                 postOrder, postStart, postStart + numsLeft - 1, map);
        root.right = constructTree(inOrder, inRoot + 1, inEnd,
                                  postOrder, postStart + numsLeft , postEnd - 1, map);
        
        return root;
        
        
    }
}
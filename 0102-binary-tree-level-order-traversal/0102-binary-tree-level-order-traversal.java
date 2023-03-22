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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> s = new LinkedList();
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        s.add(root);
        
        while(!s.isEmpty()){
            int size = s.size();
            List<Integer> in = new ArrayList<>();
            for(int i = 0;i<size;i++){
                
                TreeNode n = s.remove();
                in.add(n.val);
                if(n.left != null ) s.add(n.left);
                if(n.right != null ) s.add(n.right);
                    
            }
            ans.add(in);
        }
        
        return ans;
        
    }
}
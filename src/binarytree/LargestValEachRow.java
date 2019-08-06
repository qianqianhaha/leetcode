package binarytree;
/**
 * 找出二叉树每一层节点中最大的那个值
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValEachRow {

    public List<Integer> largestValues(TreeNode root) {


        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    if(node.val>max)
                        max = node.val;

                    if(node.left!=null)
                        queue.offer(node.left);

                    if(node.right!=null)
                        queue.offer(node.right);
                }

            }
            res.add(max);

        }


        return res;

    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


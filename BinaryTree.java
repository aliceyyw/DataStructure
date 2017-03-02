package datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by wyy on 2/24/17.
 */
public class BinaryTree {

    private TreeNode root;
    public void BinaryTree(){

    }

    public static TreeNode sampleTree(){
        TreeNode root  = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        //root.right.left = new TreeNode(2);
        //root.right.right = new TreeNode(2);
        return root;
    }

    public static void printTree(TreeNode root){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    //leetcode_107   level order traverse and in reversed output
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        LinkedList<List<Integer>> result = new java.util.LinkedList<List<Integer>>();
        if(root==null) return result;
        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        int curLevel =0, parentNum=1,childNum=0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left!=null){
                queue.add(temp.left);
                childNum++;
            }
            if(temp.right!=null){
                queue.add((temp.right));
                childNum++;
            }
            parentNum--;
            level.add(temp.val);
            System.out.print(temp.val+" ");
            if(parentNum==0){
                curLevel++;
                System.out.println();
                parentNum=childNum;
                childNum=0;
                result.addFirst(level);
                level = new ArrayList<Integer>();  // new area in memory
            }

        }
        return result;
    }
    //leetcode_101 whether a binarytree is the mirror to itself
    public static boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return mutualSymmetric(root.left,root.right);

    }
    private static boolean mutualSymmetric(TreeNode x, TreeNode y){
        if(x==null&&y==null)
            return true;
        if(x==null||y==null)
            return false;
        return ((mutualSymmetric(x.left,y.right))&&(mutualSymmetric(x.right,y.left))&&(x.val==y.val));
    }

    //leetcode_110  Balanced Binary Tree
    // the depth of the two subtrees of every node never differ by more than 1
    public boolean isBalanced(TreeNode root){
        if(root==null) return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1)
            return false;
        else
            return (isBalanced(root.left)&&isBalanced(root.right));

    }

    // the depth of a node in the binary tree
    public int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }

}

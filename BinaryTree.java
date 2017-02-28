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
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    public static void printTree(TreeNode root){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }
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
            //System.out.print(temp.val+" ");
            if(parentNum==0){
                curLevel++;
                //System.out.println();
                parentNum=childNum;
                childNum=0;
                result.addFirst(level);
                level = new ArrayList<Integer>();  // new area in memory
            }

        }

        return result;
    }

}

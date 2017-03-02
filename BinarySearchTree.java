package datastructure;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wyy on 2/23/17.
 */
public class BinarySearchTree {
    private TreeNode root;
    public TreeNode getRoot(){
        return root;
    }

    // leetcode_108 Convert Sorted Array to Binary Search Tree
    // if the array in parameter is not sorted, it will be sorted.
    public BinarySearchTree(int nums[]){
        if(nums.length==0) root=null;
        Arrays.sort(nums);
        if(nums.length==0)
            root=null;
        root =recursiveBST(nums,0,nums.length-1);
     }
     private TreeNode recursiveBST(int[] arr, int lo, int hi){
        if(lo>hi)
            return null;
        if(lo==hi){
            TreeNode root = new TreeNode(arr[lo]);
            root.left=null;
            root.right=null;
            return root;
        }
        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = recursiveBST(arr,lo,mid-1);
        root.right = recursiveBST(arr,mid+1,hi);
        return root;
}


    public  void printTree(TreeNode root){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    public void printSelf(){
        if(root!=null){
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);

        }
    }

    /*leetcode_501 return the elements which repeated most in an BST
     the left or right child of one node may be equal to itself*/
    public int[] findMode(TreeNode root){
        if(root==null)
            return new int[0];
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        getMap(root,hashmap);
        System.out.println("maxcount is "+maxCount);
        List<Integer> list = new ArrayList<Integer>();
        for(int key: hashmap.keySet()){
            if(maxCount==hashmap.get(key))
                list.add(key);
        }
        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++)
            result[i]=list.get(i);
        return result;
    }
     private int maxCount=0;
     private void getMap(TreeNode root, HashMap<Integer,Integer> hashmap){
        if(root==null)
            return ;
        Integer count = hashmap.getOrDefault(root.val,0)+1; //当前结点的值,在hashmap里找,如果没有就返回DEFAULT值0,然后加上自己这个更新出现次数
        maxCount = Math.max(maxCount,count);
        hashmap.put(root.val,count);
        getMap(root.left,hashmap);
        getMap(root.right,hashmap);
     }

    //leetcode_235 find the lowest common ancestor of two nodes
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode ancestor = root;
        boolean pinleft,qinleft;
        while(ancestor!=null){
            if(ancestor.val==p.val || ancestor.val==q.val)
                return ancestor;
            pinleft = (p.val<ancestor.val);
            qinleft = (q.val<ancestor.val);
            if((pinleft==true&&qinleft==false) || (pinleft==false&&qinleft==true))
                return ancestor;
            else if(pinleft&&qinleft)
                ancestor = ancestor.left;
            else if(!(pinleft&&qinleft))
                ancestor = ancestor.right;

        }

        return ancestor;
    }
    // whether a node with given value is in the BST
    public boolean searchExistence(TreeNode root, int target){
        TreeNode t = root;
        while(t!=null){
            if(t.val==target)
                return true;
            if(t.val > target)
                t = t.left;
            else
                t = t.right;
        }
        return false;
    }

}

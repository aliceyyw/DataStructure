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

    public static void printTree(TreeNode root){
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



}

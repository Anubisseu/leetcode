package cn.edu.seu.kse.anubis.n337_house_robber_iii;

import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Created by 王彬 on 2016/8/22.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int max=0;
        HashMap<String, Integer> solution=new HashMap<>();

        max=max(solution,root);

        return max;
    }

    public int max(HashMap<String,Integer> solution, TreeNode root){
        int max=0;
        int tmp=0;

        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return root.val;
        }

        String key=root.toString();

        if(solution.containsKey(key)){
            return solution.get(key);
        }

        tmp+=root.val;
        if(root.left!=null){
            tmp+=max(solution,root.left.left)+max(solution,root.left.right);
        }

        if(root.right!=null){
            tmp+=max(solution,root.right.left)+max(solution,root.right.right);
        }
        max=tmp;

        tmp=0;
        if(root.left!=null){
            tmp+=max(solution,root.left);
        }

        if(root.right!=null){
            tmp+=max(solution,root.right);
        }

        max=Math.max(max,tmp);

        solution.put(key,max);

        return max;
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

package cn.edu.seu.kse.anubis.n337_house_robber_iii;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/22.
 */
public class HouseRobberIIITest {

    private TreeNode initdata(){
        TreeNode root=new TreeNode(3);
        TreeNode left=null;
        TreeNode right=null;

        left=new TreeNode(2);
        right=new TreeNode(3);
        root.left=left;
        root.right=right;
        left.right=new TreeNode(3);
        right.right=new TreeNode(1);

        return root;
    }

    private TreeNode initdata2(){
        TreeNode root=new TreeNode(3);
        TreeNode left=null;
        TreeNode right=null;
        left=new TreeNode(4);
        right=new TreeNode(5);
        root.left=left;
        root.right=right;

        left.left=new TreeNode(1);
        left.right=new TreeNode(3);

        right.right=new TreeNode(1);

        return root;
    }

    @Test
    public void testMap(){
        TreeNode root=initdata();
        printTree(root);
    }

    @Test
    public void test(){
//        TreeNode root=initdata();
        TreeNode root=initdata2();
        HouseRobberIII hr=new HouseRobberIII();
        int max=hr.rob(root);
        System.out.println(max);
    }

    public void printTree(TreeNode root){
        if(root!=null){
            System.out.printf("root %s, left %s, right %s%n", root, root.left, root.right);
            printTree(root.left);
            printTree(root.right);
        }else {
            return;
        }
    }
}


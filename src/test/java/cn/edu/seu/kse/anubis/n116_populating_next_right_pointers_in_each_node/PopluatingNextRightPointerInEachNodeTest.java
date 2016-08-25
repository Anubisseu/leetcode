package cn.edu.seu.kse.anubis.n116_populating_next_right_pointers_in_each_node;

import org.junit.Test;

/**
 * Created by 王彬 on 2016/8/25.
 */
public class PopluatingNextRightPointerInEachNodeTest {
    public TreeLinkNode initdata(){
        TreeLinkNode root=new TreeLinkNode(1);
        root.left=new TreeLinkNode(2);
        root.right=new TreeLinkNode(3);
        root.left.left=new TreeLinkNode(4);
        root.left.right=new TreeLinkNode(5);
        root.right.left=new TreeLinkNode(6);
        root.right.right=new TreeLinkNode(7);

        root.left.left.left=new TreeLinkNode(8);
        root.left.left.right=new TreeLinkNode(9);
        root.left.right.left=new TreeLinkNode(10);
        root.left.right.right=new TreeLinkNode(11);
        root.right.left.left=new TreeLinkNode(12);
        root.right.left.right=new TreeLinkNode(13);
        root.right.right.left=new TreeLinkNode(14);
        root.right.right.right=new TreeLinkNode(15);
        return root;
    }


    @Test
    public void test(){
        TreeLinkNode root=initdata();
        PopluatingNextRightPointerInEachNode pn=new PopluatingNextRightPointerInEachNode();
        pn.connect2(root);
        printTree(root);
    }

    private void printTree(TreeLinkNode root){
        if(root == null){
            return;
        }

        System.out.printf("node %d, node.next %d %n",root.val,root.next == null?-1:root.next.val);
        printTree(root.left);
        printTree(root.right);
    }
}

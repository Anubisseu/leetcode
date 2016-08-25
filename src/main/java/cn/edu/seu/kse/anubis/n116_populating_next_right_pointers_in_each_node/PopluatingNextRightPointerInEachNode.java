package cn.edu.seu.kse.anubis.n116_populating_next_right_pointers_in_each_node;

/**
 * Created by 王彬 on 2016/8/25.
 */
public class PopluatingNextRightPointerInEachNode {
    public void connect2(TreeLinkNode root){
        TreeLinkNode parent=root;
        TreeLinkNode child=null;

        for(parent=root;parent!=null;parent=parent.left){
            if(parent.left == null){
                break;
            }

            for(TreeLinkNode next=parent;next!=null;next=next.next){
                next.left.next=next.right;
                if(next.next != null){
                    next.right.next=next.next.left;
                }else {
                    next.right.next=null;
                }
            }
        }


    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode parent=null;
        leftorder(root,parent,false);
    }

    public void leftorder(TreeLinkNode node, TreeLinkNode parent, boolean left){
        if(node == null){
            return;
        }

        if(left){
            node.next=parent.right;
        }else {
            if(parent == null){
                node.next=null;
            }
            else if(parent.next==null){
                node.next=null;
            }
            else {
                node.next=parent.next.left;
            }
        }

        leftorder(node.left,node,true);

        leftorder(node.right,node,false);
    }
}



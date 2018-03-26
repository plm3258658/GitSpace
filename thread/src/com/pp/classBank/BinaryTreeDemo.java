package com.pp.classBank;

import java.util.Arrays;

/**
 * 二叉树
 */

class BinaryTree{//实现一个二叉树
    //保存的数据，因为必须是comparable子类，而且需要判断大小
    private class Node{
        private Comparable data;
        private Node left;//左节点
        private Node right;//右节点
        public Node(Comparable data){
            this.data=data;
        }
        public void addNode(Node newNode){
            if(this.data.compareTo(newNode.data)>0){
                if(this.left==null){
                    this.left=newNode;
                }else{
                    this.left.addNode(newNode);
                }
            }else{
                if(this.right==null){
                    this.right=newNode;
                }else{
                    this.right.addNode(newNode);
                }
            }
        }
        public void toArrayNode(){
            if(this.left!=null){
                this.left.toArrayNode();
            }
            BinaryTree.this.retData[BinaryTree.this.foot++]=this.data;
            if(this.right!=null){
                this.right.toArrayNode();
            }
        }
    }
    //----------------------------------
    private Node root; //任何的数据结构一定有个根
    private int count;
    private int foot=0;//脚标
    private Object[] retData;//返回数据
    public Object[] toArray(){
        this.foot=0;
        this.retData=new Object[this.count];
        this.root.toArrayNode();
        return this.retData;
    }
    public void add(Object data){//可以保存任何数据
        if(data==null){
            return;
        }
        Node newNode=new Node((Comparable)data);
        if(this.root==null){
            this.root=newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.count++;
    }
}
public class BinaryTreeDemo {
    public static void main(String[] args)throws Exception{
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add("B");
        binaryTree.add("C");
        binaryTree.add("A");
        System.out.println(Arrays.toString(binaryTree.toArray()));
    }
}

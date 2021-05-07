package Model.BinaryTree;

import javafx.util.Pair;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Pair<String,Integer> value) {

          root = insertRec(root, value);

    }


    Node insertRec(Node root, Pair<String,Integer> value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.getKey().compareToIgnoreCase(root.value.getKey())<0)
            root.left = insertRec(root.left, value);
        else if (value.getKey().compareToIgnoreCase(root.value.getKey())>0)
            root.right = insertRec(root.right, value);


        return root;
    }


    private Node search(Node node, String value){
        if(node != null){
            if(node.value.getKey().equals(value)){
                return node;
            } else {
                Node foundNode = search(node.left,value);
                if(foundNode == null) {
                    foundNode = search(node.right,value);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }
    public int check(String value)
    {

        Node n= this.search(root ,value);
        if (n==null)
            return -1;
        else
            return n.value.getValue();
    }

    public void inorder()  {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.value.getKey()+","+root.value.getValue());
            inorderRec(root.right);
        }
    }




}

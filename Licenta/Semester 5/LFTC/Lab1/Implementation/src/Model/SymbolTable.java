package Model;

import Model.BinaryTree.BinarySearchTree;
import javafx.util.Pair;

public class SymbolTable {

    private BinarySearchTree binaryTree;
    private int count;

    public SymbolTable() {
        this.binaryTree = new BinarySearchTree();
        this.count=0;
    }

    public int add(String value)
    {
        if (binaryTree.check(value)!=-1)
                return binaryTree.check(value);
        else
        {
            this.binaryTree.insert(new Pair<String, Integer>(value, count));
            this.count++;
            return count-1;
        }
    }


    public void print()
    {
       this.binaryTree.inorder();

    }

    public int getCount() {
        return count;
    }
}

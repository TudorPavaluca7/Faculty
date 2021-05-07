package Model.BinaryTree;

import javafx.util.Pair;

public class Node {

    Pair<String,Integer> value;
    Node left;
    Node right;

    Node(Pair<String,Integer> value) {
        this.value = value;
        right = null;
        left = null;
    }
}

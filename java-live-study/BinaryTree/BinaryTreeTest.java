package hello.core.week5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    static BinaryTree binaryTree;
    static Node root;

    @BeforeAll
    static void create(){

        binaryTree = new BinaryTree();
        Node n1 = new Node(3,new Node(6),new Node(7));
        Node n2 = new Node(2,new Node(4),new Node(5));
        root = new Node(1,n2,n1);

        /*
             1
          2    3
        4  5  6  7
         */

    }

    @Test
    void dfs(){
        binaryTree.dfs(root);
    }

    @Test
    void bfs(){
        binaryTree.bfs(root);
    }


}
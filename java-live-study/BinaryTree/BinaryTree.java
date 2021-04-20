package hello.core.week5;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

    public void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n!=null){
                System.out.println(n.getValue());
                if(n.getLeft()!=null){
                    queue.offer(n.getLeft());
                }
                if(n.getRight()!=null){
                    queue.offer(n.getRight());
                }
            }
        }

    }

    public void dfs(Node node){
        if(node == null){
            return;
        }
        dfs(node.getLeft());
        System.out.println(node.getValue());
        dfs(node.getRight());
    }

}

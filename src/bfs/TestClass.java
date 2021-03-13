package bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TestClass {

    public static void main(String[] args) {
        Tree root = Tree.addNode(100);
        Tree.addNode(root, 150);
        Tree.addNode(root, 160);
        Tree.addNode(root, 170);
        Tree.addNode(root, 90);
        Tree.addNode(root, 80);
        Tree.addNode(root, 70);
        Tree.addNode(root, 60);
        Tree.addNode(root, 50);
        Tree.addNode(root, 40);

      //  List<Tree> result = findRightView(root);
       /* Queue<Tree> result = Tree.printLevelOrder(root);
        System.out.println(result);*/
        //  Tree.printZigZag(root);

        /* System.out.print(Tree.getMinHeight(root));*/

      /*Integer data= Tree.getLevelOrderSuccessor(root,125);
      System.out.print(data);*/

       /* Queue<Tree> result = Tree.printLevelOrder(root);
        while (!result.isEmpty()) {
            Tree t = result.poll();
            if (t != null) {
                System.out.print(t.data + "-->");
            } else {
                System.out.println();

            }


        }*/

        /* System.out.println(Tree.getSumPath(root, 175));*/


       List<List<Integer>> lst=Tree.getAllPath(root);

       System.out.println(lst);

        /*PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.add(10);
        pq.add(25);
        pq.add(5);
        pq.add(100);
        System.out.println("Size="+pq.size());
        for(int i=0;i<=pq.size();i++)
        {
            System.out.println(pq.poll());
        }*/


    }

    private static List<Tree> findRightView(Tree head) {

        List<Tree> result = new ArrayList<>();
        int count = 0;
        Tree root = head;
        Tree rootLeft = head;
        result.add(root);
        while (root.right != null) {
            root = root.right;
            result.add(root);
            count++;
        }

        while (rootLeft.left != null) {
            rootLeft = rootLeft.left;
            count--;

            if (count < 0)
                result.add(rootLeft);


        }

        return result;

    }


}

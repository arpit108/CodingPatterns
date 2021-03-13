package bfs;

import java.util.*;

public class Tree {
    @Override
    public String toString() {
        return "Tree{" +
                "data=" + data +
                '}';
    }

    int data;
    Tree left;
    Tree right;

    public Tree(int data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static Tree addNode(int data) {
        return addNode(null, data);
    }

    public static Tree addNode(Tree root, int data) {
        if (root == null)
            return new Tree(data, null, null);

        if (data > root.data) {
            root.right = addNode(root.right, data);
        } else {
            root.left = addNode(root.left, data);
        }

        return root;

    }

    public static void printPreOrder(Tree root) {
        if (root == null)
            return;

        System.out.print(root.data + " --> ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInorder(Tree root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " --> ");
        printInorder(root.right);
    }

    public static void printPostOrder(Tree root) {
        if (root == null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " --> ");
    }

    public static Queue<Tree> printLevelOrder(Tree root) {
        Queue<Tree> q = new LinkedList();
        Queue<Tree> result = new LinkedList();

        q.add(root);
        while (!q.isEmpty()) {
            int levelSize=q.size();

            for(int i=0;i<levelSize;i++)
            {
                Tree t = q.poll();

                if(i==levelSize-1)
                    result.add(t);

                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);


            }


        }
        return result;
    }

    public static void printZigZag(Tree root) {
        Stack<Tree> currentLevel = new Stack<>();
        Stack<Tree> nextLevel = new Stack<>();
        currentLevel.add(root);
        boolean leftToRight = true;

        while (!currentLevel.isEmpty()) {

            Tree t = currentLevel.pop();
            System.out.print(t.data + "-->");
            if (leftToRight) {
                if (t.left != null)
                    nextLevel.add(t.left);
                if (t.right != null)
                    nextLevel.add(t.right);

            } else {
                if (t.right != null)
                    nextLevel.add(t.right);
                if (t.left != null)
                    nextLevel.add(t.left);
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Tree> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;

            }


        }


    }

    public static int getMinHeight(Tree root) {
        if (root == null)
            return 0;

        return Math.min(getMinHeight(root.left), getMinHeight(root.right)) + 1;
    }

    public static List<List<Integer>> getAllSumPath(Tree root, int sum) {
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPath = new ArrayList<>();

        findSumPath(root, sum, currentPath, allPath);
        return allPath;

    }


    public static void findSumPath(Tree root, int sum, List<Integer> currentPath, List<List<Integer>> allPath) {

        if (root == null)
            return;

        currentPath.add(root.data);

        if (root.data == sum && root.left == null && root.right == null)
            allPath.add(new ArrayList<>(currentPath));
        else {
            findSumPath(root.left, sum - root.data, currentPath, allPath);
            findSumPath(root.right, sum - root.data, currentPath, allPath);
        }
        currentPath.remove(currentPath.size() - 1);

    }


    public static Integer getLevelOrderSuccessor(Tree root, int nodeData) {
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree t = q.poll();
            if (t.data == nodeData) {
                if (q.peek() != null)
                    return q.peek().data;
                else
                    return null;
            }
            if (t.left != null) {
                q.add(t.left);
            }
            if (t.right != null) {
                q.add(t.right);
            }

        }

        return null;


    }

    public static List<List<Integer>> getAllPath(Tree root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findAllTreePaths(root, currentPath, allPaths);
        return allPaths;

    }

    private static void findAllTreePaths(Tree root, List<Integer> currentPath, List<List<Integer>> allPaths) {

        if (root == null)
            return;
        currentPath.add(root.data);
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findAllTreePaths(root.left, currentPath, allPaths);
            findAllTreePaths(root.right, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size()-1);


    }


}

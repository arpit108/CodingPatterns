package TopologicalSort;

import java.util.*;

public class GraphSort {

    public static void main(String[] args) {
        int[][] edges = {{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}};
        int vertex = 6;

        sort(edges, vertex);


    }

    private static void sort(int[][] edges, int vertex) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for(int i=0;i<vertex;i++)
        {
            graph.put(i,new ArrayList<Integer>());
            inDegree.put(i,0);
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            List<Integer> childrens = graph.getOrDefault(parent, new ArrayList<>());
            childrens.add(child);
            graph.put(parent, childrens);
            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
        }

        Queue<Integer> source = new LinkedList<>();
        for (Integer node : inDegree.keySet()) {
            if (inDegree.get(node) == 0)
                source.add(node);
        }

        printAllTopologicalSorts(graph, inDegree, source, result);


    }


    private static void printAllTopologicalSorts(Map<Integer, List<Integer>> graph,
                                                 Map<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                // only remove the current source, all other sources should remain in the queue for the next call
                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);

                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        // if sortedOrder doesn't contain all tasks, either we've a cyclic dependency between tasks, or
        // we have not processed all the tasks in this recursive call
        if (sortedOrder.size() == inDegree.size())
            System.out.println(sortedOrder);
    }

    // makes a deep copy of the queue
    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }


}

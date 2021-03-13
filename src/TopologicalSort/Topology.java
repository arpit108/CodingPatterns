package TopologicalSort;

import java.util.*;

public class Topology {


    public static List<Integer> sort(int vertex, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        //Initialization
        for (int i = 0; i < vertex; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        //Creating graph

        for (int i = 0; i < edges.length; i++) {

            int parent = edges[i][0];
            int child = edges[i][1];

            inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            graph.get(parent).add(child);


        }


        //finding source
        Queue<Integer> source = new LinkedList<>();

        for (Map.Entry<Integer, Integer> element : inDegree.entrySet()) {

            if (element.getValue() == 0) {
                source.add(element.getKey());
            }


        }


        //sorting

        while (!source.isEmpty()) {
            Integer sourceNode = source.poll();

            sortedOrder.add(sourceNode);

            List<Integer> childrens = graph.get(sourceNode);

            for (Integer child : childrens) {
                inDegree.put(child, inDegree.get(child) - 1);

                if (inDegree.get(child) == 0) {
                    source.add(child);
                }
            }


        }
        if (sortedOrder.size() != vertex)
            return new ArrayList<>();

        return sortedOrder;

    }


}

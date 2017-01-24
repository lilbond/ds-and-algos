package com.musingscafe.tastybytes.graph;

/**
 * Created by ayadav on 12/29/16.
 */
public class IntegerGraphWithAdjListDriver {
    public static void main(String[] args) {
        minimumDistance();
    }

    private static void minimumDistance() {
        IntegerGraphWithAdjList graphWithLongerPathFirstInList = getGraphWithLongerPathFirstInList();
        IntegerGraphWithAdjList graphWithShorterPathFirstInList = getGraphWithShorterPathFirstInList();

        System.out.println();
        System.out.println(graphWithLongerPathFirstInList.minimumDistance(0, 2));

        System.out.println();
        System.out.println(graphWithShorterPathFirstInList.minimumDistance(0, 2));

        System.out.println();
        graphWithLongerPathFirstInList.dfs(0);
    }

    private static void simpleBFS() {
        whenLongerPathComesFirstInAdjList();
        System.out.println();
        whenShorterPathComesFirstInAdjList();

        /*
        Output:

        0 -> 3 1
        1 -> 2
        2 ->
        3 -> 4
        4 -> 2

        Print bfs, whenLongerPathComesFirstInAdjList
        0 3 1 4 2
        0 -> 1 3
        1 -> 2
        2 ->
        3 -> 4
        4 -> 2

        Print bfs, whenShorterPathComesFirstInAdjList
        0 1 3 2

        Conclusion: BFS is use to find shortest path in an unweighted graph but it in itself does not give shortest path.
        There are plenty of references on internet which says "BFS gives shortest path".
         */
    }

    private static void whenShorterPathComesFirstInAdjList() {
        IntegerGraphWithAdjList graph = getGraphWithShorterPathFirstInList();

        graph.print();

        System.out.println();
        System.out.println("Print bfs, whenShorterPathComesFirstInAdjList");
        graph.bfs(0);
    }

    private static IntegerGraphWithAdjList getGraphWithShorterPathFirstInList() {
        IntegerGraphWithAdjList graph = new IntegerGraphWithAdjList();
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        return graph;
    }

    private static void whenLongerPathComesFirstInAdjList() {
        IntegerGraphWithAdjList graph = getGraphWithLongerPathFirstInList();

        graph.print();

        System.out.println();
        System.out.println("Print bfs, whenLongerPathComesFirstInAdjList");
        graph.bfs(0);
    }

    private static IntegerGraphWithAdjList getGraphWithLongerPathFirstInList() {
        IntegerGraphWithAdjList graph = new IntegerGraphWithAdjList();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        return graph;
    }
}

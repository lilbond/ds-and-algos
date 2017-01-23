package com.musingscafe.tastybytes.graph;

import java.util.*;

/**
 * This is a very basic implementation. We will not be validating the input and will rely on the input.
 * The goal here is to implement simple Breadth First Traversal with Adj-List.
 *
 * This implementation works sort of like directed graphs as we add edge to only one list
 */
public class IntegerGraphWithAdjList {
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

    public void addEdge(int a, int b) {
        if (adjList.containsKey(a)) {
            adjList.get(a).add(0, b);
        }
        else {
            addVertex(a);
            addEdge(a, b);
        }

        //done with a
        if (!adjList.containsKey(b)) {
            addVertex(b);
        }
    }

    private void addVertex(int a) {
        adjList.put(a, new ArrayList<Integer>());
    }

    public void print() {
        for (Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor: entry.getValue()) {
                displayVertex(neighbor);
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        queue.add(start);
        set.add(start);
        displayVertex(start);

        while (!queue.isEmpty()) {
            int vertex = getAdjNotVisited(queue.peek(), set);

            if (vertex == -1) {
                queue.remove();
            }
            else {
                queue.add(vertex);
                set.add(vertex);
                displayVertex(vertex);
            }
        }
    }

    public void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

        stack.push(start);
        set.add(start);
        displayVertex(start);

        while (!stack.isEmpty()) {
            int vertex = getAdjNotVisited(stack.peek(), set);

            if (vertex == -1) {
                stack.pop();
            }
            else {
                stack.push(vertex);
                set.add(vertex);
                displayVertex(vertex);
            }
        }
    }

    public int minimumDistance(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = adjList.size();
        int[] distance = new int[count];
        int[] previous = new int[count];

        for (int i = 0; i < count; i++) {
            distance[i] = -1;
        }

        queue.add(start);
        distance[start] = 0;
        displayVertex(start);

        while (!queue.isEmpty()) {
            int vertex = getAdjNotVisited(queue.peek(), distance);

            if (vertex == -1) {
                queue.remove();
            }
            else {
                distance[vertex] = distance[queue.peek()] + 1;
                previous[vertex] = queue.peek();
                queue.add(vertex);
                displayVertex(vertex);
            }
        }

        System.out.println();
        printPath(previous, start, end);
        System.out.println();
        return distance[end];
    }

    private void printPath(int[] previous, int start, int end) {
        if (start == end) {
            System.out.print("Path : ");
            displayVertex(end);
            return;
        }

        printPath(previous, start, previous[end]);
        displayVertex(end);
    }

    private void displayVertex(int start) {
        System.out.print(start + " ");
    }

    private int getAdjNotVisited(Integer peek, int[] distance) {
        List<Integer> neighbors = adjList.get(peek);

        for (Integer neighbor: neighbors) {
            if (distance[neighbor] == -1) {
                return neighbor;
            }
        }

        //all visited return -1
        return -1;
    }

    private int getAdjNotVisited(Integer peek, HashSet<Integer> set) {
        List<Integer> neighbors = adjList.get(peek);

        for (Integer neighbor: neighbors) {
            if (!set.contains(neighbor)) {
                return neighbor;
            }
        }

        //all visited return -1
        return -1;
    }
}

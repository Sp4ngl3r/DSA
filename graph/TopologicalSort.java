package graph;

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {

    private static void dfs(int node, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adjacent) {

        visited[node] = 1;
        ArrayList<Integer> connectedNodes = adjacent.get(node);

        for (int connectedNode : connectedNodes) {
            if (visited[connectedNode] == 0) {
                dfs(connectedNode, visited, stack, adjacent);
            }
        }

        stack.push(node);
    }

    @SuppressWarnings("unused")
    private static int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adjacent) {

        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, stack, adjacent);
            }
        }

        int result[] = new int[v];
        int pos = 0;
        while (!stack.empty()) {
            result[pos++] = stack.pop();
        }

        return result;
    }
}

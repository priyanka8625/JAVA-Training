import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    HashMap<Integer, LinkedList<Integer>> graph;
    Graph(){
        graph = new HashMap<>();
    }
    void addVertex(int vertex){
        graph.putIfAbsent(vertex, new LinkedList<>());
    }
    void addEdge(int u, int v){
        addVertex(u);
        addVertex(v);
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    void display(){
        for(int vertex : graph.keySet()){
            System.out.print(vertex + "-> ");
            for(int neigh : graph.get(vertex)){
                System.out.print("(" + neigh + ", "+ System.identityHashCode(neigh) +") ");
            }
            System.out.println();
        }
    }
    void dfs(int start){
        HashSet<Integer> visited = new HashSet<>();
        for(int vertex : graph.keySet()){
            if(!visited.contains(vertex))
                dfsHelper(vertex, visited);
        }
    }
    void dfsHelper(int curr, HashSet<Integer> visited){
        visited.add(curr);
        System.out.print(curr + " ");
        for(int nbr : graph.get(curr)){
            if(!visited.contains(nbr)){
                dfsHelper(nbr, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of vertices: ");
        int n = sc.nextInt();
        System.out.println("Enter vertices:");
        for(int i=0; i<n; i++){
            int v = sc.nextInt();
            g.addVertex(v);
        }
        System.out.println("Enter no. of edges: ");
        int e = sc.nextInt();
        for(int i=0; i<e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        g.display();
        g.dfs(1);

        // //just for learning purpose : can we have multiple main methods
        // main();
    }
    public static void main() {
        System.out.println("priyanka");
    }
}

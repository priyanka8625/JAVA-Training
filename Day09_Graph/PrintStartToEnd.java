import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintStartToEnd {
    HashMap<Integer, LinkedList<Integer>> graph;
    PrintStartToEnd(){
        graph = new HashMap<>();
    }
    void addVertex(int v){
        graph.putIfAbsent(v, new LinkedList<>());
    }
    void addEdge(int u, int v){
        addVertex(u);
        addVertex(v);
        graph.get(u).add(v);
    }
    void findPaths(int start, int end){
        List<Integer> visited = new ArrayList<>();
        dfsHelper(start, end, visited);
    }
    void dfsHelper(int curr, int end, List<Integer> visited){
        visited.add(curr);

        if(curr == end){
            for(int vertex : visited){
                System.out.print(vertex + " ");
            }
            System.out.println();
            visited.removeLast();
            return;
        }

        for(int nbr : graph.get(curr)){
            if(!visited.contains(nbr)){
                dfsHelper(nbr, end, visited);
            }
        }

        visited.removeLast();//to explore other paths going through this node
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
    void createGraph(Scanner sc){
        System.out.println("Enter no. of edges: ");
        int e = sc.nextInt();
        System.out.println("Enter edges: ");
        for(int i=0; i<e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(u, v);
        }
    }
    public static void main(String[] args) {
        PrintStartToEnd g = new PrintStartToEnd();
        Scanner sc = new Scanner(System.in);

        g.createGraph(sc);

        System.out.println("Enter start and end nodes: ");
        int start = sc.nextInt();
        int end = sc.nextInt();

        // g.display();
        System.out.println("Paths: ");
        g.findPaths(start, end);
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class DoPathExists {
    HashMap<Integer, LinkedList<Integer>> graph;

    DoPathExists(){
        graph = new HashMap<>();
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
    void addVertex(int vertex){
        graph.putIfAbsent(vertex, new LinkedList<>());
    }
    void addEdge(int u, int v){
        addVertex(u);
        addVertex(v);
        graph.get(u).add(v);
    }

    boolean pathExists(int start, int end){
        HashSet<Integer> visited = new HashSet<>();
        return dfs(start, end, visited);
    }
    boolean dfs(int curr, int end, HashSet<Integer> visited){
        if(curr == end)
            return true;
        visited.add(curr);
        for(int nbr : graph.get(curr)){
            if(!visited.contains(nbr)){
                if(dfs(nbr, end, visited))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoPathExists g = new DoPathExists();
        g.createGraph(sc);

        System.out.println("Enter start and end vertices: ");
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(g.pathExists(start, end)? "YES" : "NO");
    }
}

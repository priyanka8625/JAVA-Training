import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    HashMap<Integer, LinkedList<Integer>> graph;
    BFS(){
        graph = new HashMap<>();
    }
    void addVertex(int u){
        graph.putIfAbsent(u, new LinkedList<>());
    }
    void addEdge(int u, int v){
        addVertex(u);
        addVertex(v);
        graph.get(u).add(v);
    }
    void bfs(int start){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        bfsHelper(q, visited);
    }
    void bfsHelper(Queue<Integer> q, HashSet<Integer> visited){
        if(q.isEmpty())
            return;
        
        int curr = q.remove();
        System.out.print(curr + " ");

        for(int nbr : graph.get(curr)){
            if(!visited.contains(nbr)){
                q.add(nbr);
                visited.add(nbr);
            }
        }

        bfsHelper(q, visited);
    }
    void bfs2(int start){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.remove();
                System.out.print(curr+" ");

                for(int nbr : graph.get(curr)){
                    if(!visited.contains(nbr)){
                        visited.add(nbr);
                        q.add(nbr);
                    }
                }
            }
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
        Scanner sc = new Scanner(System.in);
        BFS g = new BFS();

        g.createGraph(sc);

        System.out.println("Enter start :");
        int start = sc.nextInt();
        g.bfs2(start);
    }
}

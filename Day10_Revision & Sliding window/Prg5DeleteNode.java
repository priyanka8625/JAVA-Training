import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Graph{
    HashMap<Integer, LinkedList<Integer>> hm;
    Graph(){
        hm = new HashMap<>();
    }
    void addVertex(int v){
        hm.putIfAbsent(v, new LinkedList<>());
    }
    void addEdge(int u, int v){
        addVertex(u);
        addVertex(v);
        hm.get(u).add(v);
        hm.get(v).add(u);
    }
    void deleteEdge(int v){
        for(int vertex : hm.keySet()){
            hm.get(vertex).remove(new Integer(v));
        }
        hm.remove(v);
    }
    void print(){
        System.out.println();
        for(int vertex : hm.keySet()){
            System.out.print(vertex + "-> ");
            for(int nbr : hm.get(vertex)){
                System.out.print(nbr + " ");
            }
            System.out.println();
        }
    }
}

public class Prg5DeleteNode {
    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner sc = new Scanner(System.in);

        System.out.println("Add no od edges: ");
        int n = sc.nextInt();
        System.out.println("Add edges: ");
        for(int i=0; i<n; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        g.print();
        System.out.println("Enter node to delete:");
        int v= sc.nextInt();
        g.deleteEdge(v);
        g.print();
    }
}

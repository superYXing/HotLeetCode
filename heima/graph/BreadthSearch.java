package heima.graph;
import java.util.LinkedList;
import java.util.List;

import heima.graph.*;
public class BreadthSearch {
	public static void main(String[] args) {
		// 创建顶点
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");
        
        // 根据图示添加有向边
        // 1 -- 14 --> 6
        v1.edges = List.of(
            new Edge(v6, 14),
            new Edge(v2, 7),    // 1 -- 7 --> 2
            new Edge(v3, 9)     // 1 -- 9 --> 3
        );
        
        // 2 -- 15 --> 4
        v2.edges = List.of(new Edge(v4, 15));
        
        // 3 -- 2 --> 6, 3 -- 11 --> 4
        v3.edges = List.of(
            new Edge(v6, 2),
            new Edge(v4, 11)
        );
        
        // 6 -- 9 --> 5
        v6.edges = List.of(new Edge(v5, 9));
        
        // 4 -- 6 --> 5
        v4.edges = List.of(new Edge(v5, 6));
        
        // 5 无出边
        v5.edges = List.of();
		bfs(v1);
	}
	static void bfs(Vertex vertex){
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add(vertex);
		vertex.visited = true;
		while(!queue.isEmpty()){
			Vertex v = queue.poll();
			System.out.println(v.name);
			for(Edge edge:v.edges){
			if(!edge.linked.visited){
				edge.linked.visited = true;
				queue.add(edge.linked);
			}
			
		}
		}
	

	}
}

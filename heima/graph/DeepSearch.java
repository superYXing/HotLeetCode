package heima.graph;
import java.util.List;

import heima.graph.*;
public class DeepSearch {
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
		dfs(v1);
	}
	static void dfs(Vertex vertex){
		//返回条件：此节点被访问过或者此节点没有边
		if(vertex.visited) return;
		vertex.visited = true;
		System.out.println(vertex.name);
		  List<Edge> edges = vertex.edges;
    
    // 递归遍历所有边
    for(Edge edge : edges){
        dfs(edge.linked);
    }
	}
}

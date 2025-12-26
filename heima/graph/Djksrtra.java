package heima.graph;
import heima.graph.*;
import java.util.ArrayList;
import java.util.List;

public class Djksrtra {
	public static void main(String[] args) {
		// 创建顶点
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		
		// 创建边（带权重）
		v1.edges = List.of(new Edge(v2, 7), new Edge(v3, 9), new Edge(v6, 14));
		v2.edges = List.of(new Edge(v4, 15));
		v3.edges = List.of(new Edge(v6, 2), new Edge(v4, 11));
		v4.edges = List.of(new Edge(v5, 6));
		v5.edges = List.of();
		v6.edges = List.of(new Edge(v5, 9));
		
		List<Vertex> graph = new ArrayList<>(List.of(v1, v2, v3, v4, v5, v6));
		
		// 执行Dijkstra算法
		dijkstra(graph, v1);
		System.out.println("out");
		//输出权重
		
		for(Vertex vertex:graph){
		
			System.out.println(vertex.name + " : " + vertex.dist + " name: " + (vertex.prev!=null?vertex.prev.name:"null"));
		}
	}
	
	static void dijkstra(List<Vertex> graph, Vertex source) {
		// System.out.println("into");
		List<Vertex> list = new ArrayList<>(graph);
		source.dist=0;
		while(!list.isEmpty()){
			//找距离最小的顶点
			Vertex v = findMin(list);
			//更新距离
			for(Edge edge:v.edges){
				if(list.contains(edge.linked)){
					if(edge.linked.dist>edge.weight+v.dist){
						edge.linked.dist = edge.weight+v.dist;
						edge.linked.prev = v;
					}
			}
		}
			//从列表删除顶点
			list.remove(v);
		}
	}
	static Vertex findMin(List<Vertex> list){
		Vertex v = list.get(0);
		for(Vertex vertex:list){
			v = vertex.dist<v.dist?vertex:v;
		}
		return v;
	}
}

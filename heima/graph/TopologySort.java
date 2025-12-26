package heima.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import heima.graph.*;
public class TopologySort {
	public static void main(String[] args) throws Exception {
		Vertex v1 = new Vertex("1");
	Vertex v2 = new Vertex(  "2");
	Vertex v3 = new Vertex( "3");
	Vertex v4 = new Vertex(  "4");
	Vertex v5 = new Vertex( "5");
	Vertex v6 = new Vertex(  "6");
	Vertex v7 = new Vertex(  "7");

	v1.edges = List.of(new Edge(v3));
	v2.edges = List.of(new Edge(v3));
	v3.edges = List.of(new Edge(v4));
	v6.edges = List.of(new Edge(v4));
	v4.edges = List.of(new Edge(v5));
	v5.edges = List.of(new Edge(v7));
	v7.edges = List.of();

	List<Vertex> graph = new ArrayList<>(List.of(v1, v2, v3, v4, v5, v6, v7));
		//入度在Edge构造类自动更新
	topologySort(graph);
	// LinkedList<String> stack = new LinkedList<>();
	// for(Vertex vertex:graph){
	// 	dfsTopology(vertex, stack);
	// }
	// System.out.println(stack);
	}
	static void topologySort(List<Vertex> graph){
		LinkedList<Vertex> queue = new LinkedList<>();

		for(Vertex vertex:graph){
			System.out.println(vertex.name+" "+vertex.inDegree);
			if(vertex.inDegree==0){
				queue.add(vertex);
			}
		}
		//检测环：队列操作后的顶点数量和原始图的顶点数量比较
		int sum = graph.size();  //图的顶点数量
		int count = 0; //队列操作后的总数量
		while(!queue.isEmpty()){
		Vertex v = queue.poll();
		count++;
		System.out.println(v.name);
		for(Edge edge:v.edges){
			edge.linked.inDegree--;
			if(edge.linked.inDegree==0){
				queue.add(edge.linked);
			}
		}
	}
		if(count==sum) System.out.println("无环");
		else System.out.println("有环");
	}
	static void dfsTopology(Vertex vertex, LinkedList<String> stack) throws Exception{
		if(vertex.status==2) return;
		if(vertex.status==1){
				throw new Exception("有环");
			}
				vertex.status=1;
		for(Edge edge:vertex.edges){
			dfsTopology(edge.linked, stack);
		}
				vertex.status=2;
		stack.push(vertex.name);
	}
}

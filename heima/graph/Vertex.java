package heima.graph;
import heima.graph.Edge;
import java.util.List;
public class Vertex {
	String name;
	List<Edge> edges;
	boolean visited = false;
	int inDegree; //入度
	int status; //0为未访问，1为访问中，2为已访问，用于拓扑排序
	int dist = Integer.MAX_VALUE;  //Djkstra算法的初始距离
	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");

		a.edges = List.of(new Edge(b),new Edge(c));
		b.edges = List.of(new Edge(d));
		c.edges = List.of(new Edge(d));
		d.edges = List.of();

	}
	
}

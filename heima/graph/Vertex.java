package heima.graph;
import heima.graph.Edge;
import java.util.List;
public class Vertex {
	String name;
	List<Edge> edges;
	boolean visited = false;

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

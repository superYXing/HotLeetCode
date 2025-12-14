package heima.graph;
import heima.graph.Vertex;
public class Edge {
	Vertex linked;
	int weight;

	
	public Edge(Vertex linked) {
		this.linked = linked;
		this.weight = 1;
		linked.inDegree++;
	}


	public Edge(Vertex linked, int weight) {
		this.linked = linked;
		this.weight = weight;
	}


	public Vertex getLinked() {
		return linked;
	}


	public int getWeight() {
		return weight;
	}
	
	

}

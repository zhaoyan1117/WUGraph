/* graph/Edge.java */
package graph;

import list.DListNode;

/**
 * An internal object of Edge used by the WUgraph ADT.
 */
public class Edge {
	
	private Vertex v1;	// First vertex connected by "this" edge.
	private Vertex v2; 	// Second vertex connected by "this" edge.
	private int weight;
	private VertexPair pair;
	private DListNode d1;	// First position of "this" edge in adjacency list.
	private DListNode d2;   // Second position of "this" edge in adjacency list, if "this" is a self edge, d2 is null.
	
	/**
	 * Build an edge object.
	 * @param v1: first vertex connected by the edge.
	 * @param v2: second vertex connected by the edge.
	 * @param w: weight of this edge.
	 * @param p: the external vertex pair corresponding to "this" edge.
	 */
	public Edge(Vertex v1, Vertex v2, int w, VertexPair p) {
		this.v1 = v1;
		this.v2 = v2;
		weight = w;
		pair = p;
	}
	
	/**
	 * getter of the first vertex.
	 */
	public Vertex getV1() {
		return v1;
	}
	
	/**
	 * getter of the second vertex.
	 */
	public Vertex getV2() {
		return v2;
	}
	
	/**
	 * getter of weight.
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * setter of weight.
	 */
	protected void setWeight(int w) {
		weight = w;
	}
	
	/**
	 * getter of the external vertex pair.
	 */
	public VertexPair getPair() {
		return pair;
	}
	
	/**
	 * getter of the first DListNode.
	 */
	public DListNode getD1() {
		return d1;
	}
	
	/**
	 * getter of the second DListNode.
	 */
	public DListNode getD2() {
		return d2;
	}
	
	/**
	 * setter of the first DListNode.
	 */
	protected void setD1(DListNode d) {
		d1 = d;
	}
	
	/**
	 * setter of the second DListNode.
	 */
	protected void setD2(DListNode d) {
		d2 = d;
	}
	
}


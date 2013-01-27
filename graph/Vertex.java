/* graph/Vertex.java */
package graph;

import list.DListNode;
import list.DList;

/**
 * An internal object of Vertex used by the WUgraph ADT.
 */
public class Vertex {
	
	private Object exVertex; //The corresponding external vertex of "this" internal vertex.
	private DListNode node;  //The DListNode in which "this" vertex exist within the vertex list.
	private DList aList; //The adjacency list of this Vertex.
	
	/**
	 * Constructor of Vertex object.
	 * @param v: the external object corresponding to "this" internal vertex.
	 */
	public Vertex(Object v) {
		exVertex = v;
		aList = new DList();
	}
	
	/**
	 * getter of the external vertex.
	 * @return: the external vertex object.
	 */
	public Object getExVertex() {
		return this.exVertex;
	}
	
	/**
	 * getter of the DListNode in which "this" vertex exist within the vertex list.
	 * @return: DListNode in which "this" vertex exist within the vertex list..
	 */
	public Object getNode() {
		return this.node;
	}
	
	/**
	 * setter of the DListNode in which "this" vertex exist within the vertex list.
	 * @param: the DListNode in which "this" vertex exist within the vertex list.
	 */
	protected void setNode(DListNode n) {
		this.node = n;
	}
	
	/**
	 * getter of the adjacency list "this" vertex has.
	 * @return: the adjacency list "this" vertex has.
	 */
	public DList getAList() {
		return aList;
	}

	/**
	 * getter of the length of the adjacency list "this" vertex has.
	 * @return: length of the adjacency list "this" vertex has.
	 */
	public int getAListLength() {
		return aList.length();
	}
	
}


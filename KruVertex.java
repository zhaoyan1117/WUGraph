/* KruVertex.java */

/**
 * KruVertex is an internal representation of Vertex from the given graph
 * It has fields is visited which is initially set as false, DS_index which 
 * is mapped to the disjointSet, depth which keeps track of the depth of 
 * the tree, and parent which stores the reference the previous vertex.
 */
public class KruVertex {

	protected boolean isvisited = false;
	protected int DS_index;
	protected int depth;
	protected KruVertex parent;
	
	/**
	 * KruVertex constructor simply takes the index that would be used to 
	 * linked with the integer in the disjointSet
	 */
	public KruVertex(int index){
		DS_index = index;
	}
	
	/**
	 * getter of whether "this" vertex is visited;
	 */
	public boolean isVisited(){
		return this.isvisited;
	}
	
	/**
	 * getter of the index of "this" vertex
	 */
	public int index(){
		return DS_index;
	}
	
	/**
	 * visit() function that checked this vertex "visited", visit() takes in the 
	 * origin vertex that the visit action comes from. 
	 */
	public void visit(KruVertex origin){
		this.parent = origin;
		if(origin == null){						// if origin is the root
			this.depth = 0;						// this depth is 0
		}else{									// otherwise
			this.depth = origin.depth++;		// this depth + 1
		}
	}
}

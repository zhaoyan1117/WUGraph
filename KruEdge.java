/* KruEdge.java */

/**
 * KruEdge is an internal representation of Edge from the given graph.
 * It has fields weight, v1, v2 which represents the weight and two 
 * vertex that linked by the edge, respectively.
 */
public class KruEdge implements Comparable{
	

	private int weight;					// the weight of the edge						
	private Object v1;					// a vertex at one end of the edge
	private Object v2;					// a vertex at the other end of the edge
	
	/**
	 * KruEdge constructor simply takes 2 vertices at both ends of the edge
	 * and the weight of the edge
	 */
	public KruEdge(Object v1, Object v2, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	/**
	 * A weight getter
	 */
	public int getWeight(){
		return this.weight;
	}
	
	/**
	 * one vertex getter
	 */
	public Object v1(){
		return this.v1;
	}
	
	/**
	 * another vertex getter 
	 */
	public Object v2(){
		return this.v2;
	}
	
	/**
	 * CompareTo() implements the compareTo() in Comparable interface
	 * it takes in another edge and compare the weight with "this" 
	 * edge's weight. Return 1 if "this" weight is relatively larger,
	 * -1 if otherwise, and 0 if "this" weight equals o's weight; 
	 */
	public int compareTo(Object o) {
		if(this.weight > ((KruEdge)o).weight){
			return 1;
		}else if(this.weight < ((KruEdge)o).weight){
			return -1;
		}else{
			return 0;
		}
	}
}

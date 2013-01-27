/* Kruskal.java */

import graph.*;
import set.*;
import dict.*;
import list.*;

import java.util.Random;

/**
 * The Kruskal class contains the method minSpanTree(), which implements
 * Kruskal's algorithm for computing a minimum spanning tree of a graph;
 * @T: new WUGraph that contains the minimum spanning tree;
 * @edgeList: an Array that contains all the edge from the original graph;
 * @edgeIndex: the index in the edgeList used when it is constructed;
 * @verticesTable: a hash table that uses original vertex as key and KruVertex(an internal representation) as value;
 * @vertices: an Array of all the vertices from the original graph;
 * @set: a disjointSet that is used to determine when adding edges to the new graph;
 */
public class Kruskal {

	private static WUGraph T;
	private static KruEdge[] edgeList;
	private static int edgeIndex = 0;
	private static HashTableChained verticesTable;
	private static Object[] vertices;
	private static DisjointSets set;
	
	
	
	/**
	 * minSpanTree() returns a WUGraph that represents the minimum spanning tree
	 * of the WUGraph g.  The original WUGraph g is NOT changed.
	 * @g: the original WUGraph;
	 */
	public static WUGraph minSpanTree(WUGraph g){
		T = new WUGraph();											// construct a new graph T;
		vertices = g.getVertices();									// construct the array of vertices from original graph;
		verticesTable = new HashTableChained(g.vertexCount());		// construct a empty hashTable used to store vertices;
		int selfEdge = 0;											// number of selfEdges;
		for(Object o : vertices){									
			if(g.isEdge(o, o)){										// count the number of vertices;
				selfEdge++;											
			}
		}
		edgeList = new KruEdge[g.edgeCount() - selfEdge];			// construct the Array of edgeList;
		int index = 0;
		set = new DisjointSets(g.vertexCount());					// construct a new disjointSet within which each set are independent at the beginning;
		
		for(Object ooo: g.getVertices()){
			T.addVertex(ooo);										// adding vertices to T so that it has the same vertices as g;
		}
		
		for(Object o: vertices){									// initialize the vertices hash table;
			verticesTable.insert(o, new KruVertex(index));
			index++;
		}
		
		search(vertices[0], g, verticesTable);						// generate the list of all the edge;

		quickSort(edgeList, 0, edgeList.length-1);					// sorting edge list;

		for(KruEdge e : edgeList){														// for each edge in the sorted edgeList;
			int left = ((KruVertex) verticesTable.find(e.v1()).value()).index();		// get the index of a vertex on one end of the edge;
			int right = ((KruVertex) verticesTable.find(e.v2()).value()).index();		// get the index of a vertex on the other end of the edge;
			if(set.find(left) != set.find(right)){										// find the root of both left and right, if they don't belong to the same group;
				T.addEdge(e.v1(), e.v2(), e.getWeight());								// add an edge connecting these two vertices in the new graph;
				set.union(set.find(left), set.find(right));								// union left and right in the disjointSet;
			}else{
			}																			// otherwise do nothing
		}
		return T;
	}
	
	/**
	 * Helper function:starting from a vertex v, traverse the original graph g and append every edge
	 * to the edgeList; 
	 * @v: vertex to start traversal;
	 * @g: the original graph;
	 * @h: the dictionary connecting object Vertex and KruVertex
	 */
	private static void search(Object v, WUGraph g, HashTableChained h){
		for(int a = 0; a < g.vertexCount(); a++){										// for each vertex in the vertexArray
			Object o1 = vertices[a];
			for(Object o2 : g.getNeighbors(o1).neighborList){							// find all its neighbors that has index larger than itself's
				if(((KruVertex) h.find(o2).value()).index() > a){
					edgeList[edgeIndex] = new KruEdge(o2, o1, g.weight(o2, o1));		// upon find one neighbor, append the edge connecting them to the edgeList;
					edgeIndex++;								
				}
			}
		}
	}
	
	/**
	 *  A quickSort method written recursively.
	 * @param a: the array needed to be sorted.
	 * @param low: the lower bound in the sorting algorithm.
	 * @param high: the higher bound in the sorting algorithm.
	 */
	private static void quickSort(Comparable[] a, int low, int high) {
		if (low < high) {
			int pivotIndex = low + (int)(Math.random() * ((high - low) + 1));
			Comparable pivot = a[pivotIndex];
		    a[pivotIndex] = a[high];                    			// Swap pivot with last item
		    a[high] = pivot;
		    
		    int i = low - 1;
		    int j = high;
		    do {
		    	do { i++; } while (a[i].compareTo(pivot) < 0);
		    	do { j--; } while ((a[j].compareTo(pivot) > 0) && (j > low));
		    	if (i < j) {
		    		Comparable holder = a[i];
		    		a[i] = a[j];
		    		a[j] = holder;
		    	}
		    } while (i < j);

		    a[high] = a[i];
		    a[i] = pivot;                   	   			  	 // Put pivot in the middle where it belongs
		    quickSort(a, low, i - 1);             				 // Recursively sort left list
		    quickSort(a, i + 1, high);     	      		   		 // Recursively sort right list
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
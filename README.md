WUGraph
=======

A fast well-encapsulated ADT - weighted undirected graph.


Time Complexity   Function                           Explanation
---------------------------------------------------------------------------------------------------
O(1)              WUGraph();                         construct a graph having no vertices or edges.
O(1)              int vertexCount();                 return the number of vertices in the graph.
O(1)              int edgeCount();                   return the number of edges in the graph.
O(|V|)            Object[] getVertices();            return an array of all the vertices.
O(1)              void addVertex(Object);            add a vertex to the graph.
O(d)              void removeVertex(Object);         remove a vertex from the graph.
O(1)              boolean isVertex(Object);          is this object a vertex of the graph?
O(1)              int degree(Object);                return the degree of a vertex.
O(d)              Neighbors getNeighbors(Object);    return the neighbors of a vertex.
O(1)              void addEdge(Object, Object, int); add an edge of specified weight.
O(1)              void removeEdge(Object, Object);   remove an edge from the graph.
O(1)              boolean isEdge(Object, Object);    is this edge in the graph?
O(1)              int weight(Object, Object);        return the weight of this edge.

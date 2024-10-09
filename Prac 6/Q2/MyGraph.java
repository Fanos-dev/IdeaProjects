import java.util.ArrayList;
import java.util.List;

public class MyGraph<V> extends UnweightedGraph<V> {	  
	  	/** Construct an empty graph */
	  	public MyGraph() {
	  	}
			  
		  /** Construct a graph from edges and vertices stored in arrays */
		  public MyGraph(int[][] edges, V[] vertices) {
		    super(edges, vertices);
		  }
		
		  /** Construct a graph from edges and vertices stored in List */
		  public MyGraph(List<Edge> edges, List<V> vertices) {
		    super(edges, vertices);
		  }
		
		  /** Construct a graph for integer vertices 0, 1, 2 and edge list */
		  public MyGraph(List<Edge> edges, int numberOfVertices) {
		    super(edges, numberOfVertices);
		  }
		  
		  /** Construct a graph from integer vertices 0, 1, and edge array */
		  public MyGraph(int[][] edges, int numberOfVertices) {
		    super(edges, numberOfVertices);
		  }

		public List<List<Integer>> getConnectedComponents() {
		  List<List<Integer>> list = new ArrayList<List<Integer>>();

		  boolean[] visited = new boolean[vertices.size()];
		  //Add your code here
		  for (int v = 0; v < getSize(); v++) {
			  if (!visited[v]) {
				  list.add(getConnectedComponent(v, visited, new ArrayList<>()));
			  }
		  }

		  return list;
		}

		public List<Integer> getConnectedComponent(int v, boolean[] visited, List<Integer> list) {
			  visited[v] = true;
			  list.add(v);

			  for (int m : neighbors.get(v)) {
				  if (!visited[m]) {
					  getConnectedComponent(m, visited, list);
				  }
			  }
			  return list;
		}
	  }
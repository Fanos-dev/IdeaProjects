import java.util.ArrayList;
import java.util.List;

public class WordLadderModel {
    public List<String> words = new ArrayList<>(); //A list to hold the words to be used in the model
    protected AbstractGraph<Integer>.Tree tree; // This tree stores the model
    public WordLadderModel(List <String> words, String beginWord) {
        //add your code
        this.words = words;

        UnweightedGraph<Integer> graph = new UnweightedGraph<>(getEdges(), words.size());
        tree = graph.bfs(words.indexOf(beginWord));
    }
    public AbstractGraph<Integer>.Tree getTree(){
        return tree;
    }
    private List<AbstractGraph.Edge> getEdges() {
        List<AbstractGraph.Edge> edges = new ArrayList<>(); // Store edges
			//add your code here
            for (int i = 0; i < words.size(); i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (i == j) continue;

                    if (isOneLetterDifferent(i,j)){
                        edges.add(new AbstractGraph.Edge(i, j));
                    }
                }
            }
        return edges;
    }
	
    private boolean isOneLetterDifferent(int u, int v) {
        //add your code here
        String one = words.get(u);
        String two = words.get(v);

        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        }

	    return false; // you may need to remove this line
    }
    public void printSpanningTree(){
        // add your code here
        tree.printTree();
    }
    public void printPath(String endWord){
		//add your code here.
        tree.printPath(words.indexOf(endWord));
    }
}

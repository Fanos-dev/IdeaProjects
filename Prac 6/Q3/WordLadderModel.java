import java.util.ArrayList;
import java.util.List;

public class WordLadderModel {
    public List<String> words = new ArrayList<>(); //A list to hold the words to be used in the model
    protected AbstractGraph<Integer>.Tree tree; // This tree stores the model
    public WordLadderModel(List <String> words, String beginWord) {
        
		//add your code
		
    }
    public AbstractGraph<Integer>.Tree getTree(){
        return tree;
    }
    private List<AbstractGraph.Edge> getEdges() {
        List<AbstractGraph.Edge> edges = new ArrayList<>(); // Store edges
			
			//add your code here

        return edges;
    }
	
    private boolean isOneLetterDifferent(int u, int v) {
     
	 //add your code here
	 return true; // you may need to remove this line
	 
    }
    public void printSpanningTree(){
        // add your code here
    }
    public void printPath(String endWord){
		//add your code here.
    }
}

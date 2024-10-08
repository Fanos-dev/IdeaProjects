import java.util.Arrays;
import java.util.List;

public class TestWordLadder {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog", "hit", "hag", "hat", "bun", "bus");
        if(!wordList.contains(beginWord)|| !wordList.contains(endWord)){
            System.out.println("Either the begin word, end word or both are not in the dictionary");
            return;
        }
        WordLadderModel wlm = new WordLadderModel(wordList, beginWord);

        System.out.println("The spanning tree is: " );
        wlm.printSpanningTree();

        System.out.println("Is there a path from " + wordList.indexOf(beginWord)+ " to "+wordList.indexOf(endWord) + "?" );
        wlm.printPath(endWord);
    }
}

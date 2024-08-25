import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        HashSet<String> setOne = new HashSet<>();
        HashSet<String> setTwo = new HashSet<>();

        System.out.println("Original Sets: ");
        String[] arrOne = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        Collections.addAll(setOne, arrOne);

        String[] arrTwo = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
        Collections.addAll(setTwo, arrTwo);

        System.out.println("Set One: " + setOne);
        System.out.println("Set Two: " + setTwo);

        System.out.println("\nUnion: ");
        HashSet<String> result = new HashSet<>(setOne);
        result.addAll(setTwo);
        System.out.println(result);

        System.out.println("Difference: ");
        result = new HashSet<>(setOne);
        result.removeAll(setTwo);
        System.out.println(result);

        System.out.println("Intersection: ");
        result = new HashSet<>(setOne);
        result.retainAll(setTwo);
        System.out.println(result);

    }
}
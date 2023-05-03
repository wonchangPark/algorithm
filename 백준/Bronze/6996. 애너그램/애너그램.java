import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
            char[] word1 = first.toCharArray();
            char[] word2 = second.toCharArray();
            Arrays.sort(word1);
            Arrays.sort(word2);
            String nw1 = Arrays.toString(word1);
            String nw2 = Arrays.toString(word2);
            if(nw1.equals(nw2)) return true;
        return false;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}

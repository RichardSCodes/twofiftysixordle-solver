import java.util.*;
public class Word {
    String word;
    int[] letters = new int[130];
    public Word(String input) {
        word = input;
        for (int i = 0; i < 5; i++) {
            int index = ((int)input.charAt(i) - 96) + 26 * i - 1;
            if (letters[index] == 0) {
                letters[index] = 1;
            }
        }
    }
}

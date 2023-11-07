import java.util.*;
import java.io.*;
public class Set {
    ArrayList<Word> words;
    public Set () {
        words = new ArrayList<Word>();
    }
    public void add(String input) {
        Word word = new Word(input);
        words.add(word);
    }
    public void rm(String input) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).word.equals(input)) {
                words.remove(i);
                break;
            }
        }
    }
    public boolean checkChar(int n) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).letters[n] == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean isUnique(String input) {
        for (int i = 0; i < 5; i++) {
            int index = ((int)input.charAt(i) - 96) + 26 * i - 1;
            if (!checkChar(index)) {
                return true;
            }
        }
        return false;
    }
    public void print() {
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).word);
        }
        System.out.println("Size: " + words.size());
    }
    public static void main (String[] args) throws IOException {
        File infile = new File("src/sgb-words.txt");
        BufferedReader bfr = new BufferedReader(new FileReader(infile));
        String word = bfr.readLine();
        Set set = new Set();
        while (word != null) {
            if (set.isUnique(word)) {
                set.add(word);
                boolean solved = true;
                for (int i = 0; i < 130; i++) {
                    if (!set.checkChar(i)) {
                        solved = false;
                        break;
                    }
                }
                if (solved) {
                    break;
                }
            }
            word = bfr.readLine();
        }
        set.print();
    }
}



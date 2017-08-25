import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by AlinaCh on 25.02.2017.
 */
public class Main {

    public static HashTable<String, Integer> myMap;
    public static String[] words;

    /**
     * reads text and deletes all punctuation and makes it in lower case
     * @return input text
     * @throws FileNotFoundException
     */
    public static String read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        String input = "";
        while(sc.hasNextLine()) {
            input = input + sc.nextLine().toLowerCase().replaceAll("[.,!?;:]", " ").replaceAll("'", " '") + " ";
        }
        return input;
    }

    /**
     * writes result
     * @param s most frequent word
     */
    public static void write(String s) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("output.txt"), "ascii"))) { writer.write(s); }
        catch (IOException ex) { }
    }

    /**
     * puts words into hashTable
     */
    public static void insertWords() {
        myMap = new HashTable<>();
        myMap.hashTable();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(" ") && !words[i].equals("")) {
                if (myMap.get(words[i]) == null) {
                    myMap.add(words[i], 1);
                } else {
                    myMap.add(words[i],myMap.get(words[i]) + 1);
                }
            }
        }
    }

    /**
     * finds most frequent word by going through entrySet
     * @return
     */
    public static String getMostFrequentWord() {
        int max = 0;
        String word = "";

        ArrayList<Entry<String, Integer>> map = myMap.entrySet();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).value > max){
                max = map.get(i).value;
                word = map.get(i).key;
            }
        }
        if (!word.equals("")) {
            String res = word + " " + Integer.toString(max);
            return res;
        }
        return null;
    }

    /**
     * deletes words in the stoplist
     * @param s
     * @return
     */
    public static String delete(String s) {
        String[] delete = {"a", "the", "in", "at", "to", "on", "not", "for", "is", "are", "am", "has", "i", "we", "you"};
        for (int i = 0; i < delete.length; i++) {
            s = s.replaceAll("\\b" + delete[i] + "\\b\\s*", "");
        }
        s = s.replaceAll("'d", "").replaceAll("'s", "").replaceAll("'re", "");
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String input = read();
        words = input.split(" ");
        insertWords();
        String result = "";
        if (getMostFrequentWord() != null)
            result = getMostFrequentWord() + "\n";
        input = delete(input);
        words = input.split(" ");
        insertWords();
        if (getMostFrequentWord() != null){
            result = result + getMostFrequentWord();
        }
        write(result);
    }
}

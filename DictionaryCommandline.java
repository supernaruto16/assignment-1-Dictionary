import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class DictionaryCommandLine {
    public static void showAllWords(Dictionary dict) {
        System.out.println("No      | English           | Vietnamese");
        for(int id = 0; id < dict.getWordList().size(); ++id) {
            Word word = dict.getWordList().get(id);
            System.out.printf("%-6d|%-18s|%s\n", id + 1, word.getWord_target(), word.getWord_explain());
        }
    }

    public static void dictionaryBasic(Dictionary dict) {
        DictionaryManagement.insertFromCommandline(dict);
        showAllWords(dict);
    }

    public static void dictionaryAdvanced(Dictionary dict) {
        DictionaryManagement.insertFromFile(dict);
        showAllWords(dict);
        DictionaryManagement.dictionaryLookup(dict);
    }

    public static ArrayList<Word> dictionarySearcher(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        String word_prefix = scanner.nextLine();
        return dict.searchPrefix(word_prefix);
    }
}

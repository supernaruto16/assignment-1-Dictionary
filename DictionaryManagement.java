import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommandline(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        int numWord = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numWord; ++i) {
            String word_target = scanner.nextLine();
            String word_explain = scanner.nextLine();
            Word newWord = new Word(word_target, word_explain);
            dict.insertWord(newWord);
        }
    }
}

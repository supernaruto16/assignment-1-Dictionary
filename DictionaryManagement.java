import java.util.Scanner;
import java.io.*;

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

    public static void insertFromFile(Dictionary dict) throws IOException {
        FileReader input = null;
        try {
            input = new FileReader("dictionary.txt");
            char ch, tab  = '\t', endln = '\n', endf = (char)(-1);
            String word_target, word_explain;
            while(true) {
                word_target = "";
                word_explain = "";
                while ((ch = (char) input.read()) != tab) {
                    word_target = word_target + ch;
                }
                while ((ch = (char) input.read()) != endln && ch != endf) {
                    word_explain = word_explain + ch;
                }
                dict.insertWord(word_target, word_explain);
                if(ch == endf)
                    break;
            }
        }finally
        {
                if(input != null)
                    input.close();
        }
    }

    public static Word dictionaryLookup(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        Word resultWord = new Word("", "");
        for(Word word : dict.getWordList()) {
            if(word_target.equals(word.getWord_target()))
                resultWord = word;
        }
        if(resultWord.getWord_target() == "") {
            System.out.println("Word not found !!!");
        }
        else {
            System.out.println(resultWord.getWord_target() + "\t" + resultWord.getWord_explain());
        }
        return resultWord;
    }
}

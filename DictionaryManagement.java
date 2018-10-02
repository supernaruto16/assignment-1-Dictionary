import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class DictionaryManagement {

    public static void insertFromCommandline(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        int numWord = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numWord; ++i) {
            String word_target = scanner.nextLine();
            String word_explain = scanner.nextLine();
            dict.insertWord(word_target, word_explain);
        }
    }

    public static void removeFromCommandLine(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        dict.removeWord(word_target);
    }

    public static void replaceFromCommandLine(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        String word_explain = scanner.nextLine();
        dict.replaceWord(word_target, word_explain);
    }

    public static void insertFromFile(Dictionary dict){
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
            if(input != null)
                input.close();
        }
        catch(FileNotFoundException err) {
            System.out.println("File Not Found !!!");
        }
        catch(IOException err) {
            err.printStackTrace();
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

    public static void dictionaryExportToFile(Dictionary dict) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ArrayList <Word> wordList = dict.getWordList();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (Word word : wordList) {
                writer.write(word.getWord_target() + "\t" + word.getWord_explain());
                writer.newLine();
            }
            writer.close();
        }
        catch (FileNotFoundException err) {
            System.out.print("File not Found !!!");
        }
        catch (IOException err) {
            err.printStackTrace();
        }
    }
}

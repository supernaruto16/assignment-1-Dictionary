import java.util.Scanner;
import java.io.*;

public class Application {

    public static void main(String[] args){
        Dictionary dict = new Dictionary();
        int sign = 0;
        do {
            System.out.println("Enter number to control");
            System.out.println("0: Quit\n1: Insert Word \n2: Remove Word \n3: Edit Word" +
                    "\n4: Look Up\n5: Search\n6: Insert from 'dictionary.txt'\n7: Export to File" +
                    "\n8: Show Dictionary");
            Scanner scanner = new Scanner(System.in);
            sign = scanner.nextInt();
            switch (sign) {
                case 1: DictionaryManagement.insertFromCommandline(dict); break;
                case 2: DictionaryManagement.removeFromCommandLine(dict); break;
                case 3: DictionaryManagement.replaceFromCommandLine(dict); break;
                case 4: DictionaryManagement.dictionaryLookup(dict); break;
                case 5: DictionaryCommandLine.dictionarySearcher(dict); break;
                case 6: DictionaryManagement.insertFromFile(dict); break;
                case 7: DictionaryManagement.dictionaryExportToFile(dict); break;
                case 8: DictionaryCommandLine.showAllWords(dict); break;
            }
        }
        while(sign != 0);
    }
}

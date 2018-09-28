import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException{
        Dictionary dictionary = new Dictionary();
        DictionaryCommandLine.dictionaryBasic(dictionary);
        DictionaryCommandLine.dictionaryAdvanced(dictionary);
    }
}

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> wordList;

    public Dictionary() {
        this.wordList = new ArrayList<Word>();
    }

    public Dictionary(ArrayList<Word> wordList) {
        this.wordList = wordList;
    }

    public void insertWord(Word newWord) {
        wordList.add(newWord);
    }
    public ArrayList<Word> getWordList() {
        return wordList;
    }
}

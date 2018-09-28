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

    public void insertWord(String word_target, String word_explain) {
        Word newWord = new Word(word_target, word_explain);
        wordList.add(newWord);
    }
    public ArrayList<Word> getWordList() {
        return wordList;
    }
}

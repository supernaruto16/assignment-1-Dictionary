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

    public void removeWord(String word_target) {
        for(int i = 0; i < wordList.size(); ++i) {
            Word word = wordList.get(i);
            if (word_target.equals(word.getWord_target())) {
                wordList.remove(i);
            }
        }
    }

    public void replaceWord(String word_target, String word_explain) {
        removeWord(word_target);
        insertWord(word_target, word_explain);
    }

    public ArrayList<Word> searchPrefix(String word_prefix) {
        ArrayList <Word> searchedWord = new ArrayList<Word>();
        for(Word word : wordList) {
            if(word_prefix.equals(word.getWord_target().substring(0, word_prefix.length())))
                searchedWord.add(word);
        }
        return searchedWord;
    }

    public ArrayList<Word> getWordList() {
        return wordList;
    }
}

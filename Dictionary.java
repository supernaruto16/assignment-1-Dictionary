import java.util.ArrayList;

public class Dictionary {
    private Trie wordList;

    public Dictionary() {
        this.wordList = new Trie();
    }

    public Dictionary(ArrayList<Word> wordList) {
        for(Word word: wordList) {
            insertWord(word);
        }
    }

    public void insertWord(Word newWord) {
        wordList.insertWord(newWord);
    }

    public void insertWord(String word_target, String word_explain) {
        wordList.insertWord(word_target, word_explain);
    }

    public void removeWord(String word_target) {
        wordList.removeWord(word_target);
    }

    public void removeWord(Word word) {
        wordList.removeWord(word);
    }

    public void replaceWord(String word_target, String word_explain) {
        wordList.replaceWord(word_target, word_explain);
    }

    public Word lookUp(String word_target) {
        return wordList.lookUp(word_target);
    }

    public ArrayList<Word> searchByPrefix(String word_prefix) {
        return wordList.searchByPrefix(word_prefix);
    }

    public ArrayList<Word> getWordList() {
        return searchByPrefix("");
    }
}

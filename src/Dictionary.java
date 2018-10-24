import GoogleAPI.Translator;
import GoogleAPI.Audio;
import javazoom.jl.decoder.JavaLayerException;

import java.io.InputStream;
import java.io.IOException;
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
        Word word = wordList.lookUp(word_target);
        if(word != null) {
            return word;
        }
        else {
            Translator translator = new Translator();
            try {
                String word_explain = translator.callUrlAndParseResult("en", "vi", word_target);
                return new Word(word_target, word_explain);
            }
            catch (Exception err_2){
                throw new IllegalArgumentException("Word did not exist");
            }
        }
    }

    public void getSound(Word word) {
        Audio audio = Audio.getInstance();
        try {
            InputStream sound = audio.getAudio(word.getWord_target(), "en");
            audio.play(sound);
        } catch (IOException | JavaLayerException err) {
            err.getMessage();
        }
    }

    public ArrayList<Word> searchByPrefix(String word_prefix) {
        return wordList.searchByPrefix(word_prefix);
    }

    public ArrayList<Word> getWordList() {
        return searchByPrefix("");
    }
}

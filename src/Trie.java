import GoogleAPI.Translator;
import java.util.ArrayList;

class Node {
    Node [] children;
    Word word;
    int numWords;
    public Node() {
        children = new Node[60];
        numWords = 0;
        word = null;
    }
}

public class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public int getIndex(char ch) {
        if(ch == ' ')
            return 26;
        if(ch >= 'a' && ch <= 'z')
            return ch - 'a';
        return ch - 'A' + 27;
    }

    public void insertWord(String word_target, String word_explain) {
        Node currentNode = root;
        for(int i = 0; i < word_target.length(); ++i) {
            currentNode.numWords += 1;
            int ch = getIndex(word_target.charAt(i));
            if(currentNode.children[ch] == null)
                currentNode.children[ch] = new Node();
            currentNode = currentNode.children[ch];
        }
        currentNode.numWords += 1;
        currentNode.word = new Word(word_target, word_explain);
    }

    public void insertWord(Word word) {
        insertWord(word.getWord_target(), word.getWord_explain());
    }

    public void replaceWord(String word_target, String word_explain) {
        insertWord(word_target, word_explain);
    }

    public void replaceWord(Word word) {
        replaceWord(word.getWord_target(), word.getWord_explain());
    }

    public void removeWord(String word_target) {
        Node currentNode = root;
        if(lookUp(word_target) == null)
            throw new IllegalArgumentException("Word did not exist.");
        for(int i = 0; i < word_target.length(); ++i) {
            currentNode.numWords -= 1;
            int ch = getIndex(word_target.charAt(i));
            if(currentNode.children[ch].numWords == 1) {
                currentNode.children[ch] = null;
                break;
            }
            currentNode = currentNode.children[ch];
        }
    }

    public void removeWord(Word word) {
        removeWord(word.getWord_target());
    }

    public Word lookUp(String word_target) {
        Node currentNode = root;
        for(int i = 0; i < word_target.length(); ++i) {
            int ch = getIndex(word_target.charAt(i));
            if(currentNode.children[ch] == null)
                return null;
            currentNode = currentNode.children[ch];
        }
        return currentNode.word;
    }

    public ArrayList<Word> searchByPrefix(String word_prefix) {
        Node currentNode = root;
        for(int i = 0; i < word_prefix.length(); ++i) {
            int ch = getIndex(word_prefix.charAt(i));
            currentNode = currentNode.children[ch];
            if(currentNode == null)
                throw new IllegalArgumentException("Word did not exist");
        }
        ArrayList<Word> wordList = new ArrayList<Word>();
        visit(currentNode, wordList);
        return wordList;
    }

    void visit(Node currentNode, ArrayList<Word> wordList) {
        if(currentNode.word != null) {
            wordList.add(currentNode.word);
        }
        for(int i = 0; i < 26; ++i)
            if(currentNode.children[i] != null)
                visit(currentNode.children[i], wordList);
    }
}

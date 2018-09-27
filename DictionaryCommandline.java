public class DictionaryCommandLine {
    public static void showAllWords(Dictionary dict) {
        System.out.println("No\t| English\t | Vietnamese");
        for(int id = 0; id < dict.getWordList().size(); ++id) {
            Word word = dict.getWordList().get(id);
            System.out.println((id + 1) + "\t| " + word.getWord_target() + "\t\t\t| " + word.getWord_explain());
        }
    }
    public static void dictionaryBasic(Dictionary dict) {
        DictionaryManagement.insertFromCommandline(dict);
        showAllWords(dict);
    }
}

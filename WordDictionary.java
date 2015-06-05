public class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word !=null && word.length() > 0) {
            TrieNode t = this.root;
            for (int i = 0; i < word.length(); i++) {
                int offset = word.charAt(i) - 'a';
                if (t.children[offset] == null) {
                    t.children[offset] = new TrieNode();
                }
                t = t.children[offset];
                if (i == word.length() - 1) {
                    t.endWithWord = true;
                }
            }
        }
    }
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return this.search(this.root, word, 0);
    }
    private boolean search(TrieNode parent, String s, int i) {
        if (i == s.length()) {
            return parent.endWithWord;
        }
        char c = s.charAt(i);
        if (c == '.') {
            for (int j = 0; j < parent.children.length; j++) {
                if (parent.children[j] != null) {
                    if (this.search(parent.children[j], s, i + 1)) {
                        return true;
                    }
                }
            }
        }
        else if (c >= 'a' && c <= 'z') {
            int offset = c - 'a';
            if (parent.children[offset] != null) {
                return this.search(parent.children[offset], s, i + 1);
            }
        }
        return false;
    }
}
class TrieNode {
    boolean endWithWord;
    TrieNode[] children;
    TrieNode() {
        this.endWithWord = false;
        this.children = new TrieNode[26];
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
class TrieNode {
    public boolean withWordEnd;
    public TrieNode[] children;
    public TrieNode() {
        this.withWordEnd = false;
        this.children = new TrieNode[26];
    }
}
public class Trie {
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode n = this.root;
        if (word != null && word.length() > 0) {
            for (int i = 0, l = word.length(); i < l; i++) {
                int offset = word.charAt(i) - 'a';
                if (n.children[offset] == null) {
                    n.children[offset] = new TrieNode();
                }
                if (i == l - 1) {
                    n.children[offset].withWordEnd = true;
                }
                n = n.children[offset];
            }
        }
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode n = this.root;
        for (int i = 0, l = word.length(); i < l; i++) {
            int offset = word.charAt(i) - 'a';
            if ((n = n.children[offset]) == null) {
                return false;
            }
        }
        return n.withWordEnd;
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode n = this.root;
        for (int i = 0, l = prefix.length(); i < l; i++) {
            int offset = prefix.charAt(i) - 'a';
            if ((n = n.children[offset]) == null) {
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
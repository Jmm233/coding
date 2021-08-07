package trie;

import java.util.HashMap;
import java.util.Map;

/*
    前缀树
 */
public class TrieTree {
    public class TrieNode {
        public Map<Character, TrieNode> subNode;
        public int end;
        public int path;
        public TrieNode() {
            subNode = new HashMap<>();
            end = 0;
            path = 0;
        }
    }

    private TrieNode rootNode = new TrieNode();

    public void add(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] chs = str.toCharArray();
        TrieNode cur = rootNode;
        for (char c : chs) {
            if (!cur.subNode.containsKey(c)) {
                cur.subNode.put(c, new TrieNode());
            }
            cur = cur.subNode.get(c);
            cur.path++;
        }
        cur.end++;
    }

    public TrieNode search(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chs = str.toCharArray();
        TrieNode cur = rootNode;
        for (char c : chs) {
            if (!cur.subNode.containsKey(c)) {
                return null;
            }
            cur = cur.subNode.get(c);
        }
        return cur;
    }

    public void delete(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (search(str) == null) {
            return;
        }
        char[] chs = str.toCharArray();
        TrieNode cur = rootNode;
        for (char c : chs) {
            if (!cur.subNode.containsKey(c)) {
                return;
            }
            if (--cur.subNode.get(c).path == 0) {
                cur.subNode = null;
                return;
            }
            cur = cur.subNode.get(c);
        }
        cur.end--;
    }
}

package trie;

import java.util.HashMap;
import java.util.Map;

/*
    邮件过滤系统
 */
public class EmailFilter {
    public class EmailFilterNode {
        Map<Character, EmailFilterNode> subNode;
        int path;
        int end;
        int count;
        public EmailFilterNode() {
            subNode = new HashMap<>();
            path = 0;
            end = 0;
            count = 0;
        }
    }

    private EmailFilterNode rootNode;
    public EmailFilter() {
        rootNode = new EmailFilterNode();
    }

    /*
        添加关键词，成功后，返回当前已有关键词数量
        如果已经包含关键词，直接返回关键词数量
     */
    public int add(String str) {
        if (str == null || str.length() == 0) {
            return rootNode.count;
        }
        char[] chs = str.toCharArray();
        EmailFilterNode cur = rootNode;
        for (char c : chs) {
            if (!cur.subNode.containsKey(c)) {
                cur.subNode.put(c, new EmailFilterNode());
            }
            cur.path++;
            cur = cur.subNode.get(c);
        }
        cur.end++;
        return ++cur.count;
    }

    public EmailFilterNode search(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chs = str.toCharArray();
        EmailFilterNode cur = rootNode;
        for (char c : chs) {
            if (!cur.subNode.containsKey(c)) {
                return null;
            }
            cur = cur.subNode.get(c);
        }
        return cur;
    }

    /*
        移除关键词，如果成功移除，返回当前剩余关键词的数量
        如果不存在此关键词，直接返回-1
     */
    public int remove(String str) {
        if (search(str) == null) {
            return -1;
        }
        char[] chs = str.toCharArray();
        EmailFilterNode cur = rootNode;
        for (char c : chs) {
            if (!cur.subNode.containsKey(c)) {
                return cur.count; //都已经不存在了 应该不需要--
            }
            if (--cur.subNode.get(c).path == 0) {
                cur.subNode = null;
            }
            cur = cur.subNode.get(c);
        }
        cur.end--;
        return --cur.count;
    }

    /*
        过滤文本 并返回过滤后的文本
        有那种关键字是he和hello的关系，需要匹配最大的
     */
    public String filter(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return null;
        }
        char[] chs = sentence.toCharArray();
        StringBuilder sb = new StringBuilder();
        int position = 0, begin = 0;
        EmailFilterNode cur = rootNode;
        while (position < sentence.length()) {
            char c = chs[position];
            if (c == ' ') {
                if (cur == rootNode) {
                    sb.append(c);
                    begin++;
                }
                position++;
                continue;
            }
            cur = cur.subNode.get(c);
            if (cur == null) {
                sb.append(c);
                position = ++begin;
            } else if (cur.end > 0) { // 是敏感词
                begin = ++position;
                cur = rootNode;
            } else { // 暂时没到底
                position++;
            }
        }
        sb.append(sentence.substring(begin));
        return sb.toString();
    }
}

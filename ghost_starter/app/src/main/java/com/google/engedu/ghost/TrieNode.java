package com.google.engedu.ghost;

import java.util.HashMap;


public class TrieNode {
    private HashMap<String, TrieNode> children;
    private boolean isWord;
    private boolean isLeaf = false;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        isLeaf = false;

    }
    TrieNode root = new TrieNode();
    public void add(String s) {
        HashMap<String , TrieNode> children = root.children;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if(i==s.length()-1)
                t.isLeaf = true;
        }
    }

    public boolean isWord(String s) {
        HashMap<String, TrieNode> children = root.children;
        TrieNode t = null;
        String word1 = null;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return false;
            }
        }

        return true;

        //return false;
    }

    public String getAnyWordStartingWith(String s) {

        HashMap<String, TrieNode> children = root.children;
        TrieNode t = null;
        String word1 = null;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                word1.concat(""+c);
                children = t.children;
            }else{
                return null;
            }
        }

        return word1;
        //return null;
    }

    public String getGoodWordStartingWith(String s) {


        return null;
    }
}

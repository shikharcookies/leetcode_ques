// Node template
class Node{
    Node[] links = null;
    boolean flag;

    Node(){
        links = new Node[26];
    }

    public boolean isContainsKey(char ch){
        return links[ch-'a']!=null;
    }

    public Node get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch, Node node){
        links[ch-'a']=node;
    }

    public void setEnd(){
        flag=true;
    }

    public boolean getEnd(){
        return flag;
    }

}

// Trie DS 
class Trie{
    Node root;

    Trie(){
        root = new Node();
    }

// To insert into trie
    public void insert(String word){
        Node node = root;

        for(char ch : word.toCharArray()){
            if(!node.isContainsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    } 

// Check each word prefix
    public boolean isContainsPrefix(String word){
        Node node = root;

        for(char ch : word.toCharArray()){
            if(!node.isContainsKey(ch)){
                return false;
            }
            node = node.get(ch);
            if(!node.getEnd()){
                return false;
            }
        }

        return true;
    }
}


// TC O(N * len of each word)   + O(N * len of each word)
// 1st time insertion + 2nd time searching in trie

// SC we can not find exact SC for trie
class Solution {
     
    public String longestWord(String[] words) {
       
        // Create Trie DS and insert into the trie
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        String longestWord = "";

        for(String word : words){
           if(trie.isContainsPrefix(word)){
               // Check current word is greater than previous
               if(word.length()> longestWord.length()){
                   longestWord= word;
               }else if (word.length()== longestWord.length() && word.compareTo(longestWord)<0){
                   // if length is same check current word is lexicographically less than longest word
                    longestWord= word;
               }
           }
        }

        return longestWord;


    }
}
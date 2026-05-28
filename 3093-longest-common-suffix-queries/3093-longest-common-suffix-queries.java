class Solution {
    TrieNode root=new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n=wordsQuery.length;
        int min=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<wordsContainer.length;i++){
            StringBuilder sb=new StringBuilder(wordsContainer[i]);
            String word=sb.reverse().toString();
            if(word.length()<min){
                min=word.length();
                idx=i;
            }
            insert(word,i,wordsContainer);
        }

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder(wordsQuery[i]);
            String wordQry=sb.reverse().toString();
            int temp=Search(wordQry);
            arr[i]=temp==-1?idx:temp;
        }
        return arr;
    }
    public void insert(String word,int currIdx,String[] wordsContainer){
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];

           if(node.bestIndex==-1 || 
           word.length() < wordsContainer[node.bestIndex].length() || 
           (word.length() == wordsContainer[node.bestIndex].length() && currIdx < node.bestIndex)){
            node.bestIndex=currIdx;
           }
        }
        node.isEnd=true;
    }
    public int Search(String word){
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(node.children[idx]==null){
                return node.bestIndex;
            }
            node=node.children[idx];
        }
        return node.bestIndex;
    }
}
class TrieNode{
    TrieNode children[];
    boolean isEnd;
    int bestIndex;
    TrieNode(){
        children=new TrieNode[26];
        isEnd=false;
        bestIndex=-1;
    }
}
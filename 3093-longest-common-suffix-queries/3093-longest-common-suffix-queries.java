class Solution {
    TrieNode root=new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n=wordsQuery.length;
        int min=Integer.MAX_VALUE;
        int idx=-1;

        for(int i=0;i<wordsContainer.length;i++){
            String word=wordsContainer[i];
            if(word.length()<min){
                min=word.length();
                idx=i;
            }
            insert(word,i,wordsContainer);
        }

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            String wordQry=wordsQuery[i];
            int temp=Search(wordQry);
            arr[i]=temp==-1?idx:temp;
        }
        return arr;
        
    }
    public void insert(String word,int currIdx,String[] wordsContainer){
        TrieNode node=root;
        for(int i=word.length()-1;i>=0;i--){
            int idx=word.charAt(i)-'a';
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
        for(int i=word.length()-1;i>=0;i--){
            int idx=word.charAt(i)-'a';
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
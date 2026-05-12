class Solution {
    public int minimumEffort(int[][] tasks) {
        List<Pair> arr=new ArrayList<>();
        for(int task[]:tasks){
            arr.add(new Pair(task[0],task[1]));
        }
        Collections.sort(arr,(a,b)->(b.y-b.x)-(a.y-a.x));
        int minReq=0;
        for(int i=arr.size()-1;i>=0;i--){
            Pair task=arr.get(i);
            minReq=Math.max(task.y,minReq+task.x);
        }
        return minReq;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
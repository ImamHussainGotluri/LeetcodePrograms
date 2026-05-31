class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n=asteroids.length;
        long wt=mass;
        for(int i=0;i<n;i++){
            if(wt>=asteroids[i]){
                wt+=asteroids[i];
            }
            else{
                return false;
            }
        }
        return true;
    }
}